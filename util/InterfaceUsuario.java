package util;
import java.util.Scanner;

public class InterfaceUsuario {
    // Atributos
    int prazoFinanciamentoAnos;
    double taxaJurosAnual;
    long valorDesejadoImovel;
    Scanner scanner = new Scanner(System.in);

    // Método - Pedir valor do imóvel
        public double solicitarValorImovel() {
        
        do {
            System.out.print("Digite o valor desejado do imóvel: ");
            valorDesejadoImovel = scanner.nextLong();
                if (valorDesejadoImovel > 0 && valorDesejadoImovel <= 1000000) {
            System.out.println("O valor escolhido para financiamento foi: R$" + valorDesejadoImovel);    
            } else {
                System.out.println("ERRO! Valor invalido");
                }
        } while (valorDesejadoImovel <= 0 || valorDesejadoImovel > 1000000);
        return valorDesejadoImovel;           
    }

    // Método - Pedir ao usuário prazo de financiamento
        public int solicitarPrazoFinanciamento() {
 
        
        do {
            System.out.print("Digite o prazo de financiamento em anos: ");
            prazoFinanciamentoAnos = scanner.nextInt();
                if (prazoFinanciamentoAnos > 0 && prazoFinanciamentoAnos <= 40) {
                    System.out.println("O prazo escolhido foi: " + prazoFinanciamentoAnos 
                    + "anos");
            
            }else {
                System.out.println("ERRO! Valor invalido");
            } 
        } while (prazoFinanciamentoAnos <= 0 || prazoFinanciamentoAnos > 40);     
        return prazoFinanciamentoAnos;

    }

    // Método - Pedir ao usuário a taxa de juros desejada
        public double solicitarTaxaJuros() {

        
        do {
            System.out.print("Digite a taxa de juros anual (%): ");
            taxaJurosAnual = scanner.nextDouble();            
                if (taxaJurosAnual > 0 && taxaJurosAnual <= 20) {
                    System.out.println("A taxa de juros escolhida foi: " + taxaJurosAnual + "%");

            } else {
                System.out.println("ERRO! Valor inválido");
            }
        } while (taxaJurosAnual <= 0 || taxaJurosAnual > 20);   
        return taxaJurosAnual; 
    }

    public void fecharScanner() {
        scanner.close();
    }

        public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(); // Intanciando a classe Interfaceusuário 
        interfaceUsuario.solicitarValorImovel();
        interfaceUsuario.solicitarPrazoFinanciamento();
        interfaceUsuario.solicitarTaxaJuros();
        interfaceUsuario.fecharScanner();
    }

}
