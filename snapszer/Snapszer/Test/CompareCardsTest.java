package Test;

import logic.Bot;
import logic.CardList;
import logic.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompareCardsTest {

    User user;
    Bot bot;
    CardList list;
    ArrayList<String> cards;

    @Before
    public void beforeTest(){

        list = new CardList(1);
        cards = new ArrayList<>();

        cards.add("piros_9");cards.add("makk_asz");cards.add("tok_also");cards.add("tok_felso");cards.add("makk_kiraly");cards.add("piros_10");
        cards.add("tok_9");cards.add("tok_kiraly");cards.add("piros_also");cards.add("piros_felso");cards.add("makk_felso");cards.add("tok_asz");
        list.setCardList(cards);

        user = new User("test1",list);
        bot = new Bot(list,3);


    }
    @Test
    public void CompareTwoCards(){


        System.out.println(user.getCardsInHand());
        System.out.println(bot.getCardsInHand());
        String[] playedCards = {"tok_also","piros_felso"};
        int prevWinner = 1;

        prevWinner = list.compareCards(playedCards,this.user,this.bot,prevWinner,"tok_10");

        assertTrue(this.user.getPoints() > this.bot.getPoints());

        assertEquals(5,this.user.getPoints());




    }
}
