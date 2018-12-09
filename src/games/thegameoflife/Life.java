package games.thegameoflife;

public class Life {

	private Board board;

	public Life(Board board){
		this.board = board;
	}

	public void increaseGeneration(){
		//TODO make it so it uses two matrixes instead of create a new one every turn
		boolean[][] tempBoard = new boolean[board.getCol()][board.getRow()];

		for (int r = 0; r < board.getRow();r++){
			for (int k = 0; k < board.getCol(); k++){
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

		for (int i = x-1; i < x+1; i++){
			for (int j = y-1; j < y+1; j++){
				if (!(x == i && y == j)){
					neighbours = board.get(x,y) ? neighbours + 1 : 0;
				}
			}
		}
		return neighbours;
	}

	public void flip(int x, int y){
		board.setGameBoard(x, y, !board.get(x,y));
	}
}
