package modelo;

public class Casa extends Financiamento {
        
    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }
    
    @Override 
    public Double calculoPagamentoMensal() {
        return super.calculoPagamentoMensal() + 80;
    }

}
