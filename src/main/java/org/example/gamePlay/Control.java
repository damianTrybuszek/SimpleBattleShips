package org.example.gamePlay;

import java.util.*;

public class Control {
    public Scanner sc;
    private final List <Character> letterList;

    public Control() {
        this.sc = new Scanner(System.in);
        this.letterList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
    }

    protected int[] readCoordinates() {
        char columnLetter = 'z';
        int rowNumber = -1;
        int columnIndex = -1;
        int rowIndex = -1;
        boolean areCoordinatesCorrect;
        do {
            String coordinates = sc.next() + "  ";
            System.out.println(coordinates);
            if (Character.isLetter(coordinates.charAt(0))){
            columnLetter = coordinates.charAt(0);}
            if (Character.isDigit(coordinates.charAt(1))){
            rowNumber = Character.getNumericValue(coordinates.charAt(1));}
            areCoordinatesCorrect = (letterList.contains(Character.toUpperCase(columnLetter)) && 0 < rowNumber && rowNumber <= 10);
            if (areCoordinatesCorrect){
            columnIndex = letterList.indexOf(Character.toUpperCase(columnLetter));
            rowIndex = rowNumber - 1;
                }
            else {
            System.out.println("You should use coordinates between A1 to J10");}
        }
        while(!areCoordinatesCorrect);

        return new int[]{rowIndex, columnIndex};
    }


}
