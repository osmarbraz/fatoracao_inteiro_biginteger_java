
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        // Variáveis
        Scanner entrada = new Scanner(System.in);
        long numero;
        int divisor = 2;
        int quantidade;

        // Entrada
        System.out.print("Informe um numero inteiro: ");
        numero = entrada.nextLong();
        
        // Processamento
        System.out.print("Fatores primos: ");
        quantidade = 0;

        while (numero > 1) {
            if (numero % divisor == 0) {
                // O divisor é um fator do número.
                //Saída
                System.out.print(divisor);
                numero = numero / divisor;
                quantidade++;

                if (numero > 1) {
                    //Saída
                    System.out.print(" x ");
                }
            } else {
                // Tenta o próximo divisor.
                divisor++;
            }
        }

        entrada.close();
    }
}
