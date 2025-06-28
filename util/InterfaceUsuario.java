package util;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class InterfaceUsuario {
    // Atributos
    int prazoFinanciamentoAnos;
    double taxaJurosAnual;
    long valorDesejadoImovel;

    Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    // Método - Pedir valor do imóvel

    public double solicitarValorImovel() {
    long valorDesejadoImovel = 0;

    do {
        try {
            System.out.print("Digite o valor desejado do imóvel: ");
            valorDesejadoImovel = scanner.nextLong(); 
            if (valorDesejadoImovel > 0) {
                System.out.println("O valor escolhido para financiamento foi: R$" + valorDesejadoImovel);
            } else {
                System.out.println("ERRO! Valor inválido. O valor precisa ser maior que zero.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO: Valor inválido. Digite apenas números inteiros.");
            scanner.nextLine(); // limpa a entrada inválida do buffer
            
        }

    } while (valorDesejadoImovel <= 0);

    return valorDesejadoImovel;
}


    // Método - Pedir ao usuário prazo de financiamento
        public int solicitarPrazoFinanciamento() {
         
        do {
            try {
            System.out.print("Digite o prazo de financiamento em anos: ");
            prazoFinanciamentoAnos = scanner.nextInt();
                if (prazoFinanciamentoAnos > 0 && prazoFinanciamentoAnos <= 40) {
                    System.out.println("O prazo escolhido foi: " + prazoFinanciamentoAnos 
                    + " anos");
            }   else {
                    System.out.println("ERRO! Prazo permitido até 40 anos"); }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Valor inválido. Digite apenas números inteiros.");
                scanner.nextLine(); // limpa a entrada inválida do buffer
            } 
        } while (prazoFinanciamentoAnos <= 0 || prazoFinanciamentoAnos > 40);     
        return prazoFinanciamentoAnos;

    }

    // Método - Pedir ao usuário a taxa de juros desejada
        public double solicitarTaxaJuros() {
        
        do { 

            try {
            System.out.print("Digite a taxa de juros anual (%): ");
            taxaJurosAnual = scanner.nextDouble();            
                if (taxaJurosAnual > 0 && taxaJurosAnual <= 20) {
                    System.out.println("A taxa de juros escolhida foi: " + taxaJurosAnual + "%"); } 
                else {
                    System.out.println("ERRO! Taxa permitida até 20%");
                    }
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Valor inválido. Digite apenas números inteiros.");
                scanner.nextLine(); // limpa a entrada inválida do buffer                
            }
        } while (taxaJurosAnual <= 0 || taxaJurosAnual > 20);   
        return taxaJurosAnual; 
    }
        // Método solicitar área da casa 
        public double solicitarArea() {

            double areaConstruida = 0;

        do {
            try {
            System.out.print("Digite o tamanho da área construída: ");
            areaConstruida = scanner.nextDouble();

            if (areaConstruida <= 0) {
                System.out.println("ERRO! O valor deve ser maior que zero.");
            }

        } catch (InputMismatchException e) {
            System.out.println("ERRO! Digite um número válido com ponto (ex: 45.5).");
            scanner.nextLine(); // limpa o buffer
        }
    } while (areaConstruida <= 0);

    return areaConstruida;
}

   
public double solicitarTamanhoTerreno() {
    double tamanhoTerreno = 0;
    boolean entradaValida = false;

    while (!entradaValida) {
        System.out.print("Digite o número do tamanho total do terreno: ");
        try {
            tamanhoTerreno = scanner.nextDouble();
            if (tamanhoTerreno > 0) {
                entradaValida = true;
            } else {
                System.out.println("ERRO! O valor deve ser maior que zero.");
            }
        } catch (InputMismatchException e) {
            System.out.println("ERRO! Digite um número válido (ex: 250.5).");
            scanner.nextLine(); // limpa entrada inválida
        }
    }

    return tamanhoTerreno;
}


    public void fecharScanner() {
        scanner.close();
    }

        public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(); // Intanciando a classe Interfaceusuário 
        interfaceUsuario.solicitarValorImovel();
        interfaceUsuario.solicitarPrazoFinanciamento();
        interfaceUsuario.solicitarTaxaJuros();
        interfaceUsuario.solicitarArea();
        interfaceUsuario.solicitarTamanhoTerreno();
        interfaceUsuario.fecharScanner();
    }


}
