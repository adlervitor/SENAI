import java.util.Scanner;

public class RaizQuadrada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe um número:");
        int numero = scanner.nextInt();

        int raizQuadrada = (int) Math.sqrt(numero);

        System.out.println("A raiz quadrada do número é " + raizQuadrada);

        scanner.close();
    }
}
