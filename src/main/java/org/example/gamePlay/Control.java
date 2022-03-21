package org.example.gamePlay;

import java.util.Arrays;
import java.util.Scanner;

public class Control {
    public Scanner sc;

    public Control(Scanner sc) {
        this.sc = new Scanner(System.in);
    }

    private int[] readCoordinates() {
        int columnIndex = -1;
        int rowIndex = -1;
        String coordinates = sc.next().replaceAll("\\s+", "");
        try {
            columnIndex = setColumnNumber(coordinates.charAt(0));
            rowIndex = setRowNumber(Character.getNumericValue(coordinates.charAt(1)));
        } catch (Exception e) {
            System.out.println("You should use coordinates between A1 to J10");
            readCoordinates();
        }
        return new int[]{rowIndex, columnIndex};
    }


    private int setColumnNumber(char columnLetter) throws IndexOutOfBoundsException {
        Character[] letterList = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        return (Arrays.asList(letterList)).indexOf(Character.toUpperCase(columnLetter));
    }

    private int setRowNumber(int rowNumber) throws IndexOutOfBoundsException {
        if (0 < rowNumber && rowNumber <= 10) {
            return rowNumber - 1;
        }
        throw new IndexOutOfBoundsException();
    }
}
