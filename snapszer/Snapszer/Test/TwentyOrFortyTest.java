package Test;

import logic.CardList;
import logic.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TwentyOrFortyTest {

    CardList list;
    User user;
    ArrayList<String> cards;
    @Before
    public void testSet(){
        list = new CardList(1);
        cards = new ArrayList<>();

        cards.add("piros_9");cards.add("makk_felso");cards.add("tok_also");cards.add("tok_felso");cards.add("makk_kiraly");cards.add("piros_10");

        list.setCardList(cards);
        user = new User("test",list);

    }

    @Test
    public void twentyOrFortyTest(){

        String[] playableCards = this.user.TwentyOrForty(list,"makk_10");

        assertEquals(40,user.getPoints());

        user.setPoints(0);

        playableCards = this.user.TwentyOrForty(list,"tok_kiraly");

        assertEquals(20,user.getPoints());

    }
}
