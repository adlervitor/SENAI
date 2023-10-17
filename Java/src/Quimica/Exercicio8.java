package Quimica;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a distância percorrida em metros: ");
        double distancia = scanner.nextDouble();
        System.out.print("Entre com o tempo gasto em segundos: ");
        double tempo = scanner.nextDouble();
        // Lógica do cálculo da velocidade média
        double velocidadeMedia = distancia / tempo;
        System.out.println("A velocidade média é " + velocidadeMedia + " m/s.");
    }
}
