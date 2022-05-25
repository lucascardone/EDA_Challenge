
package ai.entity;

public class Board {

    private Character[][] board = new Character[17][17];

    public Board(String quoridor) {
        int counter = 0;
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                board[i][j] = quoridor.charAt(counter);
                counter++;
            }
        }
    }

    public Character[][] getBoard() {
        return board;
    }

    public void setBoard(Character[][] board) {
        this.board = board;
    }
}

