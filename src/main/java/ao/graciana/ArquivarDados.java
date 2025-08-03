package ao.graciana;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
}
