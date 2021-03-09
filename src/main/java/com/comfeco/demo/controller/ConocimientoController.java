package com.comfeco.demo.controller;

import com.comfeco.demo.entity.Conocimiento;
import com.comfeco.demo.service.IConocimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/conocimiento")
public class ConocimientoController {

    @Autowired
    private IConocimientoService conocimientoService;

    @GetMapping
    private ResponseEntity<List<Conocimiento>> listar(){
        return new ResponseEntity<>(this.conocimientoService.listar(), HttpStatus.OK);
    }
}
