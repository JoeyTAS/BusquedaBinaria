package com.arbol.service;
import org.springframework.stereotype.Service;

import com.arbol.entidad.Trie;

import jakarta.annotation.PostConstruct;

import java.io.*;
import java.util.List;

@Service
public class TrieService {
    private static final String RUTA_ARCHIVO = "D:\\SpringJava\\ArbolBinario\\src\\main\\java\\com\\arbol\\entidad\\palabras.txt";
    private final Trie trie;

    public TrieService() {
        trie = new Trie();
    }

    // Cargar palabras del archivo al iniciar la aplicación
    @PostConstruct
    public void cargarPalabrasDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String palabra;
            while ((palabra = reader.readLine()) != null) {
                palabra = palabra.trim();
                if (!palabra.isEmpty()) {
                    trie.insertar(palabra);
                }
            }
            System.out.println("Palabras cargadas exitosamente desde el archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // Agregar palabra al Trie y guardarla en el archivo
    public void agregarPalabra(String palabra) {
        trie.insertar(palabra);
        guardarPalabraEnArchivo(palabra);
    }

    // Guardar una palabra en el archivo
    private void guardarPalabraEnArchivo(String palabra) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO, true))) { // true para agregar al final del archivo
            writer.write(palabra);
            writer.newLine();
            System.out.println("Palabra guardada en el archivo: " + palabra);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // Obtener sugerencias de autocompletado
    public List<String> obtenerSugerencias(String prefijo) {
        return trie.predecir(prefijo);
    }
}
