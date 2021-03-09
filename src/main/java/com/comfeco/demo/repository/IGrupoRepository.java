package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGrupoRepository extends JpaRepository<Grupo, Long> {
}
