package student.tictactoe;

import student.tictactoe.Evaluation;

public class TicTacToe {
    /**
     * Analyzes the state of the board and returns corresponding Evaluation value
     * @param boardState
     * @return Evaluation value
     */
    public static Evaluation evaluateBoard(String boardState) {
        if (boardState == null) {
            return Evaluation.InvalidInput;
        }
        if (boardState.length() != 9) {
            return Evaluation.InvalidInput;
        }
        int XMoves = getXMoves(boardState);
        int OMoves = getOMoves(boardState);
        if (XMoves > OMoves + 1) {
            return Evaluation.UnreachableState;
        }
        if (OMoves > XMoves) {
            return Evaluation.UnreachableState;
        }
        if (checkWinner(boardState) == 'X' && OMoves == XMoves) {
            return Evaluation.UnreachableState;
        }
        if (checkWinner(boardState) == 'O' && XMoves > OMoves) {
            return Evaluation.UnreachableState;
        }
        if (checkWinner(boardState) == 'X') {
            return Evaluation.Xwins;
        }
        if (checkWinner(boardState) == 'O') {
            return Evaluation.Owins;
        }
        return Evaluation.NoWinner;
    }

    /**
     * Gets number of X moves
     * @param boardState Assume valid board state
     * @return XMoves
     */
    public static int getXMoves(String boardState) {
        int XMoves = 0;
        for (int i = 0; i < boardState.length(); i++) {
            if (Character.toUpperCase(boardState.charAt(i)) == 'X') {
                XMoves++;
            }
        }
        return XMoves;
    }

    /**
     * Gets number of O moves
     * @param boardState Assume valid board state
     * @return OMoves
     */
    public static int getOMoves(String boardState) {
        int OMoves = 0;
        for (int i = 0; i < boardState.length(); i++) {
            if (Character.toUpperCase(boardState.charAt(i)) == 'O') {
                OMoves++;
            }
        }
        return OMoves;
    }

    /**
     * Checks board for winner
     * @param boardState Assume valid board state
     * @return 'X' if X wins, 'O' if O wins, 'n' if no winner
     */
    public static char checkWinner(String boardState) {
        Character[][] board = new Character[3][3];
        int currentPosition = 0;
        // convert boardState to 2D array of Characters
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Character.toUpperCase(boardState.charAt(currentPosition));
                currentPosition++;
            }
        }
        // check rows for winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                if (board[i][0] == 'X') {
                    return 'X';
                } else if (board[i][0] == 'O') {
                    return 'O';
                }
            }
        }
        // check columns for winner
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[0][j] == board[2][j]) {
                if (board[0][j] == 'X') {
                    return 'X';
                } else if (board[0][j] == 'O') {
                    return 'O';
                }
            }
        }
        // check left diagonal for winner
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            if (board[0][0] == 'X') {
                return 'X';
            } else if (board[0][0] == 'O') {
                return 'O';
            }
        }
        // check right diagonal for winner
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            if (board[0][2] == 'X') {
                return 'X';
            } else if (board[0][2] == 'O') {
                return 'O';
            }
        }
        return 'n';
    }
}
