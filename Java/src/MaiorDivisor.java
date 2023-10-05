import java.util.Scanner;

public class MaiorDivisor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        int maiorDivisor = numero / 2;

        for (int i = maiorDivisor; i >= 1; i--) {
            if (numero % i == 0) {
                maiorDivisor = i;
                break;
            }
        }

        System.out.println("O maior divisor do número é " + maiorDivisor);

        scanner.close();
    }
}
