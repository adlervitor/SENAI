package Quimica;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a altura em metros: ");
        double altura = scanner.nextDouble();
        System.out.print("Entre com a aceleração gravitacional em m/s²: ");
        double aceleracao = scanner.nextDouble();

        double velocidadeFinal = Math.sqrt(2 * aceleracao * altura);
        System.out.println("A velocidade final é " + velocidadeFinal + " m/s.");
    }
}
