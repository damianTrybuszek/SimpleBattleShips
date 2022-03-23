package org.example.board;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;

@Getter
public class Board {
    private final int boardSize = 10;
    Square[][] ocean;

    public Board() {
        this.ocean = new Square[boardSize][boardSize];
        createBoard();
    }

    private void createBoard(){
        for(int y = 0; y < ocean.length; y++){
            for (int x = 0; x < ocean.length; x++){
                ocean[y][x] = new Square(y, x, SquareStatus.EMPTY);
            }
        }
    }



    public boolean isPlacementOk (Ship ship, Square[][] ocean) {
        LinkedList<Square> shipsElements = ship.getSquaresList();
        for (Square shipElement : shipsElements){
            if (shipElement.getX() < 0 ||  shipElement.getY() < 0 || shipElement.getX() >= ocean.length ||
                    shipElement.getY() >= ocean.length)
            {
                return false;
            }
            if ((ocean[shipElement.getY()][shipElement.getX()]).getSquareStatus() != SquareStatus.EMPTY){
                return false;
            }
        }
        return true;
    };



}
