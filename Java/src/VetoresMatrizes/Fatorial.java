package VetoresMatrizes;

import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        int fatorial = calcularFatorial(numero);
        System.out.println("Fatorial de " + numero + ": " + fatorial);

        scanner.close();
    }

    public static int calcularFatorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        }
        int resultado = 1;
        for (int i = 2; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }
}

