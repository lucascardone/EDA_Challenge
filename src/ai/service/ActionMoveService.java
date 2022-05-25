
package ai.service;

import ai.entity.Pawn;


public interface ActionMoveService {
    
    public Boolean canMoveLeft(Character[][] board, Pawn pawn);
    
    public Boolean canMoveRight(Character[][] board, Pawn pawn);
    
    ////////////////// NORTH PAWNS ////////////////////
    
    /*
    * Method in charge of grabbing a pawn from the north, and if it can move even if vertical walls have been placed.
    * This is possible thanks to the calculation if the column where it is located the pawn is even or odd
    */
    
    public Boolean northCanPickPawn(Character[][] board, Pawn pawn);
    
    public Boolean northCanAdvance(Character[][] board, Pawn pawn);
    
    public Boolean northCanJumpAdvance(Character[][] board, Pawn pawn);
    
    public Boolean northCanJumpMoveLeft(Character[][] board, Pawn pawn);
    
    public Boolean northCanJumpMoveRight(Character[][] board, Pawn pawn);
    
    ////////////////// SOUTH PAWNS ////////////////////
    
    /*
    * Method in charge of grabbing a pawn from the south, and if it can move even if vertical walls have been placed.
    * This is possible thanks to the calculation if the column where it is located the pawn is even or odd
    */
    
    public Boolean southCanPickPawn(Character[][] board, Pawn pawn);
    
    public Boolean southCanAdvance(Character[][] board, Pawn pawn);
    
    public Boolean southCanJumpAdvance(Character[][] board, Pawn pawn);
    
    public Boolean southCanJumpMoveLeft(Character[][] board, Pawn pawn);
    
    public Boolean southCanJumpMoveRight(Character[][] board, Pawn pawn);
}
