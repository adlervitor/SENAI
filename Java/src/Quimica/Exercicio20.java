package Quimica;

import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a configuração eletrônica do átomo: ");
        String configuracaoEletronica = scanner.nextLine();

        int totalEletrons = 0;

        configuracaoEletronica = configuracaoEletronica.replace(" ", "");
        String[] niveis = configuracaoEletronica.split("(?=[spdf])");

        for (String nivel : niveis) {
            int numEletrons = Integer.parseInt(nivel.substring(1));
            totalEletrons += numEletrons;
        }

        System.out.println("O átomo possui " + totalEletrons + " elétrons.");
    }
}
