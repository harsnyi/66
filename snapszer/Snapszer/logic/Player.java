package logic;

import java.io.Serializable;
import java.util.ArrayList;

abstract public class Player implements Serializable {

    private int checkedForPoints;
    private int points;

    private final ArrayList<String> cardsInHand;
    public Player(CardList list){
        cardsInHand = new ArrayList<>();

        for(int i = 0;i<5;i++){
            cardsInHand.add(list.getCardList().get(i));
        }

        this.points = 0;
        this.checkedForPoints = 0;
        list.burn(5);

    }
    public void ReplaceCard(CardList cardList,String card,String notFromList){
            this.cardsInHand.remove(card);
            if(cardList.getCardList().size() > 0){
                this.cardsInHand.add(cardList.getCardList().get(0));
                cardList.burn(1);
            }else{
                this.cardsInHand.add(notFromList);
            }
    }
    public String AduAlsoSwitch(CardList cardList,String adu){
        for(int i = 0;i<this.getCardsInHand().size();i++){
            if(cardList.isAdu(this.cardsInHand.get(i),adu) && this.cardsInHand.get(i).contains("also")) {
                String temp = adu;
                adu = this.cardsInHand.get(i);
                this.cardsInHand.set(i,temp);
            }
        }
        return adu;
    }
    public String[] TwentyOrForty(CardList cardList, String adu){
        for(int i = 0;i<this.getCardsInHand().size();i++){
            for(int j = 0;j<this.getCardsInHand().size();j++){
                if(this.cardsInHand.get(i).contains("felso") && this.cardsInHand.get(j).contains("kiraly")
                        && this.cardsInHand.get(i).substring(0,2).equals(this.cardsInHand.get(j).substring(0,2))) {
                    if(cardList.isAdu(cardsInHand.get(i),adu)){
                        this.IncrementPoints(40);

                    }else{
                        this.IncrementPoints(20);
                    }

                    return new String[]{this.cardsInHand.get(i),this.cardsInHand.get(j)};

                }
            }
        }
        return null;
    }
    public boolean emptyHands(){
        for (String s : this.cardsInHand) {
            if (!(s.equals("0"))) {
                return false;
            }
        }
        return true;
    }
    public int[] getValues(CardList list){
        int[] cardValues = new int[5];
        for(int i = 0;i<this.getCardsInHand().size();i++){
            cardValues[i] = list.getValue(this.getCardsInHand().get(i));
        }
        return cardValues;
    }
    public boolean hasAdu(CardList list,String adu){
        for(int i = 0;i<this.getCardsInHand().size();i++){
            if(list.isAdu(this.cardsInHand.get(i),adu)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getCardsInHand() {
        return cardsInHand;
    }

    public int getPoints() {
        return points;
    }

    public void IncrementPoints(int points){
        this.points += points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getCheckedForPoints() {
        return checkedForPoints;
    }

    public void setCheckedForPoints(int checkedForPoints) {
        this.checkedForPoints = checkedForPoints;
    }
}
