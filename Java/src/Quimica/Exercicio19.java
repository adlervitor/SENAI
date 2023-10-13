package Quimica;

import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a configuração eletrônica do átomo: ");
        String configuracaoEletronica = scanner.nextLine();

        int posicaoUltimoSubnivel = configuracaoEletronica.lastIndexOf(" ");
        String ultimoSubnivel = configuracaoEletronica.substring(posicaoUltimoSubnivel);

        System.out.println("O último subnível preenchido é " + ultimoSubnivel);
    }
}
