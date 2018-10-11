package Ovn10;

public class LifeBoard {
    private int row,col;
    private int genNum;
    private boolean lifeBoard[][];

    /**Creates a gameboard with rows "row" and columns "col".
     * The gameboard is from the start empty with generationnumber = 1.*/
    public LifeBoard(int row,int col){

       this.row = row;
       this.col = col;
       genNum = 1;
       lifeBoard = new boolean[row][col];
    }

    /**Returns true if there is a individual at index row, col, else false.
     * If index row, col is outside return false.*/
    public boolean get(int row, int col){

        if (row < 0 || col < 0 || row > this.row-1 || col > this.col-1){
            return false;
        }else {
            return lifeBoard[row][col];
        }

    }

    /**Insert the value of val in index row, col.*/
    public void put(int row, int col, boolean val){
        lifeBoard[row][col] = val;
    }

    /**Returns the quantity of rows.*/
    public int getRows(){
        return row;
    }

    /**Returns the quantity of columns*/
    public int getCols(){
        return col;
    }

    /**Returns the current generationnumber*/
    public int getGeneration(){
        return genNum;
    }

    /**Increases the generationnumber with 1.*/
    public void increaseGeneration(){
        genNum++;
    }

}
