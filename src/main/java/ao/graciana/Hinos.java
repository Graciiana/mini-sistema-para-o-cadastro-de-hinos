package ao.graciana;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hinos {

    public static List<Hinos> hinosList= new LinkedList<>();
    public static Scanner tec= new Scanner(System.in);
    private String nomeHino;
    private String tipoHino;
    private String descricaoHino;

    //Metodos para cadastrar e listar Hinos

    public void cadastroHinos(){
        System.out.println("========== Cadastro de Hinos ==========");
        System.out.print("Hinos: ");
        this.nomeHino=tec.nextLine();
        System.out.print("Categoria do Hino: ");
        this.tipoHino=tec.nextLine();
        System.out.print("Descrição do hino: ");
        this.descricaoHino=tec.nextLine();
        Hinos hinos= new Hinos(nomeHino, tipoHino, descricaoHino);
        hinosList.add(hinos);

        //Chamada do método para guardar em Arquivo no Disco do System
        ArquivarDados.salvarHinosNoArquivo();
        System.out.println("Dados salvos com sucesso");
        tec.nextLine();
        ArquivarDados.limpar();
    }

    public static void listarHinos(){
        System.out.println("======== Lista dos Hinos =========");
       /* for (int i = 0; i < hinosList.size(); i++) {
            System.out.println("[" + i + "] " + Hinos.tec);
        }*/
        for (Hinos hino:hinosList){
            System.out.println(hino.exibirHinoBonito());
        }
        System.out.print("Queres fazer alguma modificação na lista? ");
        String opcao=tec.nextLine();

        if (opcao.equalsIgnoreCase("Sim")){
            System.out.println("Digite uma das opções a seguir: [1] editar / [2]remover");
            int modificar= tec.nextInt();
            tec.nextLine();

            if (modificar==2){
                ArquivarDados.eliminarHinos();
            }
            else if (modificar==1) {
                ArquivarDados.editarHinos();
            }
        }
        else{
            System.out.println("Entrada invalida");
            ArquivarDados.limpar();
        }
    }
    //Métododo para exibir os dados de forma bonita
    public String exibirHinoBonito() {
        return "Hino: " + nomeHino + "\n"
                + " Categoria: " + tipoHino + "\n"
                + " Descrição: " + descricaoHino + "\n";
    }



}
