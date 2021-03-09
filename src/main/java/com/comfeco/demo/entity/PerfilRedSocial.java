package com.comfeco.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "perfil_redsocial")
@IdClass(PerfilRedSocialPK.class)
public class PerfilRedSocial implements Serializable {

    @Id
    @JsonBackReference
    private Perfil perfil;

    @Id
    private RedSocial redSocial;

    private String usuario;


}
