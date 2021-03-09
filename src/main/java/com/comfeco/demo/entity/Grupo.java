package com.comfeco.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Grupo {

    @Id
    private Long idGrupo;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 100)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_creador")
    private Perfil creador;

    @OneToMany
    private List<Perfil> perfil;
}
