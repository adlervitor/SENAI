package Quimica;

import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com o raio da esfera em cm: ");
        double raio = scanner.nextDouble();

        double areaSuperficie = 4 * Math.PI * raio * raio;
        System.out.println("A área da superfície da esfera é aproximadamente " + areaSuperficie + " cm².");
    }
}
