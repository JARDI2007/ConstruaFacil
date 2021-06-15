// 1 - pacote
package devcal;
// 2 - bibliotecas (coisas que outras pessoas já fizeram)

import java.util.Scanner;

// 3 - classe (geralmente é uma classe por arquivo)
public class Calc {
    // 3.1 - atributos
    static Scanner entrada = new Scanner (System.in);

    //3.2 - metodos e funções (são as ações)

    public static void main(String[] args) {
        // exibe o menu da calculadora
        System.out.println(">>> CALCULADORA <<<");
        System.out.println("(1) Somar");
        System.out.println("(2) Subtrair");
        System.out.println("(3) Multiplicar");
        System.out.println("(4) Dividir");
        System.out.println("Escolha o Calculo Desejado");

        // recebe a opcao desejada
        int opcao = entrada.nextInt();
        int num1 = 0;
        int num2 = 0;

        // pergunta os valores a serem usados no calculo

        if (opcao >= 1 && opcao <= 4) {
            System.out.println("Entre o 1 número: ");
            num1 = entrada.nextInt();
            System.out.println("Entre o 2 número: ");
            num2 = entrada.nextInt();
            System.out.print("O resultado é: ");
        }

        // chama função do calculo desejados
        switch (opcao){

            case 1:
                System.out.println(somarDoisNumeros(num1, num2));
                break;

            default:
                System.out.println("opcao invalida");
                break;
        }
    }

    public static int somarDoisNumeros(int num1, int num2){
            return num1 + num2;

    }

}
