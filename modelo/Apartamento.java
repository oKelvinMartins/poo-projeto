package modelo;

public class Apartamento extends Financiamento {

    // Metodo construtor 
    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);

    } 
    
    int prazoFinanciamentoEmMeses = 0;
    double taxaJurosMensal = 0;


    @Override 
    public Double calculoPagamentoMensal() {

        // Calcular taxa mensal 
        taxaJurosMensal = getTaxaJurosAnual() / 12; 
        // Calcular o financiamento em meses 
        prazoFinanciamentoEmMeses = getprazoFinanciamento() / 12;
        // Calcular a equação solicidata 
        return (valorImovel * Math.pow((1 + taxaJurosMensal), prazoFinanciamentoEmMeses)) /
               (Math.pow((1 + taxaJurosMensal), prazoFinanciamentoEmMeses) - 1);

    }

}
