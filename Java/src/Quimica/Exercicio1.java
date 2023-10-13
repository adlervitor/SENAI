package Quimica;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com o número de carbonos: ");
        int numCarbonos = scanner.nextInt();

        int numHidrogenios = numCarbonos * 4;
        System.out.println("A cadeia possui " + numHidrogenios + " hidrogênios.");
    }
}

