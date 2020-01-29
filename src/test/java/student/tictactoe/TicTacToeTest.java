package student.tictactoe;

import student.tictactoe.TicTacToe;
import student.tictactoe.Evaluation;

import org.junit.Test;
import static org.junit.Assert.*;


public class TicTacToeTest {
    // covers InvalidInput
    @Test
    public void nullInput() {
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
    // XMoves > OMoves + 1
    @Test
    public void tooManyXMoves() {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("X-XXOO--X"));
    }
    // OMoves > XMoves
    @Test
    public void tooManyOMoves() {
        assertEquals(Evaluation.UnreachableState, TicTacToe.evaluateBoard("O-XXO-O--"));
    }
    // covers Xwins
    @Test
    public void firstColumnXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("X-OXO-X--"));
    }
    @Test
    public void secondColumnXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("OX--X--XX"));
    }
    @Test
    public void thirdColumnXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("O-X-OX--X"));
    }
    @Test
    public void firstRowXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XXXO---O-"));
    }
    @Test
    public void secondRowXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("-O-XXX-O-"));
    }
    @Test
    public void thirdRowXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("-O-O--XXX"));
    }
    @Test
    public void leftDiagonalXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("XOO-X---X"));
    }
    @Test
    public void rightDiagonalXWins() {
        assertEquals(Evaluation.Xwins, TicTacToe.evaluateBoard("-OX-XOX--"));
    }
    // covers Owins
    @Test
    public void firstColumnOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("OXXO-XO--"));
    }
    @Test
    public void secondColumnOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XOXXO--O-"));
    }
    @Test
    public void thirdColumnOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XXO-XO--O"));
    }
    @Test
    public void firstRowOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("OOOXX--X-"));
    }
    @Test
    public void secondRowOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XX-OOOX--"));
    }
    @Test
    public void thirdRowOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("X--XX-OOO"));
    }
    @Test
    public void leftDiagonalOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("OXXXO---O"));
    }
    @Test
    public void rightDiagonalOWins() {
        assertEquals(Evaluation.Owins, TicTacToe.evaluateBoard("XXO-OXO--"));
    }
    // covers NoWinner
    @Test
    public void newBoard() {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("---------"));
    }
    @Test
    public void filledBoard() {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("XOXOXOXOX"));
    }
    @Test
    public void noWinnerBoard() {
        assertEquals(Evaluation.NoWinner, TicTacToe.evaluateBoard("O-XXXOO--"));
    }
}