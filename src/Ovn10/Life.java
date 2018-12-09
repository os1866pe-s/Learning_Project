package Ovn10;

public class Life {

    private LifeBoard board;

    /**Creates a life-game with the LifeBoard "board".*/
    public Life(LifeBoard board){
        this.board = board;
    }

    /**Creates a new generation.*/
    public void newGeneration(){
        boolean tempBoard[][] = new boolean[board.getRows()][board.getCols()];

        for (int r = 0; r < board.getRows();r++){
            for (int k = 0; k < board.getCols(); k++){
                //fortlevande;
                if (board.get(r,k) && getNeighbours(board,r,k) == 2 || getNeighbours(board,r,k) == 3){
                    tempBoard[r][k] = true;
                //dödsfall
                }else if (board.get(r,k) && getNeighbours(board,r,k) >= 4){
                    tempBoard[r][k] = false;
                //födelse
                }else if(!board.get(r,k) && getNeighbours(board,r,k) == 3){
                    tempBoard[r][k] = true;

                }else {
                    tempBoard[r][k] = false;
                }
            }
        }
        board.increaseGeneration();
        for (int r = 0; r < board.getRows(); r++){
            for (int k = 0; k < board.getCols(); k++){
                board.put(r,k,tempBoard[r][k]);
            }
        }
    }

    /**Changes the content in index row, col from true to false
     * and the opposite*/
    public void flip(int row, int col){
        board.put(row, col, !board.get(row,col));
    }

    /**Returns the quantity of neighbours around index row, col*/
    private int getNeighbours(LifeBoard board, int row, int col){

        int neighbours = 0;

        //Top row
        if (board.get(row-1,col-1)){
            neighbours++;
        }
        if (board.get(row-1,col)){
            neighbours++;
        }
        if (board.get(row-1,col+1)){
            neighbours++;
        }

        //Bottom row
        if (board.get(row+1,col-1)){
            neighbours++;
        }
        if (board.get(row+1,col)){
            neighbours++;
        }
        if (board.get(row+1,col+1)){
            neighbours++;
        }
        //sides
        if (board.get(row,col-1)){
            neighbours++;
        }
        if (board.get(row,col+1)){
            neighbours++;
        }

       return neighbours;
    }


}
