
package test;

import ai.implement.ActionMove;
import ai.entity.Pawn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ActionMoveTest {

    public ActionMoveTest() {
        
    }

    private ActionMove actionMove;
    private Boolean result;

    @Before
    public void init() {
        actionMove = new ActionMove();
        result = null;
    }

    @After
    public void done() {
    }
    
    //For the tests, a scale board will be used (17x17)->(5x5).
    
    ///General Pawns/////////////////////
    @Test
    public void canMoveLeftTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ','N'},
        {' ',' ',' ',' ','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "N");        
        result = actionMove.canMoveLeft(board, pawn);
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: canMoveLeft failed");
        }
    }
    
    @Test
    public void canMoveLeftFalseLeftWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ',' ','|','N'},
        {' ',' ',' ',' ','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "N");
        result = actionMove.canMoveLeft(board, pawn);
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: canMoveLeft failed");
        }
    }
    
    @Test
    public void canMoveLeftFalseLeftPawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ','N'},
        {' ',' ',' ',' ','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "N");
        result = actionMove.canMoveLeft(board, pawn);
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: canMoveLeft failed");
        }
    }
    
    @Test
    public void canMoveLeftNullTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        result = actionMove.canMoveLeft(board, pawn);
        assertEquals(null, result);
        
        if(result != null){
            fail("Method: canMoveLeft failed");
        }
    }
    
    @Test
    public void canMoveRightFalseRightWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ','S','|',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.canMoveRight(board, pawn);
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: canMoveRight failed");
        }
    }
    
    @Test
    public void canMoveRightFalseRightPawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ','S'}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.canMoveRight(board, pawn);
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: canMoveRight failed");
        }
    }
    
    @Test
    public void canMoveRightNullTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ','S'}};
        
        Pawn pawn = new Pawn(4, 4, "S");
        result = actionMove.canMoveRight(board, pawn);
        assertEquals(null, result);
        
        if(result != null){
            fail("Method: canMoveRight failed");
        }
    }

    ///North Pawns/////////////////////
    
    @Test
    public void northCanPickPawnTrueMiddleTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanPickPawnTrueLeftCornerWallTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ',' ',' ','N'},
        {'-','*','-',' ','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 0, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanPickPawnTrueLeftCornerTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 0, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanPickPawnTrueLeftCornerJumpPawnTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 0, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanPickPawnFalseLeftCornerTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 0, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanPickPawnFalseMiddleWallPawnTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {'N',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 0, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanPickPawnFalseLeftCornerPawnWallTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 0, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanPickPawnFalseLeftCornerPawnPawnTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'S',' ',' ',' ',' '}};
        
                
        Pawn pawn = new Pawn(0, 0, "N");
        result = actionMove.northCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanPickPawn failed");
        }
    }
    
    @Test
    public void northCanAdvanceTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanAdvance(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: northCanAdvance failed");
        }
    }
    
    @Test
    public void northCanAdvanceFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanAdvance(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanAdvance failed");
        }
    }
    
    @Test
    public void northCanAdvanceFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanAdvance(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanAdvance failed");
        }
    }
    
    @Test
    public void northCanJumpAdvanceTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanJumpAdvance(board, pawn);
        
        assertEquals(true, result);

        if(result == false){
            fail("Method: northCanJumpAdvance failed");
        }
    }
    
    @Test
    public void northCanJumpAdvanceFalseTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanJumpAdvance(board, pawn);
        
        assertEquals(false, result);

        if(result == true){
            fail("Method: northCanJumpAdvance failed");
        }
    }

    @Test
    public void northCanJumpAdvanceFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanJumpAdvance(board, pawn);
        
        assertEquals(false, result);

        if(result == true){
            fail("Method: northCanJumpAdvance failed");
        }
    }
    
    @Test
    public void northCanJumpAdvanceFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanJumpAdvance(board, pawn);
        
        assertEquals(false, result);

        if(result == true){
            fail("Method: northCanJumpAdvance failed");
        }
    }
    
    @Test
    public void northCanJumpAdvanceFalseBorderTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "N");
        result = actionMove.northCanJumpAdvance(board, pawn);
        
        assertEquals(false, result);

        if(result == true){
            fail("Method: northCanJumpAdvance failed");
        }
    }

    @Test
    public void northCanJumpMoveLeftTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "N");
        result = actionMove.northCanJumpMoveLeft(board, pawn);
        
        assertEquals(true, result);
                
        if(result == false){
            fail("Method: northCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void northCanJumpMoveLeftFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'S',' ','S',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "N");
        result = actionMove.northCanJumpMoveLeft(board, pawn);
        
        assertEquals(false, result);
                
        if(result == true){
            fail("Method: northCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void northCanJumpMoveLeftFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ','|',' ',' ',' '},
        {' ','*',' ',' ',' '},
        {' ','|','S',' ','N'},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "N");
        result = actionMove.northCanJumpMoveLeft(board, pawn);
        
        assertEquals(false, result);
                
        if(result == true){
            fail("Method: northCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void northCanJumpMoveLeftNullTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'S',' ','N',' ',' '},
        {'-','*','-',' ','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        result = actionMove.northCanJumpMoveLeft(board, pawn);
        
        assertEquals(null, result);
                
        if(result != null){
            fail("Method: northCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void northCanJumpMoveRightTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','S',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        result = actionMove.northCanJumpMoveRight(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: northCanJumpMoveRigh failed");
        }
    }
    
    @Test
    public void northCanJumpMoveRightFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','S',' ','S'},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        result = actionMove.northCanJumpMoveRight(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanJumpMoveRigh failed");
        }
    }
    
    @Test
    public void northCanJumpMoveRightFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ','|',' '},
        {' ',' ',' ','*',' '},
        {'N',' ','S','|',' '},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        result = actionMove.northCanJumpMoveRight(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanJumpMoveRigh failed");
        }
    }
    
    @Test
    public void northCanJumpMoveRightFalseBorderTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ','S'},
        {'-','*','-',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "N");
        result = actionMove.northCanJumpMoveRight(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: northCanJumpMoveRigh failed");
        }
    }
    
    ///South Pawns/////////////////////
    
    @Test
    public void southCanPickPawnTrueMiddleTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','S',' ',' '}};
        
                
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanPickPawnTrueLeftCornerWallTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ','-'},
        {'S',' ',' ',' ','S'}};
        
                
        Pawn pawn = new Pawn(4, 0, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanPickPawnTrueLeftCornerTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ','S',' ',' '}};
        
                
        Pawn pawn = new Pawn(4, 0, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanPickPawnTrueLeftCornerJumpPawnTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ','S',' ','S'}};
        
                
        Pawn pawn = new Pawn(4, 0, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanPickPawnFalseLeftCornerTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','S',' ',' '}};
        
                
        Pawn pawn = new Pawn(4, 0, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanPickPawnFalseMiddleWallPawnTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'S',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ','S',' ',' '}};
        
                
        Pawn pawn = new Pawn(4, 0, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanPickPawnFalseLeftCornerPawnWallTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'N',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ','S',' ',' '}};
        
                
        Pawn pawn = new Pawn(4, 0, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanPickPawnFalseLeftCornerPawnPawnTest(){
        Character[][] board = new Character[][]
            
        {{'N',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'S',' ','S',' ',' '}};
        
                
        Pawn pawn = new Pawn(4, 0, "S");
        result = actionMove.southCanPickPawn(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanPickPawn failed");
        }
    }
    
    @Test
    public void southCanAdvanceTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanAdvance(board, pawn);
        
        assertEquals(true, result);
        
                
        if(result == false){
            fail("Method: southCanAdvance failed");
        }
    }
    
    @Test
    public void southCanAdvanceFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanAdvance(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanAdvance failed");
        }
    }
    
    @Test
    public void southCanAdvanceFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanAdvance(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanAdvance failed");
        }
    }

    @Test
    public void southCanJumpAdvanceTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanJumpAdvance(board, pawn);
        
        assertEquals(true, result);

        if(result == false){
            fail("Method: southCanJumpAdvance failed");
        }
    }
    
    @Test
    public void southCanJumpAdvanceFalseTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanJumpAdvance(board, pawn);
        
        assertEquals(false, result);

        if(result == true){
            fail("Method: southCanJumpAdvance failed");
        }
    }

    @Test
    public void southCanJumpAdvanceFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanJumpAdvance(board, pawn);
        
        assertEquals(false, result);

        if(result == true){
            fail("Method: southCanJumpAdvance failed");
        }
    }
    
    @Test
    public void southCanJumpAdvanceFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '}};
        
        Pawn pawn = new Pawn(4, 2, "S");
        result = actionMove.southCanJumpAdvance(board, pawn);
        
        assertEquals(false, result);

        if(result == true){
            fail("Method: southCanJumpAdvance failed");
        }
    }
    
    @Test
    public void southCanJumpAdvanceFalseBorderTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(0, 2, "S");
        result = actionMove.southCanJumpAdvance(board, pawn);
        
        assertEquals(null, result);

        if(result != null){
            fail("Method: southCanJumpAdvance failed");
        }
    }

    @Test
    public void southCanJumpMoveLeftTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','N',' ','S'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "S");
        result = actionMove.southCanJumpMoveLeft(board, pawn);
        
        assertEquals(true, result);
                
        if(result == false){
            fail("Method: southCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void southCanJumpMoveLeftFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {'N',' ','N',' ','S'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "S");
        result = actionMove.southCanJumpMoveLeft(board, pawn);
        
        assertEquals(false, result);
                
        if(result == true){
            fail("Method: southCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void southCanJumpMoveLeftFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ','|','N',' ','S'},
        {' ','*',' ',' ',' '},
        {' ','|',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 4, "S");
        result = actionMove.southCanJumpMoveLeft(board, pawn);
        
        assertEquals(false, result);
                
        if(result == true){
            fail("Method: southCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void southCanJumpMoveLeftNullTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {'N',' ','S',' ',' '},
        {'-','*','-',' ','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        result = actionMove.southCanJumpMoveLeft(board, pawn);
        
        assertEquals(null, result);
                
        if(result != null){
            fail("Method: southCanJumpMoveLeft failed");
        }
    }
    
    @Test
    public void southCanJumpMoveRightTrueTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "S");
        result = actionMove.southCanJumpMoveRight(board, pawn);
        
        assertEquals(true, result);
        
        if(result == false){
            fail("Method: southCanJumpMoveRigh failed");
        }
    }
    
    @Test
    public void southCanJumpMoveRightFalsePawnTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N',' ','N'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "S");
        result = actionMove.southCanJumpMoveRight(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanJumpMoveRigh failed");
        }
    }
    
    @Test
    public void southCanJumpMoveRightFalseWallTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-','*','-',' ',' '},
        {'S',' ','N','|',' '},
        {' ',' ',' ','*',' '},
        {' ',' ',' ','|',' '}};
        
        Pawn pawn = new Pawn(2, 0, "S");
        result = actionMove.southCanJumpMoveRight(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanJumpMoveRigh failed");
        }
    }
    
    @Test
    public void southCanJumpMoveRightFalseBorderTest() {
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S',' ','N'},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 0, "S");
        result = actionMove.southCanJumpMoveRight(board, pawn);
        
        assertEquals(false, result);
        
        if(result == true){
            fail("Method: southCanJumpMoveRigh failed");
        }
    }
    
}
