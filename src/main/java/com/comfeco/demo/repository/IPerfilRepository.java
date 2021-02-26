package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPerfilRepository extends JpaRepository<Perfil, Long> {
}
