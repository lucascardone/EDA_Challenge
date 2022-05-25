
package ai.implement;

import ai.entity.Pawn;
import ai.service.ActionMoveService;

public class ActionMove implements ActionMoveService{

    Boolean move = null;

////////////////// GENERAL PAWNS ////////////////////
    
    @Override
    public Boolean canMoveLeft(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow()][pawn.getCol() - 1] == ' ') {
                move = board[pawn.getRow()][pawn.getCol() - 2] == ' ';
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

    @Override
    public Boolean canMoveRight(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow()][pawn.getCol() + 1] == ' ') {
                move = board[pawn.getRow()][pawn.getCol() + 2] == ' ';
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

////////////////// NORTH PAWNS ////////////////////
    
    @Override
    public Boolean northCanPickPawn(Character[][] board, Pawn pawn) {
        move = !(!northCanAdvance(board, pawn) && !northCanJumpAdvance(board, pawn) && !canMoveRight(board, pawn) && !canMoveLeft(board, pawn)
                && !northCanJumpMoveLeft(board, pawn) && !northCanJumpMoveRight(board, pawn));
        if (pawn.getCol() == 0) {
            if (board[pawn.getRow() + 1][pawn.getCol()] == '-') {
                if (!canMoveRight(board, pawn)){
                    move = false;
                }
            }
        } else if (pawn.getCol() == 16) {
            if (board[pawn.getRow() + 1][pawn.getCol()] == '-') {
                if (!canMoveLeft(board, pawn)){
                    move = false;
                }
            }
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() + 1][pawn.getCol() - 1] == '*') {
            if (!canMoveLeft(board, pawn)){
                move = false;
            }
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() + 1][pawn.getCol() + 1] == '*') {
            if (!canMoveLeft(board, pawn)){
                move = false;
            }
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() + 1][pawn.getCol() + 1] == '*') {
            if (!canMoveRight(board, pawn)){
                move = false;
            }
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() + 1][pawn.getCol() - 1] == '*') {
            if (!canMoveRight(board, pawn)){
                move = false;
            }
        }else{
            move = true;
        }
        return move;
    }

    @Override
    public Boolean northCanAdvance(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow() + 1][pawn.getCol()] == ' ') {
                move = board[pawn.getRow() + 2][pawn.getCol()] == ' ';
            } else {
                move = false;
            }
        } catch (Exception e) {
            System.out.println("Is this even possible?");
        }
        return move;
    }

    @Override
    public Boolean northCanJumpAdvance(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow() + 1][pawn.getCol()] == ' ') {
                if (board[pawn.getRow() + 2][pawn.getCol()] == 'S') {
                    if (board[pawn.getRow() + 3][pawn.getCol()] == ' ') {
                        move = board[pawn.getRow() + 4][pawn.getCol()] == ' ';
                    } else {
                        move = false;
                    }
                } else {
                    move = false;
                }
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

    @Override
    public Boolean northCanJumpMoveLeft(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow()][pawn.getCol() - 1] == ' ') {
                if (board[pawn.getRow()][pawn.getCol() - 2] == 'S') {
                    if (board[pawn.getRow()][pawn.getCol() - 3] == ' ') {
                        move = board[pawn.getRow()][pawn.getCol() - 4] == ' ';
                    } else {
                        move = false;
                    }
                } else {
                    move = false;
                }
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

    @Override
    public Boolean northCanJumpMoveRight(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow()][pawn.getCol() + 1] == ' ') {
                if (board[pawn.getRow()][pawn.getCol() + 2] == 'S') {
                    if (board[pawn.getRow()][pawn.getCol() + 3] == ' ') {
                        move = board[pawn.getRow()][pawn.getCol() + 4] == ' ';
                    } else {
                        move = false;
                    }
                } else {
                    move = false;
                }
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

////////////////// SOUTH PAWNS ////////////////////
    
    @Override
    public Boolean southCanPickPawn(Character[][] board, Pawn pawn) {
        move = !(!southCanAdvance(board, pawn) && !southCanJumpAdvance(board, pawn) && !canMoveRight(board, pawn) && !canMoveLeft(board, pawn)
                && !southCanJumpMoveLeft(board, pawn) && !southCanJumpMoveRight(board, pawn));
        if (pawn.getCol() == 0) {
            if (board[pawn.getRow() - 1][pawn.getCol()] == '-') {
                if (!canMoveRight(board, pawn)){
                    move = false;
                }
            }
        } else if (pawn.getCol() == 16) {
            if (board[pawn.getRow() - 1][pawn.getCol()] == '-') {
                if (!canMoveLeft(board, pawn)){
                    move = false;
                }
            }
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() - 1][pawn.getCol() - 1] == '*') {
            if (!canMoveLeft(board, pawn)){
                move = false;
            }
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() - 1][pawn.getCol() + 1] == '*') {
            if (!canMoveLeft(board, pawn)){
                move = false;
            }
        } else if ((pawn.getCol() / 2) % 2 == 0 && board[pawn.getRow() - 1][pawn.getCol() + 1] == '*') {
            if (!canMoveRight(board, pawn)){
                move = false;
            }
        } else if ((pawn.getCol() / 2) % 2 != 0 && board[pawn.getRow() - 1][pawn.getCol() - 1] == '*') {
            if (!canMoveRight(board, pawn)){
                move = false;
            }
        } else {
            move = true;
        }
        return move;
    }

    @Override
    public Boolean southCanAdvance(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow() - 1][pawn.getCol()] == ' ') {
                move = board[pawn.getRow() - 2][pawn.getCol()] == ' ';
            } else {
                move = false;
            }
        } catch (Exception e) {
            System.out.println("Is this even possible?");
        }
        return move;
    }

    @Override
    public Boolean southCanJumpAdvance(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow() - 1][pawn.getCol()] == ' ') {
                if (board[pawn.getRow() - 2][pawn.getCol()] == 'N') {
                    if (board[pawn.getRow() - 3][pawn.getCol()] == ' ') {
                        move = board[pawn.getRow() - 4][pawn.getCol()] == ' ';
                    } else {
                        move = false;
                    }
                } else {
                    move = false;
                }
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

    @Override
    public Boolean southCanJumpMoveLeft(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow()][pawn.getCol() - 1] == ' ') {
                if (board[pawn.getRow()][pawn.getCol() - 2] == 'N') {
                    if (board[pawn.getRow()][pawn.getCol() - 3] == ' ') {
                        move = board[pawn.getRow()][pawn.getCol() - 4] == ' ';
                    } else {
                        move = false;
                    }
                } else {
                    move = false;
                }
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

    @Override
    public Boolean southCanJumpMoveRight(Character[][] board, Pawn pawn) {
        try {
            if (board[pawn.getRow()][pawn.getCol() + 1] == ' ') {
                if (board[pawn.getRow()][pawn.getCol() + 2] == 'N') {
                    if (board[pawn.getRow()][pawn.getCol() + 3] == ' ') {
                        move = board[pawn.getRow()][pawn.getCol() + 4] == ' ';
                    } else {
                        move = false;
                    }
                } else {
                    move = false;
                }
            } else {
                move = false;
            }
        } catch (Exception e) {
        }
        return move;
    }

}
