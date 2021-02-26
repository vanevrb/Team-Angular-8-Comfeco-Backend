package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepository extends JpaRepository<Pais, Long> {
}
