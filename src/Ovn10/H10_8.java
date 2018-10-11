package Ovn10;

public class H10_8 {
    public static void main(String[] args){


        Board board = new Board();

        board.setStartPosition(3,3);

        while (board.possibleToMove()){
            board.makeOneStep();
        }
        board.print();


    }
}
