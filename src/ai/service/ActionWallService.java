
package ai.service;

import ai.entity.Pawn;
import ai.entity.Wall;


public interface ActionWallService {
    
    /*
    * Method in charge of stopping the northern pawn, the name of stalker is perfect when we see in the execution how he chases the rival
    * This checks if the method can place a wall to the left-front or right-front of the pawn
    */
    
    public Wall northStalkerWall(Character[][] board, Pawn pawn, Wall wall);
    
    /*
    * Method in charge of stopping the southern pawn, the name of stalker is perfect when we see in the execution how he chases the rival
    * This checks if the method can place a wall to the left-front or right-front of the pawn
    */
    
    public Wall southStalkerWall(Character[][] board, Pawn pawn, Wall wall);
}
