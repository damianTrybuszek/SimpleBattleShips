package org.example.board;


import org.example.players.Player;

import java.util.ArrayList;
import java.util.Random;

public class ShipPlacement {
    private Random random;

    public void randomPlacement(Player player, Board playerBoard, Board placementBoard) {
        for (Ship currentShip : player.getShipList()){
        do {
            currentShip.setShipStartX(random.nextInt(10));
            currentShip.setShipStartY(random.nextInt(10));
            currentShip.setShipOrientation(random.nextInt(2) == 0 ? ShipOrientation.HORIZONTAL : ShipOrientation.VERTICAL);
            currentShip.setSquaresList();
        } while (!(playerBoard.isPlacementOk(currentShip, placementBoard.getOcean())));
        placeShip(playerBoard.getOcean(), currentShip);
        placeShipOnPlacementBoard(placementBoard.getOcean(), currentShip);
    }}

    public void setSquaresList(Ship ship) {
        ship.squaresList.clear();
        for (int i = 0; i < ship.getShipType().getShipLength(); i++) {
            switch (ship.getShipOrientation()) {
                case HORIZONTAL: {
                    ship.squaresList.add(
                            new Square(ship.getShipStartY(), ship.getShipStartX() + i, SquareStatus.SHIP));
                    break;
                }
                case VERTICAL: {
                    ship.squaresList.add(
                            new Square(ship.getShipStartY() + i, ship.getShipStartX(), SquareStatus.SHIP));
                    break;
                }
            }
        }
    }

    public void placeShip(Square[][] ocean, Ship ship) {
        for (int i = 0; i < ship.getShipType().getShipLength(); i++) {
            switch (ship.getShipOrientation()) {
                case HORIZONTAL: {
                    ocean[ship.getShipStartY()][ship.getShipStartX() + i].setSquareStatus(SquareStatus.SHIP);
                    break;
                }
                case VERTICAL: {
                    ocean[ship.getShipStartY()+ i][ship.getShipStartX()].setSquareStatus(SquareStatus.SHIP);
                    break;
                }
            }
        }
    }

    public void placeShipOnPlacementBoard(Square[][] ocean, Ship ship) {
        for (int i = 0; i < ship.getShipType().getShipLength(); i++) {
            switch (ship.getShipOrientation()) {
                case HORIZONTAL: {
                    for (int j = -1; j < 2; j++) {
                        for (int k = -1; k < 2; k++)
                            if ((ship.getShipStartY() + j) >= 0 && (ship.getShipStartY()+ j) < ocean.length && ship.getShipStartX() + i + k >= 0 && ship.getShipStartX() + i + k < ocean.length) {
                                ocean[ship.getShipStartY() + j][ship.getShipStartX() + i + k].setSquareStatus(SquareStatus.SHIP);
                            }
                    }
                    break;
                }
                case VERTICAL: {
                    for (int j = -1; j < 2; j++) {
                        for (int k = -1; k < 2; k++)
                            if ((ship.getShipStartY() + i + j) >= 0 && (ship.getShipStartY()+ i + j) < ocean.length && ship.getShipStartX() + k >= 0 && ship.getShipStartX() + k < ocean.length) {
                                ocean[ship.getShipStartY() + i + j][ship.getShipStartX() + k].setSquareStatus(SquareStatus.SHIP);
                            }
                    }
                    break;


                }
            }
        }
    }

    }

