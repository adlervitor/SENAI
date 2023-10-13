package Quimica;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a massa em gramas: ");
        double massa = scanner.nextDouble();
        System.out.print("Entre com a massa molar em g/mol: ");
        double massaMolar = scanner.nextDouble();

        double mols = massa / massaMolar;
        System.out.println("A quantidade de mols é " + mols);
    }
}

