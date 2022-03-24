package org.example.board;

import lombok.Getter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

@Getter
public class Board {
    private final int boardSize = 10;
    Square[][] ocean;

    public Board() {
        this.ocean = new Square[boardSize][boardSize];
        createBoard();
    }

    private void createBoard() {
        IntStream.range(0, ocean.length).forEach(y -> Arrays.setAll(ocean[y], x -> (new Square(y, x, SquareStatus.EMPTY))));
    }

    public boolean isPlacementOk(Ship ship) {
        LinkedList<Square> shipsElements = ship.getSquaresList();
        for (Square shipElement : shipsElements) {
            if (!isShipInBounds(shipElement) || isPlacementOccupied(shipElement)) return false;
        }
        return true;
    }

    private boolean isShipInBounds(Square shipElement) {
        return !(shipElement.getX() < 0 || shipElement.getY() < 0 || shipElement.getX() >= ocean.length ||
                shipElement.getY() >= ocean.length);
    }

    private boolean isPlacementOccupied(Square shipElement) {
        return (ocean[shipElement.getY()][shipElement.getX()]).getSquareStatus() != SquareStatus.EMPTY;
    }

}
