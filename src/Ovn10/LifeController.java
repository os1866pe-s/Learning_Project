package Ovn10;

public class LifeController {
    public static void main(String[] args){

        LifeBoard board = new LifeBoard(15, 15);
        LifeView window = new LifeView(board);

        Life life = new Life(board);


        while (true) {

            window.update();
            if (window.getCommand() == 2){
                life.newGeneration();
            }else if (window.getCommand() == 1){

                life.flip(window.getRow(),window.getCol());
            }else if (window.getCommand() == 3) {
                System.exit(0);
            }
        }
    }
}
