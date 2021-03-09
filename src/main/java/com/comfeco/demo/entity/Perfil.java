package com.comfeco.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "perfil")
    private Usuario usuario;

    private Integer genero;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @Column(length = 140)
    private String biografia;

    private String avatar;

    private Long puntaje;

    @OneToMany
    private List<Insignia> insignias;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="perfiles_conocimientos", joinColumns= @JoinColumn(name="perfil_id"),
            inverseJoinColumns=@JoinColumn(name="conocimiento_id"),
            uniqueConstraints= {@UniqueConstraint(columnNames= {"perfil_id", "conocimiento_id"})})
    private List<Conocimiento> conocimientos;


    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PerfilRedSocial> redesSociales;

    @PrePersist
    void prePersist(){
        this.puntaje = Long.valueOf(0);
    }

}
