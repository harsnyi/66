package Test;

import logic.Bot;
import logic.CardList;
import logic.GameLogic;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class PlayerMinValueIndexTest {

    CardList list;
    Bot bot;
    int[] values;
    ArrayList<String> cards;

    @Before
    public void setTest(){
        list = new CardList(1);
        cards = new ArrayList<>();
        cards.add("piros_kiraly");
        cards.add("tok_asz");
        cards.add("zold_9");
        cards.add("tok_10");
        cards.add("piros_felso");
        list.setCardList(cards);
        bot = new Bot(list,3);
        values  = bot.getValues(list);


    }

    @Test
    public void testPlayerMinValueIndex(){
        for (int value : values) {
            System.out.print(value + " ");
        }

        //A legkisebb értékű kártyának a második helyen kell állnia.
        assertEquals(2,bot.minValueIndex(values));
    }
}
