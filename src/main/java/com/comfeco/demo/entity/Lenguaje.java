package com.comfeco.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Lenguaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLenguaje;

    @Column(length = 50, nullable = false)
    private String nombreLenguaje;
}
