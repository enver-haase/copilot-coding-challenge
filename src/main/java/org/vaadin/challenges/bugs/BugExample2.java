package org.vaadin.challenges.bugs;

import java.util.Scanner;

public class BugExample2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if (num > 5) {
            System.out.println("The number is less than or equal to 5.");
        } else {
            System.out.println("The number is greater than 5.");
        }

        scanner.close();
    }
}