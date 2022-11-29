package logic;


import java.io.Serializable;

public class Bot extends Player implements Serializable {

    private final int difficulty;
    public Bot(CardList list,int difficulty) {
        super(list);
        this.difficulty = difficulty;

    }
    public String placeCard(int prewWinner,CardList list,String adu,String placedCard,User user){
        if(this.difficulty == 1){
            return placeRandomCard();
        }
        else if(difficulty == 2){
            if(prewWinner == 1){
                String[] felsoKiraly = this.TwentyOrForty(list,adu);
                if(felsoKiraly != null){
                    return felsoKiraly[0];
                }
                else{
                    return this.getCardsInHand().get(minValueIndex(this.getValues(list)));
                }
            }
            else{
                return this.placeAgainst(list,placedCard);
            }


        }
        else if(difficulty == 3){
            if(prewWinner == 1){
                String[] felsoKiraly = this.TwentyOrForty(list,adu);
                if(felsoKiraly != null){
                    return felsoKiraly[0];
                }
                else{
                    return this.placeBetter(list,user,adu);
                }
            }
            else{
                return this.placeAgainst(list,placedCard);
            }

        }
        return "";

    }

    public int minValueIndex(int[] values){
        int min = values[0];
        for (int value : values) {
            if (min > value && value != -1) {
                min = value;
            }
        }
        for(int i = 0;i<values.length;i++){
            if(values[i] == min){
                return i;
            }
        }
        return min;
    }

    public String placeAgainst(CardList list,String card){
        int[] values = this.getValues(list);

        for(int i = 0;i<values.length;i++){
            if(values[i] != -1 && values[i] > list.getValue(card) && this.getCardsInHand().get(i).substring(0,2).equals(card.substring(0,2))){
                return this.getCardsInHand().get(i);
            }
        }
        return this.getCardsInHand().get(minValueIndex(values));
    }

    private String placeBetter(CardList list,User user,String adu){
        int[] values = this.getValues(list);
        int[] enemyValues = user.getValues(list);

        if(!(this.hasAdu(list,adu))){
            for(int i = 0;i<values.length;i++){
                int maxValue = -1;
                for(int j = 0;j<enemyValues.length;j++){

                    if(this.getCardsInHand().get(i).substring(0,2).equals(user.getCardsInHand().get(j).substring(0,2))){
                        if(maxValue < enemyValues[j]){
                            maxValue = enemyValues[j];
                        }
                    }
                }
                if(values[i] > maxValue) return  this.getCardsInHand().get(i);
            }
        }
        return this.getCardsInHand().get(minValueIndex(values));
    }

    private String placeRandomCard(){
        String randomCard = "0";
        while(randomCard.equals("0")){
            int index = (int)(Math.random() * this.getCardsInHand().size());
            randomCard = this.getCardsInHand().get(index);
        }
        return  randomCard;
    }

    public int getDifficulty() {
        return difficulty;
    }

}
