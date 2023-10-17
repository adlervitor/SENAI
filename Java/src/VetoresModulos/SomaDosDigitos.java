package VetoresModulos;

import java.util.Scanner;

public class SomaDosDigitos {

    public static int somarDigitos(int numero) {
        // Inicializa o total da soma.
        int soma = 0;

        // Enquanto o número for maior que zero, itera sobre seus dígitos.
        while (numero > 0) {
            // Obtém o último dígito do número.
            int digito = numero % 10;

            // Adiciona o dígito ao total da soma.
            soma += digito;

            // Remove o último dígito do número.
            numero = numero / 10;
        }

        // Retorna o total da soma.
        return soma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Solicita ao usuário um número.
        int numero = scanner.nextInt();

        // Calcula a soma dos dígitos do número.
        int soma = somarDigitos(numero);

        // Imprime o resultado.
        System.out.println("Soma dos dígitos: " + soma);
    }
}
