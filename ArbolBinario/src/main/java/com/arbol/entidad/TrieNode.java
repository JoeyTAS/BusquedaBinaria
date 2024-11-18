package com.arbol.entidad;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private Map<Character, TrieNode> hijos;
    private boolean esFinDePalabra;

    public TrieNode() {
        this.hijos = new HashMap<>();
        this.esFinDePalabra = false;
    }

 
    public Map<Character, TrieNode> getHijos() {
        return hijos;
    }

   
    public void setHijos(Map<Character, TrieNode> hijos) {
        this.hijos = hijos;
    }

    
    public void agregarHijo(Character caracter, TrieNode nodo) {
        this.hijos.put(caracter, nodo);
    }

  
    public TrieNode getHijo(Character caracter) {
        return this.hijos.get(caracter);
    }

   
    public boolean isEsFinDePalabra() {
        return esFinDePalabra;
    }

   
    public void setEsFinDePalabra(boolean esFinDePalabra) {
        this.esFinDePalabra = esFinDePalabra;
    }
}  

