package Matematica01;

import java.util.Scanner;

public class CalculoHipotenusa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Declara as variáveis que serão utilizadas
        double a, b, hipotenusa;

        System.out.print("Digite o valor do cateto adjacente: ");
        a = scanner.nextDouble();
        System.out.print("Digite o valor do cateto oposto: ");
        b = scanner.nextDouble();
        // Lógica que calcula a hipotenusa
        hipotenusa = Math.sqrt(a * a + b * b);

        System.out.println("A hipotenusa é: " + hipotenusa);
    }
}
