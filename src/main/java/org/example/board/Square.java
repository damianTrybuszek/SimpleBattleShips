package org.example.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Square {

    private int x;
    private int y;
    private SquareStatus squareStatus;

    public Square(int y, int x, SquareStatus squareStatus) {
        this.x = x;
        this.y = y;
        this.squareStatus = squareStatus;
    }

}
