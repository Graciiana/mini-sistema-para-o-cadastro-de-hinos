package ao.graciana;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hinos {

    static List<Hinos> hinosList= new LinkedList<>();
    static Scanner tec= new Scanner(System.in);
    private String nomeHino;
    private String tipoHino;
    private String descricaoHino;



    //ToString

    /*public String toString(){
        return "{"+"[Nome do Hino: " +this.nomeHino+ " ]"+ "[ Categoria: "+this.tipoHino+ " ]" + " [ Descrição: "+this.descricaoHino+ " ]"+ " }";
    }*/

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
        Hinos.limpar();
    }

    public static void listarHinos(){
        System.out.println("======== Lista dos Hinos =========");
        for (Hinos hino: hinosList) {
            System.out.println(hino);
        }

    }
    //Métodos suxiliares: Editar, eliminar, limpar

    //Limpar:
    public static void limpar(){
        for (int i=0; i<=50; i++){
            System.out.println();
        }
    }

}
