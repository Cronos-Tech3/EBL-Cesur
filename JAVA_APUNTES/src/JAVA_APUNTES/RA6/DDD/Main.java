package JAVA_APUNTES.RA6.DDD;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("uno", 1);
        mapa.put("dos", 2);

        // Probar métodos de CollectionProcessor
        System.out.println("Suma de la colección: " + CollectionProcessor.sum(numeros));
        System.out.println("Añadir valor a la colección: " + CollectionProcessor.addValue(numeros, 6));
        System.out.println("Eliminar primer elemento de la colección: " + CollectionProcessor.deleteFirst(numeros));
        System.out.println("Añadir valor y obtener el primero: " + CollectionProcessor.addValueGetFirst(numeros, 7));
        System.out.println("Comprobar y añadir valor en la colección: " + CollectionProcessor.checkValue(numeros, 8));
        System.out.println("Comprobar y añadir valor en el mapa: " + CollectionProcessor.checkValue(mapa, "tres", 3));
    }
}

class CollectionProcessor {
    public static int sum(Collection<Integer> coleccion) {
        int suma = 0;
        for (int numero : coleccion) {
            suma += numero;
        }
        return suma;
    }

    public static <T> boolean addValue(Collection<T> coleccion, T elemento) {
        return coleccion.add(elemento);
    }

    public static <K, V> boolean addValue(Map<K, V> mapa, K clave, V valor) {
        mapa.put(clave, valor);
        return true;
    }

    public static <T> boolean deleteFirst(Collection<T> coleccion) {
        Iterator<T> iterador = coleccion.iterator();
        if (iterador.hasNext()) {
            iterador.next();
            iterador.remove();
            return true;
        }
        return false;
    }

    public static <T> T addValueGetFirst(Collection<T> coleccion, T elemento) {
        coleccion.add(elemento);
        Iterator<T> iterador = coleccion.iterator();
        return iterador.hasNext() ? iterador.next() : null;
    }

    public static <K, V> V addValueGetFirst(Map<K, V> mapa, K clave, V valor) {
        mapa.put(clave, valor);
        return mapa.values().iterator().next();
    }

    public static <T> boolean checkValue(Collection<T> coleccion, T valor) {
        if (!coleccion.contains(valor)) {
            coleccion.add(valor);
            return true;
        }
        return false;
    }

    public static <K, V> boolean checkValue(Map<K, V> mapa, K clave, V valor) {
        if (!mapa.containsKey(clave)) {
            mapa.put(clave, valor);
            return true;
        }
        return false;
    }
}

