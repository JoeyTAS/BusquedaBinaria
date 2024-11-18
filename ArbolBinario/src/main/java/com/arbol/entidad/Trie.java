package com.arbol.entidad;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {
    private TrieNode raiz;

    public Trie() {
        raiz = new TrieNode();
    }


    public void insertar(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            throw new IllegalArgumentException("La palabra no puede ser nula o vacía.");
        }
        insertarRecursivo(raiz, palabra, 0);
    }

    // Método recursivo para insertar cada carácter de la palabra
    private void insertarRecursivo(TrieNode nodoActual, String palabra, int index) {
        
        if (index == palabra.length()) {
            nodoActual.setEsFinDePalabra(true);
            return;
        }

        char c = palabra.charAt(index); // Obtener el carácter actual
        TrieNode hijo = nodoActual.getHijo(c);

        if (hijo == null) {
            hijo = new TrieNode();
            nodoActual.agregarHijo(c, hijo);
        }

        
        insertarRecursivo(hijo, palabra, index + 1);
    }

    // Método para buscar palabras por prefijo
    public List<String> predecir(String prefijo) {
        List<String> resultados = new ArrayList<>();
        TrieNode nodoActual = buscarNodoPorPrefijo(raiz, prefijo, 0); // Buscar el nodo correspondiente al prefijo
        if (nodoActual != null) {
            buscarPalabras(nodoActual, prefijo, resultados); // Buscar palabras a partir del nodo
        }
        return resultados;
    }

    // Método recursivo para buscar el nodo correspondiente al prefijo
    private TrieNode buscarNodoPorPrefijo(TrieNode nodoActual, String prefijo, int index) {
        if (index == prefijo.length()) {
            return nodoActual; // Si hemos llegado al final del prefijo, devuelve el nodo actual
        }

        char c = prefijo.charAt(index);
        nodoActual = nodoActual.getHijo(c);

        return (nodoActual != null) ? buscarNodoPorPrefijo(nodoActual, prefijo, index + 1) : null; // Llamada recursiva
    }

    // Método recursivo para encontrar todas las palabras a partir de un nodo dado
    private void buscarPalabras(TrieNode nodo, String prefijo, List<String> resultados) {
        if (nodo.isEsFinDePalabra()) {
            resultados.add(prefijo); 
        }
        // Recorre los hijos de manera recursiva
        for (Map.Entry<Character, TrieNode> entrada : nodo.getHijos().entrySet()) {
            buscarPalabras(entrada.getValue(), prefijo + entrada.getKey(), resultados);
        }
    }
}