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
    // covers InvalidInput
    @Test
    public void NullInput() {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard(null));
    }
    @Test
    public void inputLengthLessThan9() {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("01234567"));
    }
    @Test
    public void inputLengthGreaterThan9() {
        assertEquals(Evaluation.InvalidInput, TicTacToe.evaluateBoard("0123456789"));
    }
    // covers UnreachableState
    @Test
    public void moveAfterXWon() {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXXOO-O--"));
    }
    @Test
    public void moveAfterOWon() {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XO--OXXOX"));
    }
    @Test
    public void bothWim() {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("XXXOOO---"));
    }
    @Test
    public void tooManyXMoves() {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("X-XXOO--X"));
    }
    @Test
    public void tooManyOMoves() {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("O-XXO-O--"));
    }
}