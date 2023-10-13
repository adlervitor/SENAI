package Quimica;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a configuração eletrônica: ");
        String configuracaoEletronica = scanner.nextLine();

        int posicaoUltimoEspaco = configuracaoEletronica.lastIndexOf(" ");
        String camadaValencia = configuracaoEletronica.substring(posicaoUltimoEspaco + 1);

        int numEletronsCamadaValencia = Integer.parseInt(camadaValencia);
        System.out.println("O átomo possui " + numEletronsCamadaValencia + " elétrons na camada de valência.");
    }
}

