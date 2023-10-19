package Quimica;

import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a massa do objeto em kg: ");
        double massa = scanner.nextDouble();
        System.out.print("Entre com a aceleração gravitacional do planeta em m/s²: ");
        double aceleracaoPlaneta = scanner.nextDouble();

        // Lógica para o cálculo do peso
        double peso = massa * aceleracaoPlaneta;
        System.out.println("O peso do objeto no planeta é " + peso + " N (newtons).");
    }
}
