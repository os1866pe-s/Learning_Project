package Ovn10;

import java.util.Arrays;

public class Board {

    private int row, col;
    private int board[][];


    /**Creates a matrix with zeros with the size 5 * 5.*/
    public Board(){
        board = new int[5][5];
        Arrays.fill(board, 0);

    }

    /**Makes row and col the current position.*/
    public void setStartPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    /**Returns true if it is possible to walk to any of the
     * neighboring space.*/
    public boolean possibleToMove(){

    }


}
