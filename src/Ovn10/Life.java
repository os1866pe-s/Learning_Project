package Ovn10;

public class Life {

    LifeBoard board;

    /**Creates a life-game with the LifeBoard "board".*/
    public Life(LifeBoard board){
        this.board = board;
    }

    /**Creates a new generation.*/
    public void newGeneration(){
        board.increaseGeneration();
    }

    /**Changes the content in index row, col from true to false
     * and the opposite*/
    public void flip(int row, int col){

        board.put(row, col, board.get(row,col));
    }


}
