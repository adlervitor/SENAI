package VetoresModulos;

import java.util.Scanner;

public class EhPalindromo {

    public static boolean ehPalindromo(String palavra) {
        // Inicializa a palavra invertida.
        String palavraInvertida = "";

        // Percorre a palavra original de trás para frente.
        for (int i = palavra.length() - 1; i >= 0; i--) {
            // Adiciona o caractere atual da palavra original à palavra invertida.
            palavraInvertida += palavra.charAt(i);
        }

        // Compara a palavra original com sua versão invertida.
        return palavra.equals(palavraInvertida);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Solicita ao usuário uma palavra.
        System.out.println("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        // Verifica se a palavra é um palíndromo.
        boolean palindromo = ehPalindromo(palavra);

        // Imprime o resultado.
        if (palindromo) {
            System.out.println("A palavra é um palíndromo.");
        } else {
            System.out.println("A palavra não é um palíndromo.");
        }
    }
}
