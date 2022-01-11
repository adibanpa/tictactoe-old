
import java.util.Scanner;
import javax.swing.JFrame;

public class ttt{

	public char[][] board;
	public char marker;

	public static void main(String[] args){
		ttt test = new ttt();
		boolean ongoing = true;
		Scanner in = new Scanner(System.in);
		test.marker = 'x';

		while (ongoing){
			String row, col;
			int r, c;

			test.printBoard();
			if (test.isWin()){
				System.out.println("Congratulations! You Won!");
				break;
			} else if (test.isDraw()) {
				System.out.println("Looks like a Draw.");
				break;
			}

			System.out.println("Input Row: ");
			row = in.nextLine();

			System.out.println("Input Col: ");
			col = in.nextLine();

			r = Integer.parseInt(row) - 1;
			c = Integer.parseInt(col) - 1;
			if (test.inBound(r, c) == false){
				System.out.println("That is out of bounds. Choose a number between 1 and 3.");

			} else if (test.isEmpty(r, c) == false){
				System.out.println("That spot is taken");

			} else {
			test.placeMarker(r, c);
			test.changePlayer();
			}

		}
		
	}

	public ttt(){
		board = new char[3][3];
		for (int i = 0; i<3; i++){
			for (int j = 0; j<3; j++){
				board[i][j] = '-';
			}
		}

	}

	public void printBoard(){
		for (int i = 0; i<3; i++){
			System.out.println(board[i]);
		}
	}

	public boolean inBound(int a, int b){
		return (a >= 0 && a < 3 && b < 3 && b >= 0);
	}
	public boolean isEmpty(int a, int b){
		return (board[a][b] == '-');
	}

	public void changePlayer() {
        if (marker == 'x') {
            marker = 'o';
        }
        else {
            marker = 'x';
        }
    }
    public void placeMarker(int a, int b){
    	if (isEmpty(a, b)){
    		board[a][b] = marker;
    	}
    }

    public boolean checkmarker(char c1, char c2, char c3){
    	return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    public boolean rowWin(){
    	for (int i = 0; i<3; i++){
    		if (checkmarker(board[i][0], board[i][1], board[i][2]) == true){
    			return true;
    		}
    	}
    	return false;
    }

    public boolean colWin(){
    	for (int i = 0; i<3; i++){
    		if (checkmarker(board[0][i], board[1][i], board[2][i]) == true){
    			return true;
    		}
    	}
    	return false;

    }

    public boolean diagWin(){
    	return (checkmarker(board[0][0], board[1][1], board[2][2]) == true || checkmarker(board[0][2], board[1][1], board[2][0]));
    }

    public boolean isWin(){
    	return (rowWin() || colWin() || diagWin());
    }

    public boolean isFull(){
    	boolean full = true;

    	for (int i = 0; i<3; i++){
			for (int j = 0; j<3; j++){
				if (board[i][j] == '-'){
					full = false;
				}
			}
		}
		return full;
    }

    public boolean isDraw(){
    	return (isFull() && !isWin());
    }
	
}




	
