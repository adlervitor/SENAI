package Matematica02;

import java.util.Scanner;

public class VolumeCubo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o volume do cubo: ");
        double volume = scanner.nextDouble();

        double aresta = Math.cbrt(volume);
        System.out.println("O comprimento da aresta do cubo é: " + aresta);
    }
}

