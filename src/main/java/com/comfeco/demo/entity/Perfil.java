package com.comfeco.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
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

    // private byte[] avatar;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="perfiles_conocimientos", joinColumns= @JoinColumn(name="perfil_id"),
            inverseJoinColumns=@JoinColumn(name="conocimiento_id"),
            uniqueConstraints= {@UniqueConstraint(columnNames= {"perfil_id", "conocimiento_id"})})
    private List<Conocimiento> conocimientos;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="perfiles_redes", joinColumns= @JoinColumn(name="perfil_id"),
            inverseJoinColumns=@JoinColumn(name="red_id"),
            uniqueConstraints= {@UniqueConstraint(columnNames= {"perfil_id", "red_id"})})
    private List<RedSocial> redesSociales;



}
