package Test;

import logic.Bot;
import logic.CardList;
import logic.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckSizeTest {

    CardList cardList1;
    int cardList1Count;

    @Before
    public void setUp(){

        cardList1 = new CardList(1);
        cardList1Count = cardList1.getCardList().size();

    }

    @Test
    public void testCardListSize(){
        new Bot(cardList1,1);
        assertEquals("A pakli öttel kevesebb kártyát tartalmaz a kiosztás után.",cardList1Count-5,cardList1.getCardList().size());

        new User("Laci",cardList1);
        assertEquals("A pakli tízzel kevesebb kártyát tartalmaz a kiosztás után.",cardList1Count-10,cardList1.getCardList().size());

    }
}
