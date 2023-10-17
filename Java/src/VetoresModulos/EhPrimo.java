package VetoresModulos;

public class EhPrimo {
    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }

        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int numero = Integer.parseInt(System.console().readLine());

        boolean ehPrimo = ehPrimo(numero);

        if (ehPrimo) {
            System.out.println("O número é primo.");
        } else {
            System.out.println("O número não é primo.");
        }
    }
}
