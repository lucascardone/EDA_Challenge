
package ai.implement;

import ai.entity.Pawn;
import ai.entity.Wall;
import ai.service.ActionWallService;


public class ActionWall implements ActionWallService{

    @Override
    public Wall northStalkerWall(Character[][] board, Pawn pawn, Wall wall) {
        if (pawn.getName().equalsIgnoreCase("N")) {
            if (board[pawn.getRow() + 1][pawn.getCol()] == ' ') {
                if (pawn.getCol() == 0) {
                    if (board[pawn.getRow() + 1][pawn.getCol() + 2] != '-') {
                        wall.setRow(pawn.getRow() + 1);
                        wall.setCol(pawn.getCol() + 1);
                        wall.setDirection("h");
                    }
                } else if (pawn.getCol() == 16) {
                    if (board[pawn.getRow() + 1][pawn.getCol() - 2] != '-') {
                        wall.setRow(pawn.getRow() + 1);
                        wall.setCol(pawn.getCol() - 1);
                        wall.setDirection("h");
                    }
                } else {
                    if (board[pawn.getRow() + 1][pawn.getCol() + 2] != '-') {
                        wall.setRow(pawn.getRow() + 1);
                        wall.setCol(pawn.getCol() + 1);
                        wall.setDirection("h");
                    } else if (board[pawn.getRow() + 1][pawn.getCol() - 2] != '-') {
                        wall.setRow(pawn.getRow() + 1);
                        wall.setCol(pawn.getCol() - 1);
                        wall.setDirection("h");
                    }
                }
            }
        }
        return wall;
    }

    @Override
    public Wall southStalkerWall(Character[][] board, Pawn pawn, Wall wall) {
        if (pawn.getName().equalsIgnoreCase("S")) {
            if (board[pawn.getRow() - 1][pawn.getCol()] == ' ') {
                if (pawn.getCol() == 0) {
                    if (board[pawn.getRow() - 1][pawn.getCol() + 2] != '-') {
                        wall.setRow(pawn.getRow() - 1);
                        wall.setCol(pawn.getCol() + 1);
                        wall.setDirection("h");
                    }
                } else if (pawn.getCol() == 16) {
                    if (board[pawn.getRow() - 1][pawn.getCol() - 2] != '-') {
                        wall.setRow(pawn.getRow() - 1);
                        wall.setCol(pawn.getCol() - 1);
                        wall.setDirection("h");
                    }
                } else {
                    if (board[pawn.getRow() - 1][pawn.getCol() + 2] != '-') {
                        wall.setRow(pawn.getRow() - 1);
                        wall.setCol(pawn.getCol() + 1);
                        wall.setDirection("h");
                    } else if (board[pawn.getRow() - 1][pawn.getCol() - 2] != '-') {
                        wall.setRow(pawn.getRow() - 1);
                        wall.setCol(pawn.getCol() - 1);
                        wall.setDirection("h");
                    }
                }
            }
        }
        return wall;
    }
}
