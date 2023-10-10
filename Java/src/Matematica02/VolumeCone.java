package Matematica02;

import java.util.Scanner;

public class VolumeCone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o volume do cone: ");
        double volume = input.nextDouble();

        System.out.println("Digite a altura do cone: ");
        double altura = input.nextDouble();

        double raio = Math.sqrt(3 * volume / (Math.PI * altura));
        System.out.println("O raio da base do cone é: " + raio);
    }
}

