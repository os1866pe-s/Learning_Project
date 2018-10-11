package Ovn10;

public class LifeController {
    public static void main(String[] args){

        LifeBoard board = new LifeBoard(5, 5);
        LifeView window = new LifeView(board);



        while (true) {



            if (window.getCommand() == 2){
                board.increaseGeneration();
                window.update();
            }

            if (window.getCommand() == 3) {
                System.exit(0);
            }
        }
    }
}
