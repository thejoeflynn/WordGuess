package com.github.zipcodewilmington;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class WordGuess {

    private String word;
    private Set<Character> guessedLetters;
    private int maxAttempts;
    private int wrongGuesses;
    static Scanner scanner = new Scanner(System.in);

    public WordGuess(String word) {
        this.word = word.toUpperCase();
       resetGame();
    }

    public void resetGame() {
        this.guessedLetters = new HashSet<>();
        this.maxAttempts = 6;
        this.wrongGuesses = 0;
    }

    public String displayWord() {

        // Show the word with blanks for unguessed letters
        StringBuilder display = new StringBuilder();
        for (char letter : word.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                display.append(letter).append(" ");
            } else {
                display.append("_ ");
            }
        }
        return display.toString().trim();
    }

    public boolean hasUnderscores(String wordToTest) {
       return wordToTest.indexOf('_') != -1;
    }

    public void play() {
        
        while (true) {
            String currentWord = this.displayWord();
            System.out.println(currentWord);
            if (this.hasUnderscores(currentWord) == false) {
              System.out.println("You're Winner!");
              break;
            }
            if (this.wrongGuesses >= this.maxAttempts) {
                System.out.println("You've lost. The word was " + word);
                break;
            }
            System.out.print("Guess a letter: ");
            String guess = scanner.nextLine().toUpperCase();
            if (guess.equalsIgnoreCase("exit")) {
                break;
            }
            
            char firstChar = guess.charAt(0);
            guessedLetters.add(firstChar);
            System.out.println(guessedLetters);

            if (!word.contains(String.valueOf(firstChar))) {
                wrongGuesses++;
                System.out.println("That's not in the word! You have " + (maxAttempts - wrongGuesses) + " remaining.");
            }

            System.out.println("You guessed: " + guessedLetters);
        }
    }
    public static void main(String[] args) {
       ArrayList<String> wordList = new ArrayList<>();
       wordList.add("ZIPCODE");
       wordList.add("TASWELL");
       wordList.add("DYNAMIC");
       wordList.add("SURFING");
       wordList.add("SEQUOIA");
       wordList.add("SUNRISE");
       wordList.add("BOOLEAN");

       Random random = new Random();

       System.out.println("Welcome to Word Guess! Start by guessing a letter.");
       
       String playagain = "y";

       while ("y".equals(playagain)){
            String chosenWord = wordList.get(random.nextInt(wordList.size()));
            WordGuess game = new WordGuess(chosenWord);
            game.play();
            System.out.print("Play Again(y/n): ");
            playagain = scanner.nextLine().toLowerCase();
            game.resetGame();
       }
       // exit message
    }
}