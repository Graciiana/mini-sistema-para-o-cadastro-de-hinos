package ao.graciana;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArquivarDados.carregarDados();
        Scanner teclado= new Scanner(System.in);
        String opcao;
        Boolean contador=true;

        do {
            System.out.println("======= Menu Principal ========");
            System.out.println("1º Cadastro de Hinos");
            System.out.println("2ª Lista dos Hinos");
            System.out.println("3º Saír\n");

            System.out.print("Escolha uma opção: ");
            opcao=teclado.nextLine();

            switch(opcao){
                case "1":
                    Hinos hino= new Hinos();
                    hino.cadastroHinos();
                    teclado.nextLine();
                    ArquivarDados.limpar();
                    break;
                case "2":
                    Hinos.listarHinos();
                    break;
                case "3":
                    contador=false;
                    ArquivarDados.limpar();
                    break;
                default:
                    System.out.println("Nenhuma das opções foi encontrada. ");
                    break;
            }

        }while (contador);
    }
}