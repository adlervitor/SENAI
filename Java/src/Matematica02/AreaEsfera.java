package Matematica02;

import java.util.Scanner;

public class AreaEsfera {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite a área da esfera: ");
        double area = input.nextDouble();

        double raio = Math.sqrt(area / (4 * Math.PI));
        System.out.println("O raio da esfera é: " + raio + " cm");
    }
}

