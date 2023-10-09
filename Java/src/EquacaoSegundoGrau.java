import java.util.Scanner;

public class EquacaoSegundoGrau {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a, b, c, x1, x2;

        System.out.print("Digite o valor de a: ");
        a = scanner.nextDouble();
        System.out.print("Digite o valor de b: ");
        b = scanner.nextDouble();
        System.out.print("Digite o valor de c: ");
        c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Esta não é uma equação de segundo grau.");
        } else {
            double discriminante = b * b - 4 * a * c;

            if (discriminante > 0) {
                x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("A primeira raiz é: " + x1);
                System.out.println("A segunda raiz é: " + x2);
            } else if (discriminante == 0) {
                x1 = -b / (2 * a);
                System.out.println("A única raiz é: " + x1);
            } else {
                System.out.println("A equação não possui raízes reais.");
            }
        }
    }
}
