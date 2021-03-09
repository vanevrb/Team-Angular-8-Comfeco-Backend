package com.comfeco.demo.controller;

import com.comfeco.demo.entity.Pais;
import com.comfeco.demo.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private IPaisService paisService;

    @GetMapping
    private ResponseEntity<List<Pais>> listar(){
        return new ResponseEntity<>(this.paisService.listar(), HttpStatus.OK);
    }
}
