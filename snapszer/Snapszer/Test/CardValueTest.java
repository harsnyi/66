package Test;

import logic.CardList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardValueTest {
    CardList list;
    @Before
    public void setTest(){
        list = new CardList(1);
    }
    @Test
    public void ValueTest(){

        assertEquals(2,list.getValue("tok_also"));

        assertEquals(10,list.getValue("makk_10"));



    }
}
