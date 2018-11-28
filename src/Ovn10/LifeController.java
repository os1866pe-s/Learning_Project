package Ovn10;

public class LifeController {
    public static void main(String[] args){

        LifeBoard board = new LifeBoard(15, 15);
        LifeView window = new LifeView(board);

        Life life = new Life(board);


        while (true) {

            window.update();
            int command = window.getCommand();

            if (command == 2){
                life.newGeneration();
            }else if (command == 1){

                life.flip(window.getRow(),window.getCol());
            }else if (command == 3) {
                System.exit(0);
            }
        }
    }
}
