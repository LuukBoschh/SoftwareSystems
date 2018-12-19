package ss.week5;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {
        //ComputerPlayer luuk = new ComputerPlayer(Mark.XX);
        //ComputerPlayer pieter = new ComputerPlayer(Mark.OO, new PerfectStrategy());
        ComputerPlayer luuk= new ComputerPlayer(Mark.OO, new PerfectStrategy());
        //ComputerPlayer pieter= new ComputerPlayer(Mark.XX, new PerfectStrategy());
     	HumanPlayer pieter = new HumanPlayer("pieter", Mark.XX);
    	Game spel = new Game(pieter,luuk);
   
        spel.start();
    }
}
