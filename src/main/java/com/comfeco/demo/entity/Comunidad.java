package com.comfeco.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComunidad;

    private String nombreComunidad;

    @ManyToOne
    @JoinColumn(name="id_creador")
    private Perfil creadorComunidad;




}
