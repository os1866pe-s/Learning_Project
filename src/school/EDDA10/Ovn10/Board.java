package school.EDDA10.Ovn10;

import java.util.Random;

public class Board {

    private int row, col;
    private int board[][];
    private int step;

    /**Creates a matrix with zeros with the size 5 * 5.*/
    public Board(){
        board = new int[7][7];

        /*Fills the array with "0"*/
        for (int i = 0; i < 7; i++){
            for (int k = 0;k < 7; k++){
                board[i][k] = 0;
            }
        }

        step = 0;

        /*Creates a border with "-1"*/
        for (int i = 0; i < 7; i++){
            board[i][0] = -1;
            board[i][6] = -1;
            board[0][i] = -1;
            board[6][i] = -1;
        }
    }

    /**Makes row and col the current position.*/
    public void setStartPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

    /**Returns true if it is possible to walk to any of the
     * neighboring spaces.*/
    public boolean possibleToMove(){
        boolean movement = false;
        if ((board[row][col+1] == 0) || (board[row][col-1] == 0) || (board[row+1][col] == 0) || (board[row-1][col] == 0)){

            movement = true;
        }
        return movement;
    }

    /**Walks to a random neighboring space if there is any.*/
    public void makeOneStep(){
        Random rand = new Random();


        //int tempStep = step;
        boolean found = false;

        if (possibleToMove()) {

            while (!found) {
                int nextStepX = row, nextStepY = col;

                switch (rand.nextInt(4)) {
                    case 0:
                        nextStepY = col-1;
                        break;
                    case 1:
                        nextStepX = row+1;
                        break;
                    case 2:
                        nextStepY = col+1;
                        break;
                    case 3:
                        nextStepX = row-1;
                        break;
                    default: {
                        nextStepX = row;
                        nextStepY = col;
                        }
                        break;
                }
                if (board[nextStepX][nextStepY] == 0) {
                    step++;
                    found = true;
                    row = nextStepX;
                    col = nextStepY;
                    board[row][col] = step;
                }
            }
        }else{
            System.out.println("There is now way to more!");
        }
    }

    /**Prints out the board exclusive the edge(-1) to the screen.*/
    public void print(){

        for (int i = 1; i < 6; i++){
            System.out.print("|");
            for (int k = 1;k < 6; k++){

                if (Integer.toString(board[i][k]).length() == 1){
                    System.out.print(" ");
                }
                System.out.print(board[i][k] + "|");
            }
            System.out.println("");
        }
    }
}
