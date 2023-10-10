package Exercicios;

import java.util.Scanner;
public class Primo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        boolean primo = true;

        // Verifica se o número não é primo, ocasião em que o booleano primo mudará pra false
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                primo = false;
                break;
            }
        }

        if (primo) {
            System.out.println("O número é primo!");
        } else {
            System.out.println("O número não é primo!");
        }

        scanner.close();
    }
}