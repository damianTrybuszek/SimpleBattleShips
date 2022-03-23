package org.example.gamePlay;

import org.example.board.*;
import org.example.players.ComputerPlayer;
import org.example.players.HumanPlayer;
import org.example.players.Player;
import org.example.ui.Display;

import java.util.Arrays;

public class Game {

    private HumanPlayer human;
    private ComputerPlayer computer;
    private Display display;
    ShipPlacement shipPlacement;
    Control control;

    public Game(Display display) {
        this.human = new HumanPlayer();
        this.computer = new ComputerPlayer();
        this.display = display;
        this.shipPlacement = new ShipPlacement();
        this.control = new Control();
    }

    public void startGame() {
        shipPlacement.randomPlacement(human);
        shipPlacement.randomPlacement(computer);
        while (!isGameOver()) {
            playRound();
        }

    }

    public void playRound() {
        battle(human, computer);
        battle(computer, human);

    }

    public void battle(Player currentPlayer, Player enemyPlayer) {
        boolean canShoot;
        int[] coordinates;
        Board shootingBoard = currentPlayer.getShootingBoard();
        Board enemyBoard = enemyPlayer.getPlayerBoard();
        int boardSize = shootingBoard.getBoardSize();
        System.out.println(currentPlayer.getName() + ", it's your turn!");
        display.printBoard(shootingBoard.getOcean());
        do {
            coordinates = control.readCoordinates();
            canShoot = checkIfCanShoot(shootingBoard,coordinates);
        }
        while (!canShoot);
        shoot(shootingBoard, enemyBoard, coordinates,currentPlayer, enemyPlayer);
        display.printBoard(shootingBoard.getOcean());
        display.anyKeyToContinue();
    }

    private boolean checkIfCanShoot(Board shootingBoard, int [] coordinates) {
        int rowNr = coordinates[0];
        int colNr = coordinates[1];
        if (shootingBoard.getOcean()[rowNr][colNr].getSquareStatus() == SquareStatus.EMPTY) {
            return true;
        }
        System.out.println("This square was attacked already. Please use another one.");
        return false;
    }


    private void shoot(Board shootingBoard, Board enemyBoard, int [] coordinates, Player currentPlayer, Player enemyPlayer) {
        int rowNr = coordinates[0];
        int colNr = coordinates[1];
        if (enemyBoard.getOcean()[rowNr][colNr].getSquareStatus() == SquareStatus.SHIP){
            enemyBoard.getOcean()[rowNr][colNr].setSquareStatus(SquareStatus.HIT);
            shootingBoard.getOcean()[rowNr][colNr].setSquareStatus(SquareStatus.HIT);
            System.out.println("Enemy's ship has got shot!");
            shipSink(computer, enemyPlayer);
        }else if(enemyBoard.getOcean()[rowNr][colNr].getSquareStatus() == SquareStatus.EMPTY){
            shootingBoard.getOcean()[rowNr][colNr].setSquareStatus(SquareStatus.MISSED);
            System.out.println("Not this time. Missed shot!");
        }
    }

    private boolean isGameOver(){
        if (human.getShipList().isEmpty() || computer.getShipList().isEmpty()){
            return true;
        }
        return false;
    }

    private void shipSink(Player currentPlayer, Player enemyPlayer) {
        int indexOfShipToRemove = -1;
        for (Ship ship: enemyPlayer.getShipList()){
            boolean isSunken = true;
            for (Square square: ship.getSquaresList()){
                if (enemyPlayer.getPlayerBoard().getOcean()[square.getY()][square.getX()].getSquareStatus() != SquareStatus.HIT){
                    isSunken = false;
                    break;
                }
            }
            if (isSunken) {
                for (Square square: ship.getSquaresList()){
                    enemyPlayer.getPlayerBoard().getOcean()[square.getY()][square.getX()].setSquareStatus(SquareStatus.SUNKEN);
                    currentPlayer.getShootingBoard().getOcean()[square.getY()][square.getX()].setSquareStatus(SquareStatus.SUNKEN);
                }
                indexOfShipToRemove = enemyPlayer.getShipList().indexOf(ship);
            }
        }
        if (indexOfShipToRemove>-1){
            enemyPlayer.getShipList().remove(indexOfShipToRemove);
        }

    }

}
