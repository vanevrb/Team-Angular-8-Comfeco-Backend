package com.comfeco.demo.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode
@Embeddable
public class PerfilRedSocialPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_perfil", nullable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name="id_red_social", nullable = false)
    private RedSocial redSocial;
}
