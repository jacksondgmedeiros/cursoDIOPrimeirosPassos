package br.com.desafios;

import java.util.Locale;
import java.util.Scanner;


public class EcommerceSpendingTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int purchaseCount = scanner.nextInt();

        if (purchaseCount == 0) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            double totalSpent = 0.0;

            // TODO: Leia os valores das compras e calcule a média
            for(int i = 1; i <= purchaseCount; i++){
                System.out.printf("Digite o valor da compra %s", i);
                double spentCount = scanner.nextDouble();
                totalSpent+= spentCount;
            }
            var media = totalSpent/purchaseCount;

            System.out.printf("%.2f%n", totalSpent);
            System.out.printf("%.2f%n", media); // TODO: Imprima a média
        }

        scanner.close();
    }
}