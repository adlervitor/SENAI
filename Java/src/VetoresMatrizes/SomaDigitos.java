package VetoresMatrizes;

import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        int soma = calcularSomaDigitos(numero);
        System.out.println("Soma dos dígitos: " + soma);

        scanner.close();
    }

    public static int calcularSomaDigitos(int numero) {
        int soma = 0;
        while (numero > 0) {
            soma += numero % 10;
            numero /= 10;
        }
        return soma;
    }
}

