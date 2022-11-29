package Test;

import logic.CardList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsAduTest {

    String kartya1;
    String kartya2;
    String adu;
    CardList list;

    @Before
    public void setTest(){

        kartya1 = "piros_10";
        kartya2 = "zold_10";

        adu = "zold_asz";

        list = new CardList(1);
    }

    @Test
    public void test(){

        assertFalse(list.isAdu(kartya1, adu));

        assertTrue(list.isAdu(kartya2,adu));


    }

}
