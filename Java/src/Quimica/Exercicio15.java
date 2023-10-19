package Quimica;

import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com um número real não negativo: ");
        double numero = scanner.nextDouble();

        // Condicional que verifica se o número é negativo
        if (numero >= 0) {
            double raizQuadrada = Math.sqrt(numero);
            System.out.println("A raiz quadrada de " + numero + " é " + raizQuadrada + ".");
        } else {
            System.out.println("O número não é não negativo.");
        }
    }
}
