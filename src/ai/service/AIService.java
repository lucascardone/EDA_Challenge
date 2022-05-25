
package ai.service;

import ai.entity.Board;
import ai.entity.Pawn;


public interface AIService {
    
    /*
    * Returns a move according to the side with which the bot plays, the move is returned in an array of integers that is translated as follows:
    * movement[0] = fromRow; movement[1] = fromCol; movement[2] = toRow; movement[3] = toCol; 
    *
    */
    
    public int[] choose(String side, Board board);
    
    //AI analyzes the threat level of the northern pawns
    public Pawn southAnalyzeNorth(Character[][] board);
    
    //AI analyzes the threat level of the southern pawns
    public Pawn northAnalyzeSouth(Character[][] board);
    
    ////////////////// NORTH PAWNS ////////////////////
    
    //Save the position of the northern pawn that is closer to promoting and can move better than the other
    public Pawn savePawnNorth(Character[][] board, String side);
    
    //If the pawn cannot advance then it must move sideways
    public Pawn northMove(Character[][] board, Pawn pawn);
    
    public Boolean northAdvance(Character[][] board, Pawn pawn);
    
    public Pawn northMoveRight(Character[][] board, Pawn pawn);
    
    public Pawn northMoveLeft(Character[][] board, Pawn pawn);
    
    /*
    * This method is in charge of avoiding the walls for the northern pawns, 
    * this is done by calculating whether the pawn is in an even or odd column and where the heart of the wall = '*' is located according to its position
    *
    */
    
    public Pawn northDodgeWalls(Character[][] board, Pawn pawn);
    
    ////////////////// SOUTH PAWNS ////////////////////
    
    //Save the position of the southern pawn that is closer to promoting and can move better than the other
    public Pawn savePawnSouth(Character[][] board, String side);
    
    //If the pawn cannot advance then it must move sideways
    public Pawn southMove(Character[][] board, Pawn pawn);
    
    public Boolean southAdvance(Character[][] board, Pawn pawn);
    
    public Pawn southMoveRight(Character[][] board, Pawn pawn);
    
    public Pawn southMoveLeft(Character[][] board, Pawn pawn);
    
    /*
    * This method is in charge of avoiding the walls for the southern pawns, 
    * this is done by calculating whether the pawn is in an even or odd column and where the heart of the wall = '*' is located according to its position
    *
    */
    
    public Pawn southDodgeWalls(Character[][] board, Pawn pawn);
}
