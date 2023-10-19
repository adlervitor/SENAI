package Matematica01;

public class VolumeAreaCubo {

    public static void main(String[] args) {
        int aresta = 7;

        // Lógica para calcular o volume
        int volume = aresta * aresta * aresta;

        // Lógica para calcular a área
        int areaSuperficie = 6 * aresta * aresta;

        System.out.println("O volume do cubo é: " + volume);
        System.out.println("A área da superfície do cubo é: " + areaSuperficie);
    }
}
