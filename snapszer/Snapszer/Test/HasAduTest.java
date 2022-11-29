package Test;

import logic.Bot;
import logic.CardList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HasAduTest {

    CardList list;
    Bot bot;
    ArrayList<String> cards;

    @Before
    public void setTest(){
        list = new CardList(1);
        cards = new ArrayList<>();
        cards.add("zold_kiraly");
        cards.add("piros_asz");
        cards.add("zold_9");
        cards.add("makk_10");
        cards.add("piros_felso");
        list.setCardList(cards);
        bot = new Bot(list,3);


    }

    @Test
    public void testPlayerMinValueIndex(){

        assertTrue(bot.hasAdu(list,"makk_asz"));
    }
}
