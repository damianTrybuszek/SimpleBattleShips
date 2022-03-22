package org.example.ui;

import org.example.board.Square;
import org.example.board.SquareStatus;

public class Display {

    private void printRowNumbers(int gameBoardLength) {

        for (int i = 1; i <= gameBoardLength; i++) {
            System.out.printf("%2s", (1 + i));
        }
        System.out.println();
    }

    private void printColumnLetters(int gameBoardLength) {
        System.out.print("  ");
        for (int i = 0; i < gameBoardLength; i++) {
            System.out.printf("%2s",  (char) (0x0041 + i));
        }
        System.out.println();
    }

    public void printBoard(Square[][] ocean){
        printColumnLetters(ocean[0].length);
        printRowNumbers(ocean[0].length);
        for (int i = 0; i < ocean.length; i++) {
            System.out.printf("%2s",  (char) (0x0041 + i));
            for (int j = 0; j < ocean[i].length; j++) {
                System.out.print(getSquareCharacter(ocean[i][j].getSquareStatus()));
            }
            System.out.println();
        }

    }

    public String getSquareCharacter(SquareStatus squareStatus){
        switch (squareStatus){
            case EMPTY:
                return  "\033[0;94m" + "\uD83C\uDF0A";
            case HIT:
                return "\033[0;91m" + "\uD83D\uDCA5";
            case SHIP:
                return "\033[0;97m" + "\uD83D\uDEA2";
            case SUNKEN:
                return "\033[0;97m" + "⚓";
            case MISSED:
                return "\033[0;96m" + "\uD83D\uDC1F";
            default:
                return null;
        }
    }

    public void printMainMenu() {
        clearScreen();
        System.out.println("Hello Dear User! Welcome to Battleships Game!");
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
}
