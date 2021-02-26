package com.comfeco.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuId;

    @Column(unique = true)
    private String usuNickname;

    @Column(unique = true)
    private String usuCorreo;

    private String usuClave;

    private Boolean usuEstado;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name="id_usuario", nullable = false)
    private Perfil perfil;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = {@JoinColumn(name = "usuId")},
            inverseJoinColumns = {@JoinColumn(name = "rolId")})
    private List<Rol> roles;

    @PrePersist
    void prePersist(){
        this.usuEstado = true;
    }

}
