package Exercicios;

import java.util.Scanner;
public class Fatorial {
    public static void main(String[] args) {
        // Inicializando o scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        int fatorial = 1;
        // Loop que atualiza o fatorial
        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        System.out.println("O fatorial do número é " + fatorial);
    }
}
