package VetoresMatrizes;

import java.util.Scanner;

public class DeterminanteMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Matriz fornecida:");
        System.out.print("Digite a: ");
        int a = scanner.nextInt();
        System.out.print("Digite b: ");
        int b = scanner.nextInt();
        System.out.print("Digite c: ");
        int c = scanner.nextInt();
        System.out.print("Digite d: ");
        int d = scanner.nextInt();

        int determinante = calcularDeterminante(a, b, c, d);
        System.out.println("Determinante: " + determinante);

        scanner.close();
    }

    public static int calcularDeterminante(int a, int b, int c, int d) {
        return a * d - b * c;
    }
}
