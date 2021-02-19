package com.comfeco.demo.controller;

import com.comfeco.demo.dto.request.ChangePasswordDTO;
import com.comfeco.demo.entity.ConfirmationToken;
import com.comfeco.demo.exception.ModeloNotFoundException;
import com.comfeco.demo.service.IConfirmationTokenService;
import com.comfeco.demo.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/confirmation")
public class ConfirmationTokenController {

    @Autowired
    private IConfirmationTokenService confirmationTokenService;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping(value="/change-password")
    private ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        Map<String, Object> rs = new HashMap<>();

        changePasswordDTO.setClave(bcrypt.encode(changePasswordDTO.getClave()));

        ConfirmationToken ct = confirmationTokenService.findByConfirmationToken(changePasswordDTO.tokenId);

        if(ct.getTokenid() != null) {
            usuarioService.actualizarClaveTransaccional(changePasswordDTO);
            confirmationTokenService.desactivarToken(changePasswordDTO.tokenId);
            rs.put("message", "Contraseña cambiada correctamente");
            rs.put("code", 200);
            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            rs.put("message", "Token no encontrado y/o expirado");
            rs.put("code", 500);
            return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
        }
    }
}
