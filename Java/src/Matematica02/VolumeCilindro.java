package Matematica02;

import java.util.Scanner;

public class VolumeCilindro {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o volume do cilindro: ");
        double volume = input.nextDouble();

        System.out.println("Digite a altura do cilindro: ");
        double altura = input.nextDouble();

        double raio = Math.sqrt(volume / (Math.PI * altura));
        System.out.println("O raio da base do cilindro é: " + raio + " cm");
    }
}
