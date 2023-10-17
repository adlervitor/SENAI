package Quimica;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre com a configuração eletrônica: ");
        // Usuário insere a configuração eletrônica
        String configuracaoEletronica = scanner.nextLine();
        // Localizamos o último índice
        int posicaoUltimoEspaco = configuracaoEletronica.lastIndexOf(" ");
        // Lógica pra calcular a camada de valência
        String camadaValencia = configuracaoEletronica.substring(posicaoUltimoEspaco + 1);
        // Converte a string anterior em um int
        int numEletronsCamadaValencia = Integer.parseInt(camadaValencia);
        System.out.println("O átomo possui " + numEletronsCamadaValencia + " elétrons na camada de valência.");
    }
}

