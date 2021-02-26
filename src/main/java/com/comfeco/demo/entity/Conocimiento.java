package com.comfeco.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Conocimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConocimiento;

    private String nombreConocimiento;
}
