package modelo;

public class Terreno extends Financiamento {
    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    } 
    
    @Override 
    public Double calculoPagamentoMensal() {
        return super.calculoPagamentoMensal() * 0.2;
    }
}
