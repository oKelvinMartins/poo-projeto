package modelo;
 


public class Apartamento extends Financiamento{

    private int vagasGaragem;
    private int andarApartamento;


    // Metodo construtor 
    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int vagasGaragem, int andarApartamento){
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.andarApartamento = andarApartamento;

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

    public  Double totalPagamento () {
        return calculoPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public double getVagasGaragem() {
        return vagasGaragem;
    }

    public double getAndarApartamento() {
        return andarApartamento;
    }

    // Juntar informações 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getvalorImovel() + "\n");
        sb.append(totalPagamento() + "\n");
        sb.append(this.getTaxaJurosAnual() + "\n");
        sb.append(this.getVagasGaragem() + "\n");
        sb.append(getAndarApartamento());
        return sb.toString();
    }
}
