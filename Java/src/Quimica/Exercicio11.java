package Quimica;

import java.util.Scanner;

public class Exercicio11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a massa do objeto em kg: ");
        double massa = scanner.nextDouble();
        System.out.print("Entre com a aceleração desejada em m/s²: ");
        double aceleracao = scanner.nextDouble();

        // Lógica para o cálculo da força
        double forca = massa * aceleracao;
        System.out.println("A força necessária é " + forca + " N (newtons).");
    }
}
