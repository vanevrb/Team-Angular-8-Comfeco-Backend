package com.comfeco.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rol_id")
    private Integer rolId;

    @Column(name="rol_descripcion")
    private String rolDescripcion;

    @Column(name="rol_titulo")
    private String rolTitulo;

}
