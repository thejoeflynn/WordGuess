package com.github.zipcodewilmington;

import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class WordGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Guess!");
        System.out.println("Go ahead and guess a letter. Or type 'Quit' to quit the game.");

        String input = "";

    while (!input.equalsIgnoreCase("Quit")) {
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("Quit")) {
            System.out.println("Thanks for playing!");
            break;
        } else {
            System.out.println(input);
        }
    } 
    }
}