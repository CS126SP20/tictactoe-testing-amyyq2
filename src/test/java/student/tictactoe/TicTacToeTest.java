package student.tictactoe;

import student.tictactoe.TicTacToe;
import student.tictactoe.Evaluation;

import org.junit.Test;
import static org.junit.Assert.*;


public class TicTacToeTest {
    @Test
    public void simpleNoWinnerBoard() throws Exception {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O...X.X.."));
    }
}