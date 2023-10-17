package VetoresModulos;

import java.util.Arrays;
import java.util.List;

public class OrdenadorDeNumeros {

    public static void bubbleSort(List<Integer> lista) {
        // Realiza um loop para cada elemento da lista.
        for (int i = 0; i < lista.size() - 1; i++) {
            // Realiza um loop para cada elemento após o i-ésimo elemento.
            for (int j = i + 1; j < lista.size(); j++) {
                // Se o elemento atual for maior que o elemento anterior, então troca os dois elementos.
                if (lista.get(i) > lista.get(j)) {
                    int aux = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, aux);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Cria uma lista com os números 5, 2, 8, 1, 9, 3.
        List<Integer> lista = Arrays.asList(5, 2, 8, 1, 9, 3);

        // Imprime a lista original.
        System.out.println("Lista original: " + lista);

        // Ordena a lista.
        bubbleSort(lista);

        // Imprime a lista ordenada.
        System.out.println("Lista ordenada: " + lista);
    }
}

