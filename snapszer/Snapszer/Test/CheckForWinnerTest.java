package Test;

import logic.GameLogic;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckForWinnerTest {
    GameLogic logic;

    @Before
    public void setTest(){
        logic = new GameLogic(1,1,"test",3);
    }
    @Test
    public void testCheckForWinner(){

        this.logic.getUser().setPoints(80);
        assertEquals(0,this.logic.checkForWinner());

        this.logic.getUser().setPoints(60);
        this.logic.getBot().setPoints(90);

        assertEquals(1,this.logic.checkForWinner());

        this.logic.getUser().setPoints(60);
        this.logic.getBot().setPoints(23);

        assertEquals(-1,this.logic.checkForWinner());

    }
}
