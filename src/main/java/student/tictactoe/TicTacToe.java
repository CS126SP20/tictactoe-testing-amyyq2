package student.tictactoe;

import student.tictactoe.Evaluation;

public class TicTacToe {
    public static Evaluation evaluateBoard(String boardState) {
        if (boardState == null) {
            return Evaluation.InvalidInput;
        }
        if (boardState.length() != 9) {
            return Evaluation.InvalidInput;
        }
        return Evaluation.NoWinner;
    }
    public static int getXMoves(String boardState) {
        int XMoves = 0;
        for (int i = 0; i < boardState.length(); i++) {
            if (Character.toLowerCase(boardState.charAt(i)) == 'x') {
                XMoves++;
            }
        }
        return XMoves;
    }
    public static int getOMoves(String boardState) {
        int OMoves = 0;
        for (int i = 0; i < boardState.length(); i++) {
            if (Character.toLowerCase(boardState.charAt(i)) == 'o') {
                OMoves++;
            }
        }
        return OMoves;
    }
}
