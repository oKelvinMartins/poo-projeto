package modelo;

public class Terreno extends Financiamento {

    private String tipoZona; 

    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String tipoZona){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoZona = tipoZona;
    } 
    
    @Override 
    public Double calculoPagamentoMensal() {
        return super.calculoPagamentoMensal() * 0.2;
    }

    public  Double totalPagamento () {
        return calculoPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public String getTipoZona(){
        return tipoZona;
    }
}
