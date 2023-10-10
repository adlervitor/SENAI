package Matematica02;

import java.util.Scanner;

public class VolumePiramide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o volume da pirâmide: ");
        double volume = input.nextDouble();

        System.out.println("Digite a área da base da pirâmide: ");
        double area = input.nextDouble();

        double altura = (3 * volume) / area;
        System.out.println("A altura da pirâmide é: " + altura + " cm");
    }
}

