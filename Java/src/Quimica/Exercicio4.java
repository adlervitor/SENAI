package Quimica;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a quantidade de mols: ");
        double mols = scanner.nextDouble();
        System.out.print("Entre com a massa molar em g/mol: ");
        double massaMolar = scanner.nextDouble();

        double massa = mols * massaMolar;
        System.out.println("A massa é " + massa + "g.");
    }
}

