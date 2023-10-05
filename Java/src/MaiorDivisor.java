import java.util.Scanner;
public class MaiorDivisor {
    public static void main(String[] args) {
        // Inicializando o scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        int maiorDivisor = 1;
        // Atualiza o maior divisor
        for (int i = maiorDivisor; i <= numero; i++) {
            if (numero % i == 0) {
                maiorDivisor = i;
            }
        }

        System.out.println("O maior divisor do número é " + maiorDivisor);

        // Fechando o scanner
        scanner.close();
    }
}
