package com.comfeco.demo.repository;

import com.comfeco.demo.entity.Conocimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConocimientoRepository extends JpaRepository<Conocimiento, Long> {
}
