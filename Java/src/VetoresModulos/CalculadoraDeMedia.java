package VetoresModulos;

import java.util.Arrays;
import java.util.Scanner;

public class CalculadoraDeMedia {

    public static double calcularMedia(double[] notas) {
        // Inicializa a soma das notas.
        double soma = 0;

        // Percorre as notas.
        for (double nota : notas) {
            // Adiciona a nota atual à soma.
            soma += nota;
        }

        // Calcula a média.
        return soma / notas.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Solicita ao usuário as notas.
        System.out.println("Digite as notas separadas por espaços: ");
        String notasStr = scanner.nextLine();

        // Converte as notas de string para double.
        double[] notas = Arrays.stream(notasStr.split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Calcula a média das notas.
        double media = calcularMedia(notas);

        // Imprime a média.
        System.out.println("Média das notas: " + media);
    }
}
