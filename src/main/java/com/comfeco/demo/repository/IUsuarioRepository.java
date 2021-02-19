package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByUsuCorreo(String usuCorreo);

    Usuario findUsuarioByUsuNickname(String usuNickname);

    @Modifying
    @Query(value="INSERT INTO usuario_rol(usu_id, rol_id) VALUES (:idUsuario, :idRol)", nativeQuery = true)
    void registrarRolPorDefecto(@Param("idUsuario") Long idUsuario, @Param("idRol") Integer idRol);

    @Modifying
    @Query(value="UPDATE Usuario as u set usu_clave = ?1 from confirmation_token as ct where u.usu_id = ct.user_id and ct.confirmation_token = ?2 and ct.estado = true", nativeQuery = true)
    void actualizarClave(String password, String tokenId);
}
