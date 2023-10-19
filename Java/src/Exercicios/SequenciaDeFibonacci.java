package Exercicios;

import java.util.Scanner;
public class SequenciaDeFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        int fibonacci0 = 0;
        int fibonacci1 = 1;

        // Verifica e printa a sequencia fibonacci a cada loop
        for (int i = 0; i < numero; i++) {
            int fibonacci = fibonacci0 + fibonacci1;

            System.out.print(fibonacci + " ");

            fibonacci0 = fibonacci1;
            fibonacci1 = fibonacci;
        }

        scanner.close();
    }
}
