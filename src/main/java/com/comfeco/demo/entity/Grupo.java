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

    @Column(length = 250)
    private String imagen;

    @ManyToOne
    private Lenguaje lenguaje;

    @ManyToOne
    @JoinColumn(name = "id_creador")
    private Perfil creador;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="grupos_perfiles", joinColumns= @JoinColumn(name="perfil_id"),
            inverseJoinColumns=@JoinColumn(name="grupo_id"),
            uniqueConstraints= {@UniqueConstraint(columnNames= {"grupo_id", "perfil_id"})})
    private List<Perfil> perfiles;

    @PrePersist
    void prePersist(){
        this.perfiles.add(creador);
    }
}
