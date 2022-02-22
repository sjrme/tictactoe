public class Board {

    Pieces[][] board  = new Pieces[3][3];
    private final int END_LINE = 2;
    int freeSpots = 9;
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Pieces.BLANK;
            }
        }
    }

    public boolean placePiece(int spot, boolean isX) {
        if (spot < 0 || spot > 8) {
            System.out.println("Si que eres tonto.");
            return false;
        }

        int row = spot / 3;
        int col = spot % 3;
        if (board[row][col] != Pieces.BLANK) {
            System.out.println("Ya esta lleno ese lugar!");
            return false;
        }


        if (isX) {
            board[row][col] = Pieces.X;
        } else {
            board[row][col] = Pieces.O;
            System.out.println("Puse 0 en " + row + ", " + col);
        }
        freeSpots--;

        return true;
    }

    public boolean checkWinner() {
        boolean winner;
        winner = checkRows();
        if (!winner) {
            winner = checkColumns();
        }
        if (!winner) {
            winner = checkDiagonals();
        }
        return winner;
    }

    public boolean checkTie() {
        return freeSpots == 0;
    }
    private boolean checkRows() {
        for (int row = 0; row < 3; row++) {
            Pieces currentPiece = board[row][0];
            if (currentPiece == Pieces.BLANK) {
                continue;
            }
            for (int col = 1; col < 3; col++) {
                if (board[row][col] != currentPiece) {
                    break;
                } else if (col == END_LINE) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int col = 0; col < 3; col++) {
            Pieces currentPiece = board[0][col];
            if (currentPiece == Pieces.BLANK) {
                continue;
            }
            for (int row = 1; row < 3; row++) {
                if (board[row][col] != currentPiece) {
                    break;
                } else if (row == END_LINE) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        Pieces currentPiece = board[0][0];
        if (currentPiece != Pieces.BLANK) {
            for (int i = 1; i < 3; i++) {
                if (board[i][i] != currentPiece) {
                    break;
                }
                if (i == END_LINE) {
                    return true;
                }
            }
        }
        currentPiece = board[2][0];
        if (currentPiece != Pieces.BLANK) {
            for (int i = 1; i < 3; i++) {
                if (board[2 - i][i] != currentPiece) {
                    break;
                }
                if (i == END_LINE) {
                    return true;
                }
            }
        }
        return false;
    }
    private enum Pieces {
        X,
        O,
        BLANK
    }
}
