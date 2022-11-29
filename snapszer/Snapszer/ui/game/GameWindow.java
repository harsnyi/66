package ui.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.util.ArrayList;

public class GameWindow extends JFrame implements Serializable {

    private final MidPanel midPanel;
    private final CardDeck cardDeckTop;
    private final CardDeck cardDeckBot;
    public GameWindow(){

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1000, 900));
        this.setResizable(false);
        this.setTitle("Snapszer");
        MouseListener listener= new DragMouseAdapter(this);

        cardDeckTop = new CardDeck(0,false,listener);
        midPanel = new MidPanel();
        cardDeckBot = new CardDeck(600,true,listener);

        this.add(cardDeckTop);
        this.add(midPanel);
        this.add(cardDeckBot);

        this.setLayout(null);
        this.setVisible(true);

    }

    public void setDeck(JLabel[] deck,ArrayList<String> cardsInHand){
        for(int i = 0;i<cardsInHand.size();i++){
            if(!(cardsInHand.get(i).equals("0"))) {


                String separator = System.getProperty("file.separator");
                ImageIcon imgThisImg = new ImageIcon("Snapszer"+separator+"cardpictures"+separator+cardsInHand.get(i)+".jpg");
                Image image = imgThisImg.getImage();
                Image newimg = image.getScaledInstance(160, 200, java.awt.Image.SCALE_SMOOTH);
                imgThisImg = new ImageIcon(newimg);
                deck[i].setIcon(imgThisImg);
            }else{
                deck[i].setIcon(null);
            }

        }
    }
    public void setDeck(JLabel[] deck,ArrayList<String> cardsInHand,String card){
        for(int i = 0;i<cardsInHand.size();i++){
            if(!(cardsInHand.get(i).equals("0"))){


                String separator = System.getProperty("file.separator");
                ImageIcon imgThisImg = new ImageIcon("Snapszer"+separator+"cardpictures"+separator+card+".jpg");
                Image image = imgThisImg.getImage();
                Image newimg = image.getScaledInstance(160, 200,  java.awt.Image.SCALE_SMOOTH);
                imgThisImg = new ImageIcon(newimg);
                deck[i].setIcon(imgThisImg);
            }else{
                deck[i].setIcon(null);
            }


        }
    }
    public CardDeck getCardDeckTop() {
        return cardDeckTop;
    }

    public CardDeck getCardDeckBot() {
        return cardDeckBot;
    }

    public MidPanel getMidPanel() {
        return midPanel;
    }



}
