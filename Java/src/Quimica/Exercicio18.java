package Quimica;

import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a fórmula estrutural da molécula (ex. C6H6): ");
        String formulaEstrutural = scanner.nextLine();

        if (formulaEstrutural.contains("C6H6")) {
            System.out.println("A molécula é aromática.");
        } else if (formulaEstrutural.contains("C") && formulaEstrutural.contains("H")) {
            System.out.println("A molécula é insaturada.");
        } else {
            System.out.println("A molécula é saturada.");
        }
    }
}
