package com.comfeco.demo.dto.request;

import lombok.Data;

@Data
public class ChangePasswordDTO {

    public String tokenId;
    public String clave;

}
