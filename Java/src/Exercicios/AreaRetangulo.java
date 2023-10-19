package Exercicios;

import java.util.Scanner;

public class AreaRetangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Usuário digita a base
        System.out.println("Digite a base do retângulo: ");
        int base = scanner.nextInt();
        // Usuário solicita a altura
        System.out.println("Digite a altura do retângulo: ");
        int altura = scanner.nextInt();
        // Printa a área do retângulo
        System.out.println("A área do retângulo é: " + base * altura);
    }
}
