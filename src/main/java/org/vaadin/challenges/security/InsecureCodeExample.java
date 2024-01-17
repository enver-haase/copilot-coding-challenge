package org.vaadin.challenges.security;

import java.util.Scanner;

public class InsecureCodeExample {

    public static void main(String[] args) {
        insecurePasswordStorage();
        insecureInputValidation();
    }

    private static void insecurePasswordStorage() {
        String username = "exampleUser";
        String password = "insecurePassword";

        System.out.println("Insecure Password Storage Example:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    private static void insecureInputValidation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nInsecure Input Validation Example:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        String sqlQuery = "SELECT * FROM users WHERE username = '" + username + "'";
        System.out.println("Executing SQL Query: " + sqlQuery);

        scanner.close();
    }
}