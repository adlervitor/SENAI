import java.util.Scanner;
public class PositivoOuNegativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        // Verifica se o número é positivo
        if (numero >= 0) {
            System.out.println("O número é positivo");
        } else {
            System.out.println("O número é negativo");
        }

        scanner.close();
    }
}
