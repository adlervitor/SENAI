package Quimica;

import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com um número real: ");
        double numero = scanner.nextDouble();

        // Utilizamos a biblioteca Math para calcular o valor absoluto do número
        double valorAbsoluto = Math.abs(numero);
        System.out.println("O valor absoluto de " + numero + " é " + valorAbsoluto + ".");
    }
}
