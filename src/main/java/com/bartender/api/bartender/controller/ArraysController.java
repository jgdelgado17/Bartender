package com.bartender.api.bartender.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import com.bartender.api.bartender.logical.Logica;
import com.bartender.api.bartender.model.Arrayss;
import com.bartender.api.bartender.service.ArraysService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bartender")
public class ArraysController {

    @Autowired
    private ArraysService serviceArrays;

    @Autowired
    private Logica logica;

    /**
     * Se encarga de preparar los parametros para mandar a contruir la respuesta.
     * 
     * @param q  Número de iteraciones Q
     * @param id Número del 1 al 5 que representa el id de la pila
     * @return
     */
    @GetMapping("/{q},{id}")
    public ResponseEntity<ArrayList<Integer>> respuesta(@PathVariable("q") Integer q,
            @Valid @PathVariable("id") Integer id) {

        ResponseEntity<Arrayss> entidad;
        String cadena;

        entidad = findById(id); // Buscamos el registro por el id entregado en la API.
        cadena = entidad.getBody().getInput_array(); // Obtenemos el campo que contiene los números
        ArrayList<Integer> rta = logica.construirrespuesta(q, cadena);

        return ResponseEntity.ok(rta);
    }

    /**
     * Método que valiendose de JPA busca el registro con el array en la base de
     * datos por id
     * 
     * @param id id del registro que se desea buscar
     * @return una entidad de la base de datos con la respuestas
     */
    public ResponseEntity<Arrayss> findById(@Valid Integer id) {
        return serviceArrays.findById(id)
                .map(ResponseEntity::ok) // Si fue encontrado correctamente retorne OK (código HTTP 200)
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no fue encontrado retorne error 404
    }

}
