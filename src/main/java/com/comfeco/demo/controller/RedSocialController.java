package com.comfeco.demo.controller;

import com.comfeco.demo.entity.RedSocial;
import com.comfeco.demo.service.IRedSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/red-social")
public class RedSocialController {

    @Autowired
    private IRedSocialService redSocialService;

    @GetMapping
    private ResponseEntity<List<RedSocial>> listar(){
        return new ResponseEntity<>(this.redSocialService.listar(), HttpStatus.OK);
    }
}
