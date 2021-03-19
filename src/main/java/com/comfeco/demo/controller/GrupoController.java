package com.comfeco.demo.controller;

import com.comfeco.demo.entity.Grupo;
import com.comfeco.demo.service.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    @Autowired
    private IGrupoService grupoService;

    @GetMapping
    private ResponseEntity<?> listar(){
        return new ResponseEntity<>(this.grupoService.listar(), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    private ResponseEntity<?> agregar(@RequestBody Grupo grupo){
        Grupo rs = this.grupoService.registrar(grupo);
        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

}
