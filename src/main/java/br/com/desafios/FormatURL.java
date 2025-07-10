package br.com.desafios;

import java.util.Scanner;

public class FormatURL {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Lendo a entrada do usuário
        String url = scanner.next();

        // TODO: Normalize a URL: removendo espaços e convertendo para minúsculas
        String formatURL = url.toLowerCase().trim();

        // TODO: Exiba a URL normalizada
        System.out.print(formatURL);

        scanner.close();
    }
}
