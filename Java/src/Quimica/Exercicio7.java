package Quimica;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a altura em metros: ");

        // Usuário insere a altura
        double altura = scanner.nextDouble();

        System.out.print("Entre com a aceleração gravitacional em m/s²: ");

        // Usuário insere a aceleração gravitacional
        double aceleracao = scanner.nextDouble();

        // Lógica de cálculo da velocidade final
        double velocidadeFinal = Math.sqrt(2 * aceleracao * altura);
        System.out.println("A velocidade final é " + velocidadeFinal + " m/s.");
    }
}
