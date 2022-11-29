package ui.game;




import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;


public class CardDeck extends JPanel implements Serializable {

    private final JLabel[] deckCards;
    private final MouseListener listener;
    public CardDeck(int y,boolean placable,MouseListener listener){
        setBounds(0, y, 1000, 300);
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(1, 5, 0, 0));
        deckCards = new JLabel[5];
        this.listener = listener;
        for(int i = 0;i < 5;i++){


            deckCards[i] = new JLabel("",SwingConstants.CENTER);
            if(placable) deckCards[i].addMouseListener(this.listener);

            this.add(deckCards[i]);

        }
    }
    public void removeListener(String[] cards,ArrayList<String> cardsInHand){
        for(int i = 0;i<cardsInHand.size();i++){
           if(!(cardsInHand.get(i).equals(cards[0]) || cardsInHand.get(i).equals(cards[1]))){
               deckCards[i].removeMouseListener(listener);
           }
        }
    }
    public void addListenerToAll(){
        for (JLabel deckCard : this.deckCards) {
            deckCard.addMouseListener(listener);
        }
    }


    public JLabel[] getDeckCards() {
        return deckCards;
    }


}

