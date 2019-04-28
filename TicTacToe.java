import java.util.Random;
import java.util.Scanner;

public class TicTacToe{
	public static void main(String[]args){
		//create game board
		char[][] board = new char[5][5];
		
		//print inital board state
		
		//computer goes first, symbol is x
		//1. compute where to put symbol
		//1a. check if cell is empty -- if not, compute another location
		Random r = new Random();
		Scanner kb = new Scanner(System.in);
		int row, col;
		char symbol;
		boolean keepGoing = true;
		int turn = 1;
		
		//game continues to play until winner is determined
		do{
		symbol = 'X';
		
		row = r.nextInt(3);
		col = r.nextInt(3);
		
		//validate input before placing symbol on board
		while(board[row][col] == 'X' || board[row][col] == 'O'){
			row = r.nextInt(3);
			row = r.nextInt(3);
		}
		
		board[row][col] = symbol; // adds current symbol to board
		
		printBoard(board);
		keepGoing = !hasWinner(symbol, board, turn);
		if(!keepGoing){
			break;
		}
		turn++;
 		
		symbol = 'O';
		System.out.print("Enter row for O: ");
		row = kb.nextInt();
		System.out.print("Enter column for O: ");
		col = kb.nextInt();
		
		while(board[row][col] == 'X' || board[row][col] == 'O'){
			System.out.println("Invalid location.");
			System.out.println("Enter row for O: ");
			row = kb.nextInt();
			System.out.print("Enter column to place the O: ");
		    col = kb.nextInt();
			}
			
			board[row][col] = symbol;
			
	printBoard(board);
	keepGoing = !hasWinner(symbol, board, turn);
	if(!keepGoing){
		break;
	}
	turn++;
	}while(keepGoing);
}

	public static void printBoard(char[][] board){
		for(int row = 0; row < board.length; row++){
			for(int col = 0; col < board[0].length; col++){
				System.out.print(board[row][col] + "O");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static boolean hasWinner(char symbol, char[][] board, int turn){
		//check by rows
		for(int row = 0; row < board.length; row++){
			if(board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol){
				return true;
			}
		}
	
		//check by columns
		for(int col = 0; col < board[0].length; col++){
			if(board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol){
				return true;
			}
		}
		
		//check major diagonal -- if element in 00,11,22 is equal to current symbol
		if(board[0][0] == symbol && board [1][1] == symbol && board[2][2] == symbol){
			return true;
		}
		
		//check for sub diagonal -- if element in 02,11,20 is equal to current symbol
		if(board[0][2] == symbol && board [1][1] == symbol && board[2][0] == symbol){
			return true;
		}
		
		//check for draw
		if(turn == 9){
			return true;
		}
		
		return false;
	}
}