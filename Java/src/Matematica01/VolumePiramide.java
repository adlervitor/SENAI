package Matematica01;

public class VolumePiramide {

    public static void main(String[] args) {

        int ladoBase = 6;
        int altura = 8;

        // Lógica para calcular o volume
        double volume = (Math.PI * ladoBase * ladoBase * altura) / 3;

        System.out.println("O volume da pirâmide é: " + volume);
    }
}
