package com.bartender.api.bartender.logical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.springframework.stereotype.Component;

/**
 * Clase que contiene toda la lógica del ejercicio.
 * 1. Determinar si un número es primo ó no
 * 2. Determinar el enesimo primo para simular el array de primos P y que sea dinámico
 * 3. Construir el array con la respuesta donde se van agregando los vasos cuyo 
 * número es divisible entre el primo Pi
 */
@Component
public class Logica {
    /**
     * Verifica si un número x es primo ó no
     * 
     * @param x Número que deseamos verificar si es primo
     * @return Retorna un booleano, true si el número x es primo o false en caso
     *         contrario
     */
    private boolean esPrimo(int x) {
        if ((x < 2) || (x == 4)) {
            return false;
        }
        int i = 2;
        while (i < x / 2) {
            if (x % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    /**
     * Obtiene el enesimo primo de los números naurales positivos.
     * Por ejemplo, el primo número 10000 es el 10479
     * 
     * @param n Enesimo primo que deseamos saber
     * @return Retorna un número entero con el enesimo primo
     */
    private int nPrimo(int n) {
        int numero = 0;
        int cantidad = 0;

        while (cantidad < n) {
            if (esPrimo(numero)) {
                cantidad++;
            }
            numero++;
        }
        return numero - 1;
    }

    /**
     * Agrega los elementos a la respuesta
     * 
     * @param arr ArrayList con los elementos que se agregarán a la respuesta
     * @param res ArrayList donde se van agregando los elementos a la respuesta
     */
    private void agregarElementos(ArrayList<Integer> arr, ArrayList<Integer> res) {
        Iterator<Integer> it = arr.iterator();
        while (it.hasNext()) {
            res.add(it.next());
            it.remove(); // Limpiamos el iterador para la siguiente iteración
        }
    }

    /**
     * Recibe la cadena de números y la convierte a ArrayList de números.
     * 1. Convierte la cadena a aun Array de String
     * 2. Convierte el Array de Sting a ArraList de String
     * 3. Convierte el ArrayList de String a ArrayList de Integer
     * @param cadena String que contiene los números
     * @return ArrayList de Integer
     */
    private ArrayList<Integer> stringTOarray(String cadena) {
        String[] array = cadena.split(",");

        ArrayList<String> a0 = new ArrayList<String>(Arrays.asList(array));

        ArrayList<Integer> aI = new ArrayList<Integer>();

        for (String i : a0) {
            aI.add(Integer.parseInt(i));
        }
        return aI;
    }

    /**
     * Construye el array de respuesta donde se van agregando los vasos
     * cuyo número es divisible por el enesimo primo Pi y agrega los restantes al final
     * @param q Número de iteraciones Q
     * @param cadena String que contiene los numeros del array de entrada
     * @return ArrayList de Integer con la respuesta
     */
    public ArrayList<Integer> construirrespuesta(int q, String cadena){

        ArrayList<Integer> aI = stringTOarray(cadena);
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> respuesta = new ArrayList<Integer>();

        for (int qI = 1; qI <= q; qI++) {

            Iterator<Integer> it = aI.iterator();
            while (it.hasNext()) {
                int p = it.next();
                if (p % nPrimo(qI) == 0) { //Determina si el número del plato es divisible uniformemente por el Pi número primo
                    b.add(0, p); //Si lo es, agréguelo en un arreglo B. (En forma de pila)
                    it.remove(); //Retiramos los que ya cumplierón la condición para seguir validando los que aún no cumplen
                }
            }
            // Agregamos los que cumplen la condición despues de la respuesta anterior. (En forma de cola)
            agregarElementos(b,respuesta);
        }

        // Como Q ya se completó, agregamos los elementos restantes a la respuesta
        agregarElementos(aI,respuesta);
        // System.out.println(respuesta);
        return respuesta;
    }
}
