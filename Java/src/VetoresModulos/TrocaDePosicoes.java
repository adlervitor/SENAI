package VetoresModulos;

import java.util.Arrays;

public class TrocaDePosicoes {

    public static void trocarPosicoes(int[] array, int posicao1, int posicao2) {
        // Armazena o elemento da posição 1 em uma variável temporária.
        int temp = array[posicao1];

        // Troca os elementos das posições 1 e 2.
        array[posicao1] = array[posicao2];
        array[posicao2] = temp;
    }

    public static void main(String[] args) {
        // Cria um array de números inteiros.
        int[] array = {4, 7, 2, 1};

        // Exibe o array original.
        System.out.println("Array original: " + Arrays.toString(array));

        // Troca a posição dos elementos 1 e 2.
        trocarPosicoes(array, 0, 3);

        // Exibe o array após a troca.
        System.out.println("Array após troca: " + Arrays.toString(array));
    }
}

