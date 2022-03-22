package org.example.gamePlay;

import org.example.ui.Display;
import java.util.Scanner;

public class BattleShip<Input> {
    private Display display;
    private Input input;
    private Boolean exit;
    Scanner sc = new Scanner(System.in);

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
