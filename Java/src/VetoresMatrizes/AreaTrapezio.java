package VetoresMatrizes;

import java.util.Scanner;

public class AreaTrapezio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a base maior do trapézio: ");
        double baseMaior = scanner.nextDouble();

        System.out.print("Digite a base menor do trapézio: ");
        double baseMenor = scanner.nextDouble();

        System.out.print("Digite a altura do trapézio: ");
        double altura = scanner.nextDouble();

        double area = calcularAreaTrapezio(baseMaior, baseMenor, altura);
        System.out.println("Área do trapézio: " + area);

        scanner.close();
    }

    public static double calcularAreaTrapezio(double baseMaior, double baseMenor, double altura) {
        return (baseMaior + baseMenor) * altura / 2;
    }
}
