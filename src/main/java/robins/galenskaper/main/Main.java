package robins.galenskaper.main;

import robins.galenskaper.main.problem1.Problem1;
import robins.galenskaper.main.problem2.Problem2;
import robins.galenskaper.main.problem3.Problem3;
import robins.galenskaper.main.problem4.Problem4;
import robins.galenskaper.main.problem5.Problem5;
import robins.galenskaper.main.problem5.StringChecker;

import java.util.Scanner;


public class Main {

    private static boolean run = true;
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (run){
            mainMenu();
        }
    }

    private static void mainMenu(){
        System.out.println("[1] Problem 1");
        System.out.println("[2] Problem 2");
        System.out.println("[3] Problem 3");
        System.out.println("[4] Problem 4");
        System.out.println("[5] Problem 5");
        System.out.println("[6] Exit\n");

        problemPicker(takeInput());
    }

    public static String takeInput(){
        System.out.print(">>: ");
        return input.nextLine().trim();
    }

    private static void problemPicker(String input){
        switch (input){
            case "1" -> problemOne();
            case "2" -> problemTwo();
            case "3" -> problemThree();
            case "4" -> problemFour();
            case "5" -> problemFive();
            case "6" -> exitProgram();

            default -> System.out.println("Please enter one of the displayed options\n");
        }
    }

    private static void problemOne(){
        System.out.println("Please enter your two potential anagrams");

        boolean trueOrFalse = Problem1.isAnagram(takeInput(), takeInput());
        System.out.println("Its " + trueOrFalse + " that your two strings are anagrams");
    }

    private static void problemTwo(){
        System.out.println("Please enter the URL you wish to scrape for links");
        Problem2.getAllLinks(takeInput());
    }

    private static void problemThree(){
        System.out.println("Enter the equation you wish to calculate");
        Problem3.calculator(takeInput());
    }

    private static void problemFour(){
        System.out.println("Enter the equation you wish to calculate");
        Problem4.calculator(takeInput());
    }

    private static void problemFive(){
        System.out.println("Enter the equation you wish to calculate");
        Problem5.calculator(takeInput());
    }

    private static void exitProgram(){
        run = false;
    }

}
