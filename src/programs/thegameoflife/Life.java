package programs.thegameoflife;

public class Life {

	private Board board;

	public Life(Board board){
		this.board = board;
	}

	public void increaseGeneration(){
		//TODO make it so it uses two matrixes instead of create a new one every turn
		boolean[][] tempBoard = new boolean[board.getCol()][board.getRow()];

		for (int r = 0; r < board.getCol(); r++){
			for (int k = 0; k < board.getRow(); k++){
				if (!board.get(r, k) && getNeighbours(r,k) == 3){
					tempBoard[r][k] = true;
				}else if (board.get(r, k) && (getNeighbours(r, k) < 2 || getNeighbours(r, k) > 3)){
					tempBoard[r][k] = false;
				}else{
					tempBoard[r][k] = board.get(r, k);
				}
			}
		}
		board.increaseGeneration();
		board.setNewBoard(tempBoard);
	}

	public int getNeighbours(int x, int y){
		int neighbours = 0;

		for (int i = x-1; i <= x+1; i++){
			for (int j = y-1; j <= y+1; j++){
				if (!(i == x && j == y)){
					neighbours += board.get(i,j) ? 1 : 0;
				}
			}
		}
		return neighbours;
	}

	public void flip(int x, int y){
		board.setGameBoard(x, y, !board.get(x,y));
	}


	public void flipWithScreenCord(int x, int y, int resolution){
		try {
			board.setGameBoard( (int) Math.floor(x / (float) resolution), (int) Math.floor(y / (float) resolution), !board.get((int) Math.floor(x / (float) resolution),(int) Math.floor(y / (float) resolution)));

		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Try click on the screen, array is out of bounds");
		}


	}
}
