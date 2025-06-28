package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Atributos 
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;
        
    public void mensagem() {
        System.out.println("O valor do imóvel" + this.getvalorImovel()); 
        System.out.println("O valor total do financiamento é: " +  totalPagamento()); 

    }

    // Método construtor (ação = Iniciarlizar atributos)
    
    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    
    // Metodo de calculo de pagmaento mensal 
    public Double calculoPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }
    // Metodo de calculo de pagmaento mensal 
    public abstract Double totalPagamento ();
    
    public Double getvalorImovel() {
        return this.valorImovel;
    } 

    public int getprazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public Double getTaxaJurosAnual() {
        return this.taxaJurosAnual;

    }

}







