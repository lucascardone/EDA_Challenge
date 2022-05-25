
package test;

import ai.implement.ActionWall;
import ai.entity.Pawn;
import ai.entity.Wall;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ActionWallTest {
    
    public ActionWallTest() {
    }
    
    private Wall result;
    private Wall expResult;
    
    ActionWall actionWall;
    
    @Before
    public void init() {
        actionWall = new ActionWall();
        result = new Wall();
        expResult = new Wall();
    }
    
    @After
    public void done() {
    }

    @Test
    public void northStalkerWallOkLeftTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {'-',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        expResult = new Wall(3, 3, "h");
        
        result = actionWall.northStalkerWall(board, pawn, result);
        
        assertEquals(expResult.toString(), result.toString());
        
        if(!result.toString().equals(expResult.toString())){
            fail("Method northStalkerWall has failed");
        }
    }
    
    @Test
    public void northStalkerWallOkRightTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ',' ',' ','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        expResult = new Wall(3, 1, "h");
        
        result = actionWall.northStalkerWall(board, pawn, result);
        
        assertEquals(expResult.toString(), result.toString());
        
        if(!result.toString().equals(expResult.toString())){
            fail("Method northStalkerWall has failed");
        }
    }
    
    @Test
    public void northStalkerWallNullTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ','N',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "N");
        expResult = new Wall();
        
        result = actionWall.northStalkerWall(board, pawn, result);
        
        assertEquals(expResult.toString(), result.toString());
        
        if(!result.toString().equals(expResult.toString())){
            fail("Method northStalkerWall throws an invalid movement");
        }
    }
    
    @Test
    public void southStalkerWallOkRightTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ',' ',' ','-'},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        expResult = new Wall(1, 1, "h");
        
        result = actionWall.southStalkerWall(board, pawn, result);
        
        assertEquals(expResult.toString(), result.toString());
        
        if(!result.toString().equals(expResult.toString())){
            fail("Method northStalkerWall has failed");
        }
    }
    
    @Test
    public void southStalkerWallOkLeftTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {'-',' ',' ',' ',' '},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        expResult = new Wall(1, 3, "h");
        
        result = actionWall.southStalkerWall(board, pawn, result);
        
        assertEquals(expResult.toString(), result.toString());
        
        if(!result.toString().equals(expResult.toString())){
            fail("Method northStalkerWall has failed");
        }
    }
    
    @Test
    public void southStalkerWallNullTest(){
        Character[][] board = new Character[][]
            
        {{' ',' ',' ',' ',' '},
        {' ',' ','-','*','-'},
        {' ',' ','S',' ',' '},
        {' ',' ',' ',' ',' '},
        {' ',' ',' ',' ',' '}};
        
        Pawn pawn = new Pawn(2, 2, "S");
        expResult = new Wall();
        
        result = actionWall.southStalkerWall(board, pawn, result);
        
        assertEquals(expResult.toString(), result.toString());
        
        if(!result.toString().equals(expResult.toString())){
            fail("Method southStalkerWall throws an invalid movement");
        }
    }
}
