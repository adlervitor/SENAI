package Matematica01;

import java.util.Scanner;

public class AreaTrapezio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double baseMaior, baseMenor, altura;

        System.out.println("Digite a base maior do trapézio:");
        baseMaior = scanner.nextDouble();

        System.out.println("Digite a base menor do trapézio:");
        baseMenor = scanner.nextDouble();

        System.out.println("Digite a altura do trapézio:");
        altura = scanner.nextDouble();

        double area = (baseMaior + baseMenor) * altura / 2;

        System.out.println("A área do trapézio é: " + area);
    }
}
