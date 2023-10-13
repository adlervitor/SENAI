package Quimica;

import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com o número de carbonos na cadeia carbônica: ");
        int numCarbonos = scanner.nextInt();

        int numCarbonosPrimarios = numCarbonos - 2;
        System.out.println("A cadeia possui " + numCarbonosPrimarios + " carbonos primários.");
    }
}
