package main;
import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;
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




