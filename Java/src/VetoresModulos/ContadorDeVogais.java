package VetoresModulos;

import java.util.Scanner;

public class ContadorDeVogais {

    public static int contarVogais(String frase) {
        // Inicializa o contador de vogais.
        int numeroDeVogais = 0;

        // Percorre a frase caractere a caractere.
        for (char caractere : frase.toCharArray()) {
            // Verifica se o caractere é uma vogal.
            if (Character.isLetter(caractere) && (caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u')) {
                // Incrementa o contador de vogais.
                numeroDeVogais++;
            }
        }

        // Retorna o número de vogais.
        return numeroDeVogais;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Solicita ao usuário uma frase.
        System.out.println("Digite uma palavra: ");
        String palavra = scanner.nextLine();

        // Conta o número de vogais na frase chamando a função contarVogais.
        int numeroDeVogais = contarVogais(palavra);

        // Imprime o resultado.
        System.out.println("Número de vogais: " + numeroDeVogais);
    }
}
