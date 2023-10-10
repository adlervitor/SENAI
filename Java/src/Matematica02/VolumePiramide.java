package Matematica02;

import java.util.Scanner;

public class VolumePiramide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o volume da pirâmide: ");
        double volume = scanner.nextDouble();

        System.out.println("Digite a área da base da pirâmide: ");
        double area = scanner.nextDouble();

        double altura = (3 * volume) / area;
        System.out.println("A altura da pirâmide é: " + altura + " cm");
    }
}

