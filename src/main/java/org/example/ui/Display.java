package org.example.ui;

import org.example.board.Square;
import org.example.board.SquareStatus;


public class Display {

    private void printColumnLetters(int gameBoardLength) {
        System.out.print("  ");
        for (int i = 0; i < gameBoardLength; i++) {
            System.out.printf("%2s", (char) (0x0041 + i));
        }
        System.out.println();
    }

    public void printBoard(Square[][] ocean) {
        printColumnLetters(ocean[0].length);
        for (int i = 0; i < ocean.length; i++) {
            System.out.printf("%2s", 1 + i);
            for (int j = 0; j < ocean[i].length; j++) {
                System.out.print(getSquareCharacter(ocean[i][j].getSquareStatus()));
            }
            System.out.println();
        }

    }


    public String getSquareCharacter(SquareStatus squareStatus) {
        switch (squareStatus) {
            case EMPTY:
                return "\uD83C\uDF0A";
            case HIT:
                return "\ud83d\udd25";
            case SHIP:
                return "\uD83D\uDEA2";
            case SUNKEN:
                return "\uD83D\uDCA5";
            case MISSED:
                return "\ud83d\udeab";
            default:
                return null;
        }
    }

    public void printMainMenu() {
        clearScreen();
        System.out.println("Hello Dear User! Welcome to Battleships Game!");
        System.out.println("At the beginning, every square of the ocean will be seen like this: \uD83C\uDF0A.");
        System.out.println("If you miss, you can see square like this: \ud83d\udeab.");
        System.out.println("If you hit, you will see \ud83d\udd25, and  if you sink the enemy ship, you can see \uD83D\uDCA5.");
        System.out.println("To start new game please select 1.");
        System.out.println("To exit please select 2.");
    }

    public void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


    public void printGameExit() {
        System.out.println("You are going to exit!");
        System.out.println("See you again");
    }

    public void anyKeyToContinue() {
        System.out.println("Press \"ENTER\" to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
        clearScreen();
    }
}
