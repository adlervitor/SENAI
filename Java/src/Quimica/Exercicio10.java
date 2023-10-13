package Quimica;

import java.util.Scanner;

public class Exercicio10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a tensão em volts: ");
        double tensao = scanner.nextDouble();
        System.out.print("Entre com a resistência em ohms: ");
        double resistencia = scanner.nextDouble();

        double potencia = (tensao * tensao) / resistencia;
        System.out.println("A potência dissipada é " + potencia + " watts.");
    }
}
