package com.azhar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Lines to be Printed: ");
        int x = scanner.nextInt();

        System.err.println("X : " + x);
        FileGenerator fileGenerator = new FileGenerator();
        try {
            fileGenerator.generate(x);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}