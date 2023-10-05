import java.util.Scanner;
public class OperacoesBasicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input do usuário para o primeiro número
        System.out.println("Digite um número: ");
        int a = scanner.nextInt();

        // Segundo número
        System.out.println("Digite outro número: ");
        int b = scanner.nextInt();

        // Operações com os números fornecidos
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;

        System.out.println("Soma " + sum);
        System.out.println("Diferença " + difference);
        System.out.println("Produto " + product);
        System.out.println("Resto " + quotient);

        scanner.close();
    }
}
