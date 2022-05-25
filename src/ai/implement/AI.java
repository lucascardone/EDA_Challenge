package ai.implement;

import ai.entity.Board;
import ai.entity.Pawn;
import ai.service.AIService;

public class AI implements AIService {

    ActionMove actionMove = new ActionMove();
    Boolean move = null;

    @Override
    public int[] choose(String side, Board board) {
        int[] movement = new int[4];
        if (side.equalsIgnoreCase("N")) {
            Pawn pawn = savePawnNorth(board.getBoard(), side);
            movement[0] = pawn.getRow() / 2;
            movement[1] = pawn.getCol() / 2;
            pawn = northMove(board.getBoard(), pawn);
            movement[2] = pawn.getRow() / 2;
            movement[3] = pawn.getCol() / 2;
        } else {
            Pawn pawn = savePawnSouth(board.getBoard(), side);
            movement[0] = pawn.getRow() / 2;
            movement[1] = pawn.getCol() / 2;
            pawn = southMove(board.getBoard(), pawn);
            movement[2] = pawn.getRow() / 2;
            movement[3] = pawn.getCol() / 2;
        }
        return movement;
    }

    @Override
    public Pawn southAnalyzeNorth(Character[][] board) {
        Pawn pawn = new Pawn();
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                if (board[i][j].equals('N')) {
                    pawn.setRow(i);
                    pawn.setCol(j);
                    pawn.setName("N");
                    if (board[pawn.getRow() + 1][pawn.getCol()] == ' ') {
                        break;
                    }
                }
            }
        }
        return pawn;
    }

    @Override
    public Pawn northAnalyzeSouth(Character[][] board) {
        Pawn pawn = new Pawn();
        for (int i = 16; i >= 0; i--) {
            for (int j = 16; j >= 0; j--) {
                if (board[i][j].equals('S')) {
                    pawn.setRow(i);
                    pawn.setCol(j);
                    pawn.setName("S");
                    if (board[pawn.getRow() - 1][pawn.getCol()] == ' ') {
                        break;
                    }
                }
            }
        }
        return pawn;
    }

////////////////// NORTH PAWNS ////////////////////
    @Override
    public Pawn savePawnNorth(Character[][] board, String side) {
        Pawn pawn = new Pawn();
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 17; j++) {
                if (board[i][j].equals(side.charAt(0))) {
                    pawn.setRow(i);
                    pawn.setCol(j);
                    pawn.setName(side);
                    if (actionMove.northCanPickPawn(board, pawn)) {
                        break;
                    }
                }
            }
        }
        return pawn;
    }

    @Override
    public Pawn northMove(Character[][] board, Pawn pawn) {
        if (!northAdvance(board, pawn)) {
            pawn = northDodgeWalls(board, pawn);
        }
        return pawn;
    }

    @Override
    public Boolean northAdvance(Character[][] board, Pawn pawn) {
        if (actionMove.northCanAdvance(board, pawn)) {
            if (actionMove.northCanJumpAdvance(board, pawn)) {
                pawn.setRow(pawn.getRow() + 4);
                move = true;
            } else {
                pawn.setRow(pawn.getRow() + 2);
                move = true;
            }
        } else if (actionMove.northCanJumpAdvance(board, pawn)) {
            pawn.setRow(pawn.getRow() + 4);
            move = true;
        } else {
            move = false;
        }
        return move;
    }

    @Override
    public Pawn northMoveRight(Character[][] board, Pawn pawn) {
        if (actionMove.canMoveRight(board, pawn)) {
            if (actionMove.northCanJumpMoveRight(board, pawn)) {
                pawn.setCol(pawn.getCol() + 4);
            } else {
                pawn.setCol(pawn.getCol() + 2);
            }
        } else if (actionMove.northCanJumpMoveRight(board, pawn)) {
            pawn.setCol(pawn.getCol() + 4);
        }
        return pawn;
    }

    @Override
    public Pawn northMoveLeft(Character[][] board, Pawn pawn) {
        if (actionMove.canMoveLeft(board, pawn)) {
            if (actionMove.northCanJumpMoveLeft(board, pawn)) {
                pawn.setCol(pawn.getCol() - 4);
            } else {
                pawn.setCol(pawn.getCol() - 2);
            }
        } else if (actionMove.northCanJumpMoveLeft(board, pawn)) {
            pawn.setCol(pawn.getCol() - 4);
        }
        return pawn;
    }

    @Override
    public Pawn northDodgeWalls(Character[][] board, Pawn pawn) {
        if (pawn.getCol() == 0) {
            pawn = northMoveRight(board, pawn);
        } else if (pawn.getCol() == 16) {
            pawn = northMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() + 1][pawn.getCol() - 1] == '*') {
            pawn = northMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() + 1][pawn.getCol() + 1] == '*') {
            pawn = northMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() + 1][pawn.getCol() + 1] == '*') {
            pawn = northMoveRight(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() + 1][pawn.getCol() - 1] == '*') {
            pawn = northMoveRight(board, pawn);
        } else if ((pawn.getCol() / 2) > 4) {
            pawn = northMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) < 4) {
            pawn = northMoveRight(board, pawn);
        } else {
            pawn = northMoveRight(board, pawn);
        }
        return pawn;
    }

