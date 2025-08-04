package ao.graciana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class ArquivarDados {

    public static void salvarHinosNoArquivo(){
        try(PrintWriter writer= new PrintWriter("hinos.txt")){
            for (Hinos h: Hinos.hinosList){
                writer.println(h.getNomeHino()+ " ; "+h.getTipoHino()+" ; "+h.getDescricaoHino());
            }
        }catch (IOException e){
            System.out.println("Erro salvar dados "+e.getMessage());
        }
    }

    public static void carregarDados(){
        Hinos.hinosList.clear();
        try(BufferedReader reader= new BufferedReader(new FileReader("hinos.txt"))) {
            String linha;
            while ((linha= reader.readLine())!=null){
                String [] partes=linha.split(";");

                if (partes.length==3){
                    Hinos hino=new Hinos(partes[0], partes[1],partes[2]);
                    Hinos.hinosList.add(hino);
                }
            }

        }catch (IOException e){
            System.out.println("Erro ao carregar os dados "+e.getMessage());
        }
    }


    //Métodos suxiliares: Editar, eliminar, limpar

    public static void editarHinos(){
        if (Hinos.hinosList.isEmpty()) {
            System.out.println("A lista de hinos está vazia. Nada para remover.");
            return;
        }
        int indice=-2;
        boolean valido=false;

        do {
            try {
                System.out.print("Digite o número do hino que desejas editar (ou -2 para cancelar):  ");
                indice=Hinos.tec.nextInt();
                Hinos.tec.nextLine();

                if (indice==-2){
                    System.out.println("Edição cancelada.");
                    return;
                }
                if (indice>=0 && indice<Hinos.hinosList.size()){
                    System.out.print("Hino: ");
                    String nome=Hinos.tec.nextLine();
                    System.out.print("Categoria: ");
                    String categoria=Hinos.tec.nextLine();
                    System.out.print("Descricao: ");
                    String descricoa=Hinos.tec.nextLine();

                    Hinos hino= Hinos.hinosList.get(indice);
                    hino.setNomeHino(nome);
                    hino.setTipoHino(categoria);
                    hino.setDescricaoHino(descricoa);
                    System.out.println("Hino editado com sucesso. ");
                    salvarHinosNoArquivo();
                    Hinos.tec.nextLine();
                    valido=true;
                    limpar();


                }else {
                    System.out.println("Hino não encontrado. Indice invalido");
                }

            }catch (InputMismatchException e){
                System.out.println("Entradas invalida, digite um valor valido "+e.getMessage());
                Hinos.tec.nextLine();
            }
        }while (!valido);

    }



    //Método para eliminar Hinos, por indice

    public static void eliminarHinos() {
        if (Hinos.hinosList.isEmpty()) {
            System.out.println("A lista de hinos está vazia. Nada para remover.");
            return;
        }

        int indice = -1;
        boolean valido = false;

        do {
            try {
                System.out.print("Digite o número do hino que deseja remover (ou -1 para cancelar): ");
                indice = Integer.parseInt(Hinos.tec.nextLine());

                if (indice == -1) {
                    System.out.println("Remoção cancelada.");
                    return;
                }

                if (indice >= 0 && indice < Hinos.hinosList.size()) {
                    Hinos removido = Hinos.hinosList.remove(indice);
                    System.out.println("Hino '" + removido.getNomeHino() + "' removido com sucesso!");
                    salvarHinosNoArquivo();
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
