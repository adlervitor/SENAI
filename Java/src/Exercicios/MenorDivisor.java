package Exercicios;

import java.util.Scanner;
public class MenorDivisor {
    public static void main(String[] args) {
        // Inicializa o scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        // O scanner lê o proximo inteiro digitado pelo usuário
        int numero = scanner.nextInt();

        int menorDivisor = 1;

        // Atualiza o menor divisor em cada loop
        for (int i = menorDivisor; i >= numero; i++) {
            if (numero % i == 0) {
                menorDivisor = i;
            }
        }

        System.out.println("O menor divisor do número é " + menorDivisor);

        // Fecha o scanner
        scanner.close();
    }
}
