package Exercicios;

import java.util.Scanner;
public class MaiorDeDoisNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o primeiro número:");
        int primeiroNumero = scanner.nextInt();

        System.out.println("Informe o segundo número:");
        int segundoNumero = scanner.nextInt();
        // Utilizamos o método max da biblioteca Math que por sua vez recebe 2 parâmetros retornando o maior
        int maiorNumero = Math.max(primeiroNumero, segundoNumero);

        System.out.println("O maior número é " + maiorNumero);

        scanner.close();
    }
}
