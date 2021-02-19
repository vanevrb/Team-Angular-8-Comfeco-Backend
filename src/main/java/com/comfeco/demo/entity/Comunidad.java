package com.comfeco.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComunidad;

    private String nombreComunidad;

    private Usuario creadorComunidad;


}
