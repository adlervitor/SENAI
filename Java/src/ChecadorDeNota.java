public class ChecadorDeNota {
    public static void main(String[] args) {
        int nota = 85;


        if (nota >= 90) {
            System.out.println("Exelente!");
        } else if (nota >= 80) {
            System.out.println("Muito Bom!");
        } else if (nota >= 70) {
            System.out.println("Bom");
        } else if (nota >= 60) {
            System.out.println("Satisfatório");
        } else {
            System.out.println("É preciso melhorar!");
        }
    }
}
