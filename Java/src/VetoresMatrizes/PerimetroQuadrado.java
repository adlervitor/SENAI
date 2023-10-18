package VetoresMatrizes;

import java.util.Scanner;

public class PerimetroQuadrado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o comprimento do lado do quadrado: ");
        double lado = scanner.nextDouble();

        double perimetro = calcularPerimetroQuadrado(lado);
        System.out.println("Perímetro do quadrado: " + perimetro);

        scanner.close();
    }

    public static double calcularPerimetroQuadrado(double lado) {
        return 4 * lado;
    }
}

