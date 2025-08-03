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
        for (int i = 0; i < hinosList.size(); i++) {
            System.out.println("[" + i + "] " + hinosList.get(i).getNomeHino());
        }
        System.out.print("Queres fazer alguma modificação na lista? ");
        String opcao=tec.nextLine();

        if (opcao.equalsIgnoreCase("Sim")){
            System.out.println("Digite uma das opções a seguir: [1] editar / [2] pesquisar / [0]remover");
            int modificar= tec.nextInt();

            if (modificar==0){
                tec.nextLine();
                Hinos.eliminarHinos();
                ArquivarDados.salvarHinosNoArquivo();
                System.out.println("Dados eliminado com sucesso.");
            }
            else if (modificar==1) {

            } else if (modificar==2) {

            }
        }
        else{
            System.out.println("Saindo...");
            Hinos.limpar();
        }
    }


    //Métodos suxiliares: Editar, eliminar, limpar

    public static void editarHinos(){

    }


    public static void eliminarHinos() {
        if (hinosList.isEmpty()) {
            System.out.println("A lista de hinos está vazia. Nada para remover.");
            return;
        }

        int indice = -1;
        boolean valido = false;

        do {
            try {
                System.out.print("Digite o número do hino que deseja remover (ou -1 para cancelar): ");
                indice = Integer.parseInt(tec.nextLine());

                if (indice == -1) {
                    System.out.println("Remoção cancelada.");
                    return;
                }

                if (indice >= 0 && indice < hinosList.size()) {
                    Hinos removido = hinosList.remove(indice);
                    System.out.println("Hino '" + removido.getNomeHino() + "' removido com sucesso!");
                    valido = true;
                } else {
                    System.out.println("Índice inválido. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
            }
        } while (!valido);
    }

    //Limpar:
    public static void limpar(){
        for (int i=0; i<=50; i++){
            System.out.println();
        }
    }

}
