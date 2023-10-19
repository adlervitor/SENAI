package Exercicios;

import java.util.Scanner;

public class PerimetroCirculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o raio do círculo: ");
        int raio = scanner.nextInt();
        // Lógica para calcular a área
        double area = Math.PI * raio * raio;
        // Lógica para calcular o perímetro
        double perimetro = 2 * Math.PI * raio;

        System.out.println("A área do círculo é: " + area);
        System.out.println("O perímetro do círculo é: " + perimetro);
    }
}
