import java.util.Scanner;
public class Dobro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o número:");
        int numero = scanner.nextInt();

        System.out.println("O dobro do número é: " + numero * 2);

        scanner.close();
    }
}
