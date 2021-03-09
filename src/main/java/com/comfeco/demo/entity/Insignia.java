package com.comfeco.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Insignia {

    @Id
    private Long idInsignia;

    private String nombreInsignia;

    private String icono;

    private Long puntaje;
}
