package br.com.ContaBanco;

import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor, digite o número da Conta: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o número da Agência: ");
        String agencia = scanner.next();
        System.out.print("Agora, digite o seu Nome: ");
        String nomeCliente = scanner.next();
        System.out.print("por fim, digite o seu Saldo: ");
        double saldo = scanner.nextDouble();


        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s," +
                " conta %d e seu saldo é %.2f já disponível para saque!", nomeCliente, agencia,numero, saldo);

    }


}
