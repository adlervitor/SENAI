package VetoresModulos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemocaoDeRepetidos {

    public static List<Integer> removerElementosRepetidos(List<Integer> lista) {
        // Cria um HashSet para armazenar os elementos únicos da lista.
        HashSet<Integer> conjunto = new HashSet<>();

        // Itera sobre a lista e adiciona os elementos únicos ao HashSet.
        for (Integer numero : lista) {
            conjunto.add(numero);
        }

        // Retorna a lista sem elementos repetidos.
        return new ArrayList<>(conjunto);
    }

    public static void main(String[] args) {
        // Cria uma lista com elementos repetidos.
        List<Integer> lista = Arrays.asList(1, 2, 3, 2, 1, 4, 5, 3);

        // Remove os elementos repetidos da lista.
        List<Integer> listaSemRepetidos = removerElementosRepetidos(lista);

        // Imprime a lista sem elementos repetidos.
        System.out.println("Lista original: " + lista);
        System.out.println("Lista sem elementos repetidos: " + listaSemRepetidos);
    }
}

