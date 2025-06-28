package main;
import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Main {     
    public static void main(String[] args) {
        // Criando a lista de financiamentos 
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        System.out.println("----------- Digite os dados do financiamento ");
        double valorImovel = interfaceUsuario.solicitarValorImovel();
        int prazoFinanciamentoAnos = interfaceUsuario.solicitarPrazoFinanciamento();
        double taxaJuros = interfaceUsuario.solicitarTaxaJuros(); 
        double areaConstruida = interfaceUsuario.solicitarArea();
        double tamanhoTerreno = interfaceUsuario.solicitarTamanhoTerreno();

        // Adicionar os financiamentos de casa na lista 
        Casa CasaFinanciada1 = new modelo.Casa(valorImovel, prazoFinanciamentoAnos, taxaJuros, areaConstruida, tamanhoTerreno);
        listaFinanciamentos.add(CasaFinanciada1);

        Casa CasaFinanciada2 = new modelo.Casa(100000, 10, 6, 100, 200);
        listaFinanciamentos.add(CasaFinanciada2);

        // Adicionar os financiamentos de apartamento
        
        Apartamento ApartamentoFinanciado1 = new modelo.Apartamento(250000, 35, 9, 2, 3);
        listaFinanciamentos.add(ApartamentoFinanciado1); 


        Apartamento ApartamentoFinanciado2 = new modelo.Apartamento(450000, 20, 12, 1,8);
        listaFinanciamentos.add(ApartamentoFinanciado2);


        // Adicionar os financiamentos de Terreno
        
        Terreno TerrenoFinanciado1 = new modelo.Terreno(100000, 5, 8, "rural");
        listaFinanciamentos.add(TerrenoFinanciado1); 
               
 
        // GRAVAR no arquivo
        try (FileWriter escritor = new FileWriter("ArquivoFinanciamentos.txt")) {
            escritor.write(CasaFinanciada1.toString() + "\n");
            escritor.write(CasaFinanciada2.toString() + "\n");
            escritor.write(ApartamentoFinanciado1.toString() + "\n");
            escritor.write(ApartamentoFinanciado2.toString() + "\n");
            escritor.write(TerrenoFinanciado1.toString() + "\n");

            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
        }

        // LER do arquivo
        try (BufferedReader leitor = new BufferedReader(new FileReader("ArquivoFinanciamentos.txt"))) {
            String linha;
            System.out.println("Conteúdo do arquivo:");
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    
        // 3. SALVAR E LER ARQUIVO SERIALIZADO 

        // 3.1. Salvando 
        String nomeArquivoSerializado = "financiamentos.dat";
        System.out.println("\n--- [Req 3] Salvando em arquivo serializado ---");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivoSerializado))) {
            oos.writeObject(listaFinanciamentos);
            System.out.println("Arquivo serializado salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.2. Lendo 
        System.out.println("\n--- [Req 3] Lendo e comprovando do arquivo serializado ---");
        ArrayList<Financiamento> listaLidaDoSerializado = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivoSerializado))) {
            @SuppressWarnings("unchecked")
            ArrayList<Financiamento> temp = (ArrayList<Financiamento>) ois.readObject();
            listaLidaDoSerializado = temp;
            System.out.println("Leitura do arquivo serializado e recriação dos objetos concluída!");
            System.out.println("Comprovação (total de imóveis lidos): " + listaLidaDoSerializado.size());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        

        // Variáveis para armazenar os totais
        double totalValorImoveis = 0;
        double totalFinanciamento = 0;

        // Somando os valores
        for (Financiamento financiamento : listaFinanciamentos) {
            totalValorImoveis += financiamento.getvalorImovel(); 
            totalFinanciamento += financiamento.totalPagamento(); 
        }

        // Exibindo os totais
        for (Financiamento financiamento : listaFinanciamentos) {
        System.out.println("financiamento: " + "Valor do imóvel: " + financiamento.getvalorImovel() + " valor do financiamento: " + financiamento.totalPagamento());
        }

        System.out.println("Total de valores dos imóveis: " + totalValorImoveis);
        System.out.println("Total de financiamento: " + totalFinanciamento);
    }
}





