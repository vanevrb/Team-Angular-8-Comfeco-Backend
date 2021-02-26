package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Comunidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComunidadRepository extends JpaRepository<Comunidad, Long> {
}
