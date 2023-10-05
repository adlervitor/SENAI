import java.util.Scanner;

public class Fatorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        int fatorial = 1;
        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }

        System.out.println("O fatorial do número é " + fatorial);
    }
}
