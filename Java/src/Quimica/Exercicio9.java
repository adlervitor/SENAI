package Quimica;

import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a tensão em volts: ");
        double tensao = scanner.nextDouble();
        System.out.print("Entre com a corrente em amperes: ");
        double corrente = scanner.nextDouble();

        double resistencia = tensao / corrente;
        System.out.println("A resistência é " + resistencia + " ohms.");
    }
}
