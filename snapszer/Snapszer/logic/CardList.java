package logic;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class CardList implements Serializable {

    private ArrayList<String> cardList = new ArrayList<>();

    public CardList(int gameType) {
        String[] prefix = {"tok", "piros", "makk", "zold"};
        if (gameType == 0) {

            for (int i = 0; i < 4; i++) {

                cardList.add(prefix[i] + "_10");
                cardList.add(prefix[i] + "_also");
                cardList.add(prefix[i] + "_felso");
                cardList.add(prefix[i] + "_kiraly");
                cardList.add(prefix[i] + "_asz");
            }
        } else if (gameType == 1) {
            for (int i = 0; i < 4; i++) {

                cardList.add(prefix[i] + "_9");
                cardList.add(prefix[i] + "_10");
                cardList.add(prefix[i] + "_also");
                cardList.add(prefix[i] + "_felso");
                cardList.add(prefix[i] + "_kiraly");
                cardList.add(prefix[i] + "_asz");
            }


        }
        Collections.shuffle(cardList);

    }

    public ArrayList<String> getCardList() {
        return cardList;
    }

    public void setCardList(ArrayList<String> list){
        this.cardList = list;
    }

    public void burn(int index){
        if (index > 0) {
            this.cardList.subList(0, index).clear();
        }
    }


    public int getValue(String card){
        if(card.contains("kiraly")){
            return 4;
        }
        else if(card.contains("9")) {
            return 0;
        }
        else if(card.contains("10")){
            return 10;
        }
        else if(card.contains("felso")){
            return 3;
        }
        else if(card.contains("also")){
            return 2;
        }
        else if(card.contains("asz")){
            return 11;
        }
        else{
            return -1;
        }
    }

    public boolean isAdu(String card, String adu) {
        return card.substring(0,2).equals((adu.substring(0,2)));
    }


    public int compareCards(String[] placedCars,User user,Bot bot,int prevWinner,String adu){


        int userPrevPoints = user.getPoints();
        int botPrevPoints = bot.getPoints();

        int cardValue = getValue(placedCars[0]);
        int opponentCardValue = getValue(placedCars[1]);
        int cardsSum = opponentCardValue + cardValue;
        String card = placedCars[0];
        String opponentCard = placedCars[1];
        boolean sameColour = card.substring(0,2).equals(opponentCard.substring(0,2));


        //Ha mindketten adu kártyát raktunk
        if(isAdu(opponentCard,adu) && isAdu(card,adu) && opponentCardValue > cardValue) bot.IncrementPoints(cardsSum);
        else if(isAdu(opponentCard,adu) && isAdu(card,adu) && opponentCardValue < cardValue) user.IncrementPoints(cardsSum);

        //Ha az egyikünk kártyája adu
        else if(!(isAdu(opponentCard,adu)) && isAdu(card,adu)) user.IncrementPoints(cardsSum);
        else if(isAdu(opponentCard,adu) && !(isAdu(card,adu))) bot.IncrementPoints(cardsSum);

        //Ha egyikünké se adu
        else if(sameColour && opponentCardValue > cardValue) bot.IncrementPoints(cardsSum);
        else if(sameColour && opponentCardValue < cardValue) user.IncrementPoints(cardsSum);

        else if(prevWinner == 0){
            if(!(sameColour) && !(this.isAdu(opponentCard,adu))) user.IncrementPoints(cardsSum);
        }else if(prevWinner == 1){
            if(!(sameColour) && !(this.isAdu(card,adu))) bot.IncrementPoints(cardsSum);
        }

        if(userPrevPoints < user.getPoints()){
            return 0;
        }else if(botPrevPoints < bot.getPoints()){
            return 1;
        }
        return 90;

    }

}
