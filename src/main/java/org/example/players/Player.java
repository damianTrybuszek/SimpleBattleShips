package org.example.players;


import lombok.Getter;
import org.example.board.Board;
import org.example.board.Ship;
import org.example.board.ShipType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Getter
public abstract class Player {

    private String name;
    protected LinkedList<Ship> shipList;
    private Board playerBoard;
    private Board playerPlacementBoard;
    private Board shootingBoard;

    public Player(String name) {
        this.playerBoard = new Board();
        this.playerPlacementBoard = new Board();
        this.shootingBoard = new Board();
        this.name = name;
        this.shipList = new LinkedList<>();
        this.shipList.add(new Ship(ShipType.BATTLESHIP));
        this.shipList.add(new Ship(ShipType.DESTROYER));
        this.shipList.add(new Ship(ShipType.DESTROYER));
    }



    public boolean isAlive(){
        return !this.shipList.isEmpty();
    }

}
