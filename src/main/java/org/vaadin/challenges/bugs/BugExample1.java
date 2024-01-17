package org.vaadin.challenges.bugs;

public class BugExample1 {

    public static void main(String[] args) {
        int result = divide(10, 0);
        System.out.println("Result: " + result);
    }

    private static int divide(int a, int b) {
        return a / b;
    }
}