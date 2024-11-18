package com.arbol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arbol.service.TrieService;

@RestController
@RequestMapping("/api/autocompletar") 
public class AutocompletarController {

    private final TrieService trieService;

    @Autowired
    public AutocompletarController(TrieService trieService) {
        this.trieService = trieService;
    }

    @RequestMapping(value = "/agregar", method = {RequestMethod.POST, RequestMethod.GET})
    public String agregarPalabra(@RequestParam String palabra) {
        trieService.agregarPalabra(palabra);
        return "Palabra agregada: " + palabra;  
    }

    @GetMapping("/sugerencias")
    public List<String> obtenerSugerencias(@RequestParam String prefijo) {
        return trieService.obtenerSugerencias(prefijo);
    }

}