////////////////// SOUTH PAWNS ////////////////////
    @Override
    public Pawn savePawnSouth(Character[][] board, String side) {
        Pawn pawn = new Pawn();
        for (int i = 16; i >= 0; i--) {
            for (int j = 16; j >= 0; j--) {
                if (board[i][j].equals(side.charAt(0))) {
                    pawn.setRow(i);
                    pawn.setCol(j);
                    pawn.setName(side);
                    if (actionMove.southCanPickPawn(board, pawn)) {
                        break;
                    }
                }
            }
        }
        return pawn;
    }

    @Override
    public Pawn southMove(Character[][] board, Pawn pawn) {
        if (!southAdvance(board, pawn)) {
            pawn = southDodgeWalls(board, pawn);
        }
        return pawn;
    }

    @Override
    public Boolean southAdvance(Character[][] board, Pawn pawn) {
        if (actionMove.southCanAdvance(board, pawn)) {
            if (actionMove.southCanJumpAdvance(board, pawn)) {
                pawn.setRow(pawn.getRow() - 4);
                move = true;
            } else {
                pawn.setRow(pawn.getRow() - 2);
                move = true;
            }
        } else if (actionMove.southCanJumpAdvance(board, pawn)) {
            pawn.setRow(pawn.getRow() - 4);
            move = true;
        } else {
            move = false;
        }
        return move;
    }

    @Override
    public Pawn southMoveRight(Character[][] board, Pawn pawn) {
        if (actionMove.canMoveRight(board, pawn)) {
            if (actionMove.southCanJumpMoveRight(board, pawn)) {
                pawn.setCol(pawn.getCol() + 4);
            } else {
                pawn.setCol(pawn.getCol() + 2);
            }
        } else if (actionMove.southCanJumpMoveRight(board, pawn)) {
            pawn.setCol(pawn.getCol() + 4);
        }
        return pawn;
    }

    @Override
    public Pawn southMoveLeft(Character[][] board, Pawn pawn) {
        if (actionMove.canMoveLeft(board, pawn)) {
            if (actionMove.southCanJumpMoveLeft(board, pawn)) {
                pawn.setCol(pawn.getCol() - 4);
            } else {
                pawn.setCol(pawn.getCol() - 2);
            }
        } else if (actionMove.southCanJumpMoveLeft(board, pawn)) {
            pawn.setCol(pawn.getCol() - 4);
        }
        return pawn;
    }

    @Override
    public Pawn southDodgeWalls(Character[][] board, Pawn pawn) {
        if (pawn.getCol() == 0) {
            pawn = southMoveRight(board, pawn);
        } else if (pawn.getCol() == 16) {
            pawn = southMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() - 1][pawn.getCol() - 1] == '*') {
            pawn = southMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() - 1][pawn.getCol() + 1] == '*') {
            pawn = southMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() - 1][pawn.getCol() + 1] == '*') {
            pawn = southMoveRight(board, pawn);
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() - 1][pawn.getCol() - 1] == '*') {
            pawn = southMoveRight(board, pawn);
        } else if ((pawn.getCol() / 2) > 4) {
            pawn = northMoveLeft(board, pawn);
        } else if ((pawn.getCol() / 2) < 4) {
            pawn = northMoveRight(board, pawn);
        } else {
            pawn = northMoveRight(board, pawn);
        }
        return pawn;
    }

}
