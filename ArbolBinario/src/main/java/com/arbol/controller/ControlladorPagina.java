package com.arbol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControlladorPagina {
	
	@GetMapping("/inicio")
    public String mostrarPagina() {
        return "index";  // Redirige a la página estática
    }

}
