package modelo;




public class Terreno extends Financiamento  {

    private String tipoZona; 

    public Terreno(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String tipoZona){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoZona = tipoZona;
    } 
    
    @Override 
    public Double calculoPagamentoMensal() {
        return super.calculoPagamentoMensal() * 1.2;
    }

    public  Double totalPagamento () {
        return calculoPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public String getTipoZona(){
        return tipoZona;
    }
    // Juntar informações 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getvalorImovel() + "\n");
        sb.append(totalPagamento() + "\n");
        sb.append(this.getTaxaJurosAnual() + "\n");
        sb.append(this.getTipoZona());
        return sb.toString();
    }
}
