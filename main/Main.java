package main;
import modelo.Financiamento;
import util.InterfaceUsuario;
import java.util.ArrayList;



public class Main {     
    public static void main(String[] args) {
        // Criando a lista de financiamentos 
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Ler os dados inseridos pelo usuário
        for (int i = 1; i <= 4; i++) {
            System.out.println("----------- Digite os dados do financiamento " + i + ":");
            double valorImovel = interfaceUsuario.solicitarValorImovel();
            int prazoFinanciamentoAnos = interfaceUsuario.solicitarPrazoFinanciamento();
            double taxaJuros = interfaceUsuario.solicitarTaxaJuros();

            // Adicionando financiamento à lista
            listaFinanciamentos.add(new modelo.Financiamento(valorImovel, prazoFinanciamentoAnos, taxaJuros));
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




