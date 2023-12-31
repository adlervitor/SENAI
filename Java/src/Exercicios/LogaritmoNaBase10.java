package Exercicios;

import java.util.Scanner;
public class LogaritmoNaBase10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();
        // Utilizamos o método log10 da biblioteca Math
        // O método não retorna um int, por isso convertemos com o (int)
        int logaritmo = (int) Math.log10(numero);

        System.out.println("O logaritmo na base 10 do número é " + logaritmo);

        scanner.close();
    }
}
