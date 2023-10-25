package com.tabelabrasileirao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TabelaBrasileiraoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TabelaBrasileiraoApplication.class, args);

        String[] times = {
                "América Mineiro", "Athletico-PR", "Atlético Mineiro", "Bahia", "Botafogo",
                "Corinthians", "Coritiba", "Cruzeiro", "Cuiabá", "Flamengo",
                "Fluminense", "Fortaleza", "Goiás", "Grêmio", "Internacional",
                "Palmeiras", "Red Bull Bragantino", "Santos", "São Paulo", "Vasco"
        };

        int[] pontuacoes = new int[times.length];
        int[] cartoesAmarelos = new int[times.length];
        int[] vitorias = new int[times.length]; // Adicionado para armazenar o número de vitórias

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Visualizar Tabela");
            System.out.println("2 - Editar Pontuação e Vitórias");
            System.out.println("3 - Editar Cartões Amarelos");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    scanner.close();
                    return;
                case 1:
                    exibirTabela(times, pontuacoes, cartoesAmarelos, vitorias);
                    break;
                case 2:
                    editarPontuacaoEVitorias(times, pontuacoes, cartoesAmarelos, vitorias, scanner);
                    break;
                case 3:
                    editarCartoesAmarelos(times, pontuacoes, cartoesAmarelos, scanner, vitorias);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void exibirTabela(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias) {
        System.out.println("\nPosição | Time | Pontuação | Vitórias | Cartões Amarelos");
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + " | " + times[i] + " | " + pontuacoes[i] + " | " + vitorias[i] + " | " + cartoesAmarelos[i]);
        }
    }

    public static void exibirTimes(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias) {
        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + " - " + times[i] + " | Pontuação: " + pontuacoes[i] + " | Vitórias: " + vitorias[i] + " | Cartões Amarelos: " + cartoesAmarelos[i]);
}
    }

    // Agora o usuário consegue editar a pontuação e as vitórias na mesma opção
    public static void editarPontuacaoEVitorias(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias, Scanner scanner) {
        while (true) {
            System.out.println("\nTimes disponíveis para edição:");
            exibirTimes(times, pontuacoes, cartoesAmarelos, vitorias);
            System.out.println("Escolha o número do time para editar a pontuação e vitórias (ou 0 para voltar):");
            int posicao = scanner.nextInt();

            if (posicao == 0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite a nova pontuação para " + times[posicao - 1] + ":");
                int novaPontuacao = scanner.nextInt();

                if (novaPontuacao >= 0) {
                    pontuacoes[posicao - 1] = novaPontuacao;
                    System.out.println("Digite o novo número de vitórias para " + times[posicao - 1] + ":");
                    int novasVitorias = scanner.nextInt();
                    if (novasVitorias >= 0) {
                        vitorias[posicao - 1] = novasVitorias;
                    } else {
                        System.out.println("O número de vitórias não pode ser negativo.");
                    }
                } else {
                    System.out.println("A pontuação não pode ser negativa.");
                }
            } else {
                System.out.println("Posição inválida. Tente novamente.");
            }

            scanner.nextLine();
        }
        ordenarPorPontuacaoVitoriasECartoes(times, pontuacoes, cartoesAmarelos, vitorias);
    }

    public static void editarCartoesAmarelos(String[] times, int[] pontuacoes, int[] cartoesAmarelos, Scanner scanner, int[] vitorias) {
        while (true) {
            System.out.println("\nTimes disponíveis para edição: ");
            exibirTimes(times, pontuacoes, cartoesAmarelos, vitorias);
            System.out.println("\nEscolha o número do time para editar os cartões amarelos (ou 0 para voltar):");
            int posicao = scanner.nextInt();
            if (posicao == 0) {
                break;
            }
            if (posicao >= 1 && posicao <= times.length) {
                System.out.println("Digite o novo número de cartões amarelos do " + times[posicao - 1] + ": ");
                int novosCartoes = scanner.nextInt();
                if (novosCartoes >= 0) {
                    cartoesAmarelos[posicao - 1] = novosCartoes;
                } else {
                    System.out.println("O número de cartões amarelos não pode ser negativo.");
                }
            } else {
                System.out.println("Posição inválida, tente novamente.");
            }
            scanner.nextLine();
        }
    }

    public static void ordenarPorPontuacaoVitoriasECartoes(String[] times, int[] pontuacoes, int[] cartoesAmarelos, int[] vitorias) {
        for (int i = 0; i < pontuacoes.length - 1; i++) {
            for (int j = i + 1; j < pontuacoes.length; j++) {
                if (pontuacoes[i] < pontuacoes[j] || (pontuacoes[i] == pontuacoes[j] && vitorias[i] < vitorias[j]) ||
                        (pontuacoes[i] == pontuacoes[j] && vitorias[i] == vitorias[j] && cartoesAmarelos[i] > cartoesAmarelos[j])) {

                    int tempPontuacao = pontuacoes[i];
                    pontuacoes[i] = pontuacoes[j];
                    pontuacoes[j] = tempPontuacao;

                    int tempCartoes = cartoesAmarelos[i];
                    cartoesAmarelos[i] = cartoesAmarelos[j];
                    cartoesAmarelos[j] = tempCartoes;

                    int tempVitorias = vitorias[i];
                    vitorias[i] = vitorias[j];
                    vitorias[j] = tempVitorias;

                    String tempTime = times[i];
                    times[i] = times[j];
                    times[j] = tempTime;
                }
            }
        }
    }
}
