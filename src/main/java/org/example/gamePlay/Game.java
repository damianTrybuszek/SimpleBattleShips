package org.example.gamePlay;

import org.example.board.ShipPlacement;
import org.example.players.ComputerPlayer;
import org.example.players.HumanPlayer;
import org.example.players.Player;
import org.example.ui.Display;

public class Game {

    private HumanPlayer human;
    private ComputerPlayer computer;
    private Display display;
    ShipPlacement shipPlacement;

    public Game(Display display) {
        this.human = new HumanPlayer();
        this.computer = new ComputerPlayer();
        this.display = display;
        this.shipPlacement = new ShipPlacement();
    }

    public void startGame() {
        shipPlacement.randomPlacement(human);
        shipPlacement.randomPlacement(computer);
        while (!isGameOver()) {
            playRound();
        }

    }

    public void playRound() {
        human.shoot(player2, shootingBoardPlayer1, boardPlayer2);
        computer.shoot(player1, shootingBoardPlayer2, boardPlayer1);
    }


}
