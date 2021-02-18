package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByUsuCorreo(String usuCorreo);

    @Modifying
    @Query(value="INSERT INTO usuario_rol(usu_id, rol_id) VALUES (:idUsuario, :idRol)", nativeQuery = true)
    void registrarRolPorDefecto(@Param("idUsuario") Long idUsuario, @Param("idRol") Integer idRol);

    @Modifying
    @Query(value="UPDATE u set usu_clave = ?1 from Usuario u join Confirmation_Token ct on u.usu_id = ct.user_id where ct.token_id = ?2 and ct.estado = 1", nativeQuery = true)
    void actualizarClave(String password, String tokenId);
}
