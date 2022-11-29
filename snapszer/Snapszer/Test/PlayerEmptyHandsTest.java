package Test;

import logic.CardList;
import logic.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class PlayerEmptyHandsTest {
    ArrayList<String> cards;
    User user;
    CardList list;

    @Before
    public void setTest(){
        cards = new ArrayList<>();
        for(int i = 0;i<5;i++){
            cards.add("0");
        }
        list = new CardList(1);
        list.setCardList(cards);
        user = new User("test",list);

    }
    @Test
    public void test(){
        assertTrue(this.user.emptyHands());
    }


}
