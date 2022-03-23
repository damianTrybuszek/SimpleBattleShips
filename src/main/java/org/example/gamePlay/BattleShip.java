package org.example.gamePlay;

import org.example.ui.Display;
import java.util.Scanner;

public class BattleShip {
    private Display display;
    private Boolean exit;
    Scanner sc;

    public BattleShip() {
        this.display = new Display();
        this.sc = new Scanner(System.in);
    }

    public void mainMenu() {
        do {
            display.printMainMenu();
            String decision = sc.next();

            switch (decision) {
                case "1":
                    Game game = new Game(display);
                    game.startGame();
                    break;
                case "2":
                    display.printGameExit();
                    this.exit = true;
                    break;
            }
        } while (!this.exit);
    }

}
