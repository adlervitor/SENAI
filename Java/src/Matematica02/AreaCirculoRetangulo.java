package Matematica02;

public class AreaCirculoRetangulo {
    public static void main(String[] args) {
        double comprimento = 20.0;
        double largura = 10.0;

        // Lógica para calcular o perímetro
        double perimetro = 2 * (comprimento + largura);

        // Lógica para calcular o raio
        double raio = perimetro / (2 * Math.PI);

        // Lógica para calcular a área
        double area = Math.PI * raio * raio;

        System.out.println("A área do círculo é: " + area);
    }
}

