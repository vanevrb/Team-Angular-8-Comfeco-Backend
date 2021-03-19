package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPerfilRepository extends JpaRepository<Perfil, Long> {

    @Modifying
    @Query(value="UPDATE Perfil set avatar = ?1 where id_perfil = ?2", nativeQuery = true)
    void cambiarAvatar(String avatar, Long idPerfil);
}
