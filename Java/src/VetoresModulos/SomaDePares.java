package VetoresModulos;

import java.util.Arrays;
import java.util.List;

public class SomaDePares {
    public static int somaPares( List<Integer> listaNumeros) {
        int soma = 0;

        for(Integer numero : listaNumeros){
            if (numero % 2 == 0){
                soma += numero;
            }
        }
        return soma;
    }

    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(2, 3, 6, 8, 10, 11);
        System.out.println("O resultado da soma dos pares é: " + somaPares(lista));
    }
}
