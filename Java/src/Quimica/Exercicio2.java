package Quimica;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com o número de carbonos: ");
        // Usuário digita a quantidade de carbonos
        int numCarbonos = scanner.nextInt();
        // Lógica que calcula os carbonos
        int numCarbonosSecundarios = numCarbonos - 2;
        int numCarbonosTerciarios = 1;

        System.out.println("A cadeia possui " + numCarbonosSecundarios + " carbonos secundários e " + numCarbonosTerciarios + " carbono terciário.");
    }
}

