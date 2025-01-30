package org.example;

import java.util.Scanner;

public class worker {
    static Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static void printStarLine(){
        System.out.println(Colors.ANSI_YELLOW + "****************");
        System.out.println(Colors.WHITE);
    }

    public static void invalidInput(){
        System.out.println(Colors.ANSI_RED + "****************\nInvalid Input\n****************\n");
    }

    public static void wasSuccessful(){
        System.out.println(Colors.LAVENDER + "****************\nWas Successful!\n****************\n");

    }

}
