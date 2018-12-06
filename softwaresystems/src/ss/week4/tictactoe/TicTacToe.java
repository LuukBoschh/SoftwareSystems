package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        HumanPlayer luuk = new HumanPlayer("luuk", Mark.XX);
        HumanPlayer pieter = new HumanPlayer("pieter", Mark.OO);
    	Game spel = new Game(luuk, pieter);
   
        spel.start();
    }
}
