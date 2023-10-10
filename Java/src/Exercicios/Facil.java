package Exercicios;

import java.util.Scanner;

public class Facil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int numero1 = scanner.nextInt();

        System.out.println("Digite mais um número: ");
        int numero2 = scanner.nextInt();

        System.out.println("Digite outro número: ");
        int numero3 = scanner.nextInt();

        int soma = numero1 + numero2 + numero3;
        int media = soma / 3;

        System.out.println("A soma dos números é: " + soma);
        System.out.println("A média dos números é: " + media);
    }
}
