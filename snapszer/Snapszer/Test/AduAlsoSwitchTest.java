package Test;

import logic.CardList;
import logic.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AduAlsoSwitchTest {

    CardList list;
    User user;
    ArrayList<String> cards;
    @Before
    public void testSet(){
        list = new CardList(1);
        cards = new ArrayList<>();

        cards.add("piros_9");cards.add("makk_also");cards.add("tok_also");cards.add("tok_felso");cards.add("makk_kiraly");cards.add("piros_10");

        list.setCardList(cards);
        user = new User("test",list);

    }

    @Test
    public void twentyOrFortyTest(){

        assertEquals("makk_also",user.AduAlsoSwitch(list,"makk_asz"));

        assertEquals("piros_10",user.AduAlsoSwitch(list,"piros_10"));

    }
}
