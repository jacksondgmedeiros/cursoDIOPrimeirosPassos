package br.com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Olá, digite seu nome e aperte o enter: ");
        String nome = sc.nextLine();
        System.out.println("Agora, digite a sua idade e aperte o enter");
        int idade = sc.nextInt();
        System.out.printf("O seu nome é %s e você tem %s anos!", nome, idade);
        String nomeSocial = "null";

    }
}