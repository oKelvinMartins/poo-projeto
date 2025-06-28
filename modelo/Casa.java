package modelo;
import util.AumentoMaiorDoQueJurosException;


public class Casa extends Financiamento{

    private double areaConstruida;
    private double tamanhoTerreno;
        
    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }
    
private void validarAcrescimentoPagamentoMensal(double valorJuros, double valorAcrescimo) throws AumentoMaiorDoQueJurosException {

    if (valorAcrescimo > (valorJuros / 2)) {
        throw new AumentoMaiorDoQueJurosException("O acréscimo de R$80 excede metade do valor dos juros da mensalidade.");
    }
}

    @Override 
    public Double calculoPagamentoMensal() {
    double valorAcrescimo = 80.0;
    double parcelaTotal = super.calculoPagamentoMensal();
    double baseParcelaSemJuros = this.valorImovel / (this.prazoFinanciamento * 12);
    double valorJuros = parcelaTotal - baseParcelaSemJuros;

        try {
            validarAcrescimentoPagamentoMensal(valorJuros, valorAcrescimo);
        } catch (AumentoMaiorDoQueJurosException e) {
            // alterar valor do acrescimento para R$80
            valorAcrescimo = valorJuros;

        }       

        return super.calculoPagamentoMensal() + valorAcrescimo;
    } 

    public  Double totalPagamento () {
        return calculoPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

        // Juntar informações 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getvalorImovel() + "\n");
        sb.append(totalPagamento() + "\n");
        sb.append(this.getTaxaJurosAnual() + "\n");
        sb.append(this.getAreaConstruida() + "\n");
        sb.append(getTamanhoTerreno());
        return sb.toString();
    }

}
