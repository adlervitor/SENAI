package VetoresModulos;

public class ContadorDeVogais {

    public static int contarVogais(String frase) {
        // Inicializa o contador de vogais.
        int numeroDeVogais = 0;

        // Percorre a frase caractere a caractere.
        for (char caractere : frase.toCharArray()) {
            // Verifica se o caractere é uma vogal.
            if (Character.isLetter(caractere) && (caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u')) {
                // Incrementa o contador de vogais.
                numeroDeVogais++;
            }
        }

        // Retorna o número de vogais.
        return numeroDeVogais;
    }

    public static void main(String[] args) {
        // Solicita ao usuário uma frase.
        String frase = System.console().readLine();

        // Conta o número de vogais na frase chamando a função contarVogais.
        int numeroDeVogais = contarVogais(frase);

        // Imprime o resultado.
        System.out.println("Número de vogais: " + numeroDeVogais);
    }
}
