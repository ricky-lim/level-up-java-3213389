package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static boolean isPasswordComplex(String password) {
        return password.length() >= 6 && 
            password.chars().anyMatch(Character::isUpperCase) &&
            password.chars().anyMatch(Character::isLowerCase) && 
            password.chars().anyMatch(Character::isDigit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
