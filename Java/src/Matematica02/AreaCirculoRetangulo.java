package Matematica02;

public class AreaCirculoRetangulo {
    public static void main(String[] args) {
        double comprimento = 20.0;
        double largura = 10.0;

        double perimetro = 2 * (comprimento + largura);
        double raio = perimetro / (2 * Math.PI);

        double area = Math.PI * raio * raio;

        System.out.println("A área do círculo é: " + area);
    }
}

