
package test;

import ai.implement.AI;
import ai.entity.Board;
import ai.entity.Pawn;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AITest {
    
    public AITest() {
        
    }
    private String board;
    
    
    private Pawn unExpectedPawn;
    private Pawn expectedPawn;
    private AI artIntelligence;
    
    
    @Before
    public void init() {
        artIntelligence = new AI();
        board = "  N     N     N                                                                                                                                                                                                                                                                   S     S     S  ";
    }
    
    @After
    public void done() {
    }
    
    @Test
    public void chooseTest(){    
        Board quoridor = new Board(board);
        String side = "N";        
        
        int[] unExpectedMovement = new int[]{0,0,0,0};
        
        int[]movement = artIntelligence.choose(side, quoridor);
        
        int[] expectedMovement = new int[]{0,1,1,1};
        
        Assert.assertArrayEquals(expectedMovement, movement);
        
        if(unExpectedMovement == movement){
            fail("Method choose failed");
        }
    }
    
    @Test
    public void southAnalyzeNorth(){
        Board quoridor = new Board(board);
        
        Pawn expPawn = new Pawn(0, 2, "N");
        Pawn result = artIntelligence.southAnalyzeNorth(quoridor.getBoard());
        
        assertEquals(expPawn.toString(), result.toString());
        
        if(result.getName().equalsIgnoreCase("S")){
            fail("Method: southAnalyzeNorth failed, something is really wrong if this method fails ");
        }
    }
    
    @Test
    public void northAnalyzeSouth(){
        Board quoridor = new Board(board);
        
        Pawn expPawn = new Pawn(16, 14, "S");
        Pawn result = artIntelligence.northAnalyzeSouth(quoridor.getBoard());
        
        assertEquals(expPawn.toString(), result.toString());
        
        if(result.getName().equalsIgnoreCase("N")){
            fail("Method: northAnalyzeSouth failed, something is really wrong if this method fails ");
        }
    }
    
   ///North Pawns/////////////////////

    @Test
    public void savePawnNorth(){
        Board quoridor = new Board(board);
        String side = "N";     
                
        Pawn expPawn = new Pawn(0, 2, "N");
        
        Pawn result = artIntelligence.savePawnNorth(quoridor.getBoard(), side);
        
        assertEquals(expPawn.toString(), result.toString());
        
        if(result.getName().equalsIgnoreCase("S")){
            fail("Method: savePawnNorth failed, something is really wrong if this method fails ");
        }
    }
    
    @Test
    public void northMoveOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 2, "N");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveOkJumpTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(4, 2, "N");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveOkLeftWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(0, 0, "N");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveOkRightWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(0, 4, "N");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveOkJumpRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','S',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 4, "N");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveOkRightPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 2, "N");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ','N','|',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 0, "N");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ','|',' ',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 4, "N");
                 
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveNotOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ','N','|',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 0, "N");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveNotOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ','|',' ',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 4, "N");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveNotOkRightPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 4, "N");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northMoveNotOkLeftPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "N");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 0, "N");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: northMove failed");
        }
    }
    
    @Test
    public void northAdvanceOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        expectedPawn = new Pawn(2, 2, "N");
        Boolean result = artIntelligence.northAdvance(miniBoard, pawn);
        
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!expectedPawn.toString().equals(pawn.toString()) || result == null){
            fail("Method: northAdvance failed");
        }
    }
    
    @Test
    public void northAdvanceNotOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        unExpectedPawn = new Pawn(0, 2, "N");
        Boolean result = artIntelligence.northAdvance(miniBoard, pawn);
        
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(unExpectedPawn.toString().equals(pawn.toString()) || result == null){
            fail("Method: northAdvance failed");
        }
    }
    
    @Test
    public void northMoveRightOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 2, "N");
        result = artIntelligence.northMoveRight(miniBoard, result);
        expectedPawn = new Pawn(0, 4, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveRightOkJumpPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','S',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 0, "N");
        result = artIntelligence.northMoveRight(miniBoard, result);
        expectedPawn = new Pawn(2, 4, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveRightNotOkPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 0, "N");
        result = artIntelligence.northMoveRight(miniBoard, result);
        unExpectedPawn = new Pawn(0, 4, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveRightNotOkPawnWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ','|',' '},
        {' ',' ',' ','*',' '},
        {'N',' ','S','|',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 0, "N");
        result = artIntelligence.northMoveRight(miniBoard, result);
        unExpectedPawn = new Pawn(0, 4, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveRightNotOkPawnPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','S',' ','S'},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 0, "N");
        result = artIntelligence.northMoveRight(miniBoard, result);
        unExpectedPawn = new Pawn(0, 4, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveLeftOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 2, "N");
        result = artIntelligence.northMoveLeft(miniBoard, result);
        expectedPawn = new Pawn(0, 0, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveLeftOkJumpPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "N");
        result = artIntelligence.northMoveLeft(miniBoard, result);
        expectedPawn = new Pawn(2, 0, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveLeftNotOkPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 4, "N");
        result = artIntelligence.northMoveLeft(miniBoard, result);
        unExpectedPawn = new Pawn(0, 0, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveLeftNotOkPawnWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ','|',' ',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|','S',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "N");
        result = artIntelligence.northMoveLeft(miniBoard, result);
        unExpectedPawn = new Pawn(2, 0, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northMoveLeftNotOkPawnPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'S',' ','S',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "N");
        result = artIntelligence.northMoveLeft(miniBoard, result);
        unExpectedPawn = new Pawn(2, 0, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 2, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(0, 0, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 2, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(0, 4, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsOkJumpRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','S',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 0, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(2, 4, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsOkJumpLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(2, 0, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsOkRightLeftCornerTest(){
        Character[][] miniBoard = new Character[][]
            
        {{'N',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 0, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(0, 2, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsOkLeftRightCornerTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(0, 4, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(0, 2, "N");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsNotOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ','|',' ',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 2, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(2, 0, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsNotOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ','N','|',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 2, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(2, 4, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsNotOkRightPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ','N'},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 2, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(4, 4, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void northDodgeWallsNotOkLeftPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 2, "N");
        result = artIntelligence.northDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(4, 0, "N");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
   ///South Pawns/////////////////////
    
    @Test
    public void savePawnSouth(){
        Board quoridor = new Board(board);
        String side = "S";     
                
        Pawn expPawn = new Pawn(16, 14, "S");
        Pawn result = artIntelligence.savePawnSouth(quoridor.getBoard(), side);
        
        assertEquals(expPawn.toString(), result.toString());
        
        if(result.getName().equalsIgnoreCase("N")){
            fail("Method: savePawnSouth failed, something is really wrong if this method fails ");
        }
    }
    
    @Test
    public void southMoveOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 2, "S");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveOkJumpTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(0, 2, "S");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveOkLeftWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(4, 0, "S");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveOkRightWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(4, 4, "S");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveOkJumpRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 4, "S");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveOkRightPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{'S',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'S',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 2, "S");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ',' ','|',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 0, "S");
                
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ','|','S',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        expectedPawn = new Pawn(2, 4, "S");
                 
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!pawn.toString().equals(expectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveNotOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ','S','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ',' ','|',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 0, "S");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveNotOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ','|','S',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        pawn = artIntelligence.northMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 4, "S");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveNotOkRightPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 4, "S");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southMoveNotOkLeftPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S',' ','S'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "S");
        pawn = artIntelligence.southMove(miniBoard, pawn);
        unExpectedPawn = new Pawn(2, 0, "S");
                 
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(pawn.toString().equals(unExpectedPawn.toString())){
            fail("Method: southMove failed");
        }
    }
    
    @Test
    public void southAdvanceOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        expectedPawn = new Pawn(2, 2, "S");
        Boolean result = artIntelligence.southAdvance(miniBoard, pawn);
        
        assertEquals(expectedPawn.toString(), pawn.toString());
        
        if(!expectedPawn.toString().equals(pawn.toString()) || result == null){
            fail("Method: southAdvance failed");
        }
    }
    
    @Test
    public void southAdvanceNotOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        unExpectedPawn = new Pawn(4, 2, "S");
        Boolean result = artIntelligence.southAdvance(miniBoard, pawn);
        
        assertNotEquals(unExpectedPawn.toString(), pawn.toString());
        
        if(unExpectedPawn.toString().equals(pawn.toString()) || result == null){
            fail("Method: southAdvance failed");
        }
    }
    
    @Test
    public void southMoveRightOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn result = new Pawn(4, 2, "S");
        result = artIntelligence.southMoveRight(miniBoard, result);
        expectedPawn = new Pawn(4, 4, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveRightOkJumpPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 0, "S");
        result = artIntelligence.southMoveRight(miniBoard, result);
        expectedPawn = new Pawn(2, 4, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveRightNotOkPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','S',' ',' '}};
        
        Pawn result = new Pawn(4, 0, "S");
        result = artIntelligence.southMoveRight(miniBoard, result);
        unExpectedPawn = new Pawn(4, 4, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveRightNotOkPawnWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ',' ','|',' '}};
        
        Pawn result = new Pawn(2, 0, "S");
        result = artIntelligence.southMoveRight(miniBoard, result);
        unExpectedPawn = new Pawn(2, 4, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveRightNotOkPawnPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N',' ','N'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 0, "S");
        result = artIntelligence.southMoveRight(miniBoard, result);
        unExpectedPawn = new Pawn(2, 4, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveLeftOkTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S',' ',' '}};
        
        Pawn result = new Pawn(4, 2, "S");
        result = artIntelligence.southMoveLeft(miniBoard, result);
        expectedPawn = new Pawn(4, 0, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveLeftOkJumpPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','N',' ','S'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "S");
        result = artIntelligence.southMoveLeft(miniBoard, result);
        expectedPawn = new Pawn(2, 0, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveLeftNotOkPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S',' ','S'}};
        
        Pawn result = new Pawn(4, 4, "S");
        result = artIntelligence.southMoveLeft(miniBoard, result);
        unExpectedPawn = new Pawn(4, 0, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveLeftNotOkPawnWallTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ','|','N',' ','S'},
        {' ','*',' ',' ',' '},
        {' ','|',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "S");
        result = artIntelligence.southMoveLeft(miniBoard, result);
        unExpectedPawn = new Pawn(2, 0, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southMoveLeftNotOkPawnPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'N',' ','N',' ','S'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "S");
        result = artIntelligence.southMoveLeft(miniBoard, result);
        unExpectedPawn = new Pawn(2, 0, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S',' ',' '}};
        
        Pawn result = new Pawn(4, 2, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(4, 0, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn result = new Pawn(4, 2, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(4, 4, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsOkJumpRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 0, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(2, 4, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsOkJumpLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','N',' ','S'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 4, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(2, 0, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsOkRightLeftCornerTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(4, 0, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(4, 2, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsOkLeftRightCornerTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ','S'}};
        
        Pawn result = new Pawn(4, 4, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        expectedPawn = new Pawn(4, 2, "S");
        
        assertEquals(expectedPawn.toString(), result.toString());
        
        if(!expectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsNotOkRightTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ','|','S',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 2, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(2, 4, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsNotOkLeftTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ','S','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ',' ','|',' '}};
        
        Pawn result = new Pawn(2, 2, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(2, 0, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsNotOkRightPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 2, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(0, 0, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
    
    @Test
    public void southDodgeWallsNotOkLeftPawnTest(){
        Character[][] miniBoard = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ','S',' ','S'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn result = new Pawn(2, 2, "S");
        result = artIntelligence.southDodgeWalls(miniBoard, result);
        unExpectedPawn = new Pawn(0, 4, "S");
        
        assertNotEquals(unExpectedPawn.toString(), result.toString());
        
        if(unExpectedPawn.toString().equals(result.toString())){
            fail("The pawn has not moved where it should");
        }
    }
}
