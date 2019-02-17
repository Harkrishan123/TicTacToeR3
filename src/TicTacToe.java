public class TicTacToe {

    private String[][] board;
    private String currentPlayer;

    public TicTacToe() {
        board = new String[3][3];
        currentPlayer = " x ";
        createBoard();
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    private void createBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = i + "," + j;
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------------");
        }
        System.out.println();
    }
    
    public boolean checkDraw() {
        boolean draw = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals(i + "," + j)) {
                    draw = false;
                }
            }
        }
        return draw;
    }



    public boolean checkWinner() {
        return (checkRows() || checkColumns() || checkDiagonals());
    }


    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkCells(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }


    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkCells(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }


    private boolean checkDiagonals() {
        return ((checkCells(board[0][0], board[1][1], board[2][2])) || (checkCells(board[0][2], board[1][1], board[2][0])));
    }


    private boolean checkCells(String c1, String c2, String c3) {
        return ((c1.equals(c2)) && (c2.equals(c3)));
    }


    public void nextPlayer() {
        if (currentPlayer.equals(" x ")) {
            currentPlayer = " o ";
        } else {
            currentPlayer = " x ";
        }
    }

    public boolean validMove(int row, int col){
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col].equals(row + "," + col)) {
                    return true;
                }
                else{
                    System.out.println("That cell has already been taken, please choose another cell");
                }
            }
            else{
                System.out.println("Please enter a valid coordinate");
            }
        }
        else{
            System.out.println("Please enter a valid coordinate");
        }
        return false;
    }

    public void insertMark(int row, int col) {
        board[row][col] = currentPlayer;
    }
}