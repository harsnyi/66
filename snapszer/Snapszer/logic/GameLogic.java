package logic;
import ui.game.GameWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GameLogic implements ActionListener, Serializable {

    private  GameWindow window;
    private final CardList cardList;
    private final User user;
    private final Bot bot;
    private String aduCard;
    private final String[] playedCards;
    private int rounds;
    private String[] twentyForty;
    private final int gameType;
    private int prevWinner;

    public GameLogic(int newOrLoad,int gameType,String name,int difficulty){

        if(newOrLoad == 1){
            this.rounds = 0;
            this.gameType = gameType;
            this.playedCards = new String[2];
            this.twentyForty = new String[2];
            this.prevWinner = 1;

            this.cardList = new CardList(gameType);

            this.user = new User(name,this.cardList);
            this.bot = new Bot(this.cardList,difficulty);


            this.aduCard = this.cardList.getCardList().get(0);
            this.cardList.burn(1);

        }else{

            GameLogic loaded = this.loadGame();

            this.rounds = loaded.rounds;
            this.playedCards = new String[2];
            this.twentyForty = new String[2];
            this.aduCard = loaded.aduCard;
            this.gameType = loaded.gameType;
            this.prevWinner = loaded.prevWinner;

            this.cardList = loaded.cardList;

            this.user = loaded.user;
            this.bot = loaded.bot;

        }

    }
    public void initWindow(){

        this.window = new GameWindow();
        this.window.setDeck(this.window.getCardDeckBot().getDeckCards(),this.user.getCardsInHand());
        this.window.setDeck(this.window.getCardDeckTop().getDeckCards(),this.bot.getCardsInHand(),"hatlap");

        this.window.getMidPanel().getAduAlsoSwitch().addActionListener(this);
        this.window.getMidPanel().getTwentyOrForty().addActionListener(this);
        this.window.getMidPanel().getActionButton().addActionListener(this);

        this.window.getMidPanel().getPoints().setText(this.user.getPoints()+ " Pont");

        if((this.rounds < 5 && this.gameType == 0) || (this.rounds < 7 && this.gameType == 1)){
            this.window.getMidPanel().setAdu(this.aduCard);
        }

    }

    public void Game() throws InterruptedException, IOException {

        while(!(this.user.emptyHands()) && this.checkForWinner() == -1) {

            System.out.println(this.bot.getCardsInHand());
            if(this.prevWinner == 0) {

                while (this.window.getMidPanel().getPlayCard1().getIcon() == null) {
                    Thread.sleep(1000);
                    if(this.user.getCheckedForPoints() == 1){

                        this.window.getCardDeckBot().removeListener(this.twentyForty,this.user.getCardsInHand());
                    }
                }

                if(this.user.getCheckedForPoints() == 1){
                    this.user.setCheckedForPoints(0);
                    this.window.getCardDeckBot().addListenerToAll();
                }
                this.setPlayedCards(0, this.user);

                Thread.sleep(1000);

                String placed = this.bot.placeCard(this.prevWinner,this.cardList,this.aduCard,this.playedCards[0],this.user);
                this.window.getMidPanel().setPlayCard2(placed);
                this.setPlayedCards(placed);

                Thread.sleep(3000);

            }
            else if(this.prevWinner == 1){

                Thread.sleep(1000);
                String placed = this.bot.placeCard(this.prevWinner,this.cardList,this.aduCard,this.playedCards[0],this.user);
                this.window.getMidPanel().setPlayCard2(placed);
                this.setPlayedCards(placed);

                while (this.window.getMidPanel().getPlayCard1().getIcon() == null) {

                    Thread.sleep(1000);

                }
                this.setPlayedCards(0, user);
                Thread.sleep(3000);

            }

            this.prevWinner = cardList.compareCards(this.playedCards,this.user,this.bot,this.prevWinner,this.aduCard);
            this.HandleNewCards();


            this.window.setDeck(this.window.getCardDeckBot().getDeckCards(),this.user.getCardsInHand());
            this.window.setDeck(this.window.getCardDeckTop().getDeckCards(),this.bot.getCardsInHand(),"hatlap");


            this.window.getMidPanel().getPoints().setText(this.user.getPoints()+ " Pont");
            this.window.getMidPanel().getPlayCard1().setIcon(null);
            this.window.getMidPanel().getPlayCard2().setIcon(null);

            this.playedCards[0] = null;
            this.playedCards[1] = null;
            this.roundIncrement();

        }
        this.declareWinner(this.checkForWinner());

    }
    public void setAduCard(String aduCard) {
        this.aduCard = aduCard;
    }

    public void setPlayedCards(int index,Player player) {
        for(int i = 0;i<player.getCardsInHand().size();i++){
            if(this.window.getMidPanel().getPlayCard1().getIcon().equals(this.window.getCardDeckBot().getDeckCards()[i].getIcon())){
                this.playedCards[index] = player.getCardsInHand().get(i);


            }
        }
    }

    public void HandleNewCards(){
        if(this.cardList.getCardList().size() > 1){
            user.ReplaceCard(this.cardList,this.playedCards[0],"0");
            bot.ReplaceCard(this.cardList,this.playedCards[1],"0");
        }else if(this.cardList.getCardList().size() == 1){
            if(this.prevWinner == 0){
                user.ReplaceCard(this.cardList,this.playedCards[0],"0");
                bot.ReplaceCard(this.cardList,this.playedCards[1],this.aduCard);
                window.getMidPanel().getAdu().setIcon(null);

            }else if(this.prevWinner == 1){
                bot.ReplaceCard(this.cardList,this.playedCards[1],"0");
                user.ReplaceCard(this.cardList,this.playedCards[0],this.aduCard);
                window.getMidPanel().getAdu().setIcon(null);

            }
        }else if(this.cardList.getCardList().size() < 1){
            user.ReplaceCard(this.cardList,this.playedCards[0],"0");
            bot.ReplaceCard(this.cardList,this.playedCards[1],"0");
        }
    }
    public void setPlayedCards(String botPlacedCard){
        this.playedCards[1] = botPlacedCard;
    }

    public void roundIncrement(){
        this.rounds++;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.window.getMidPanel().getAduAlsoSwitch() && this.cardList.getCardList().size() > 1){

            this.setAduCard(this.user.AduAlsoSwitch(this.cardList,this.aduCard));
            this.window.setDeck(this.window.getCardDeckBot().getDeckCards(),this.user.getCardsInHand());
            this.window.getMidPanel().setAdu(this.aduCard);

        }
        if(e.getSource() == this.window.getMidPanel().getTwentyOrForty() && this.getPrevWinner() == 0 && this.getUser().getCheckedForPoints() == 0){
            this.twentyForty = this.getUser().TwentyOrForty(this.getCardList(),this.aduCard);
            if(this.twentyForty != null){

                this.user.setCheckedForPoints(1);
            }
            this.getWindow().getMidPanel().getPoints().setText(user.getPoints()+ " Pont");
        }
        if(e.getSource() == this.window.getMidPanel().getActionButton()){
            int answer =JOptionPane.showConfirmDialog( null, "Szeretned-e menteni a jatek allasat?","Kilepes",JOptionPane.YES_NO_CANCEL_OPTION);

            if(answer == 1){

                System.exit(0);
            }
            else if(answer == 0){

                this.saveGame();
                System.exit(0);

            }
        }

    }

    public GameWindow getWindow() {
        return window;
    }

    public CardList getCardList() {
        return cardList;
    }

    public User getUser() {
        return user;
    }
    private void saveGame(){

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("savedGame.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.print("A jatek elmentve!");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private GameLogic loadGame(){
        GameLogic loadedGame;
        try {
            FileInputStream f =
                    new FileInputStream("savedGame.ser");
            ObjectInputStream in =
                    new ObjectInputStream(f);
            loadedGame = (GameLogic) in.readObject();
            in.close();
            System.out.print("A jatek sikeresen betoltve!");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return loadedGame;
    }
    public int checkForWinner(){

        if(user.getPoints() >= 66){

            return 0;

        }else if(bot.getPoints() >= 66){

            return 1;
        }
        return -1;
    }
    public void declareWinner(int winner) throws IOException {
        if(winner == 0){

            JOptionPane.showMessageDialog(null, "Nyertel!","Eredmeny",JOptionPane.INFORMATION_MESSAGE);
            this.writeToResults("Nyert ellene!");
            System.exit(0);

        }else if(winner == 1){

            JOptionPane.showMessageDialog(null, "Vesztettel! " + " Ellenfel pontja: " + bot.getPoints(),"Eredmeny",JOptionPane.INFORMATION_MESSAGE);
            this.writeToResults("Vesztett ellene!");
            System.exit(0);

        }else{

            JOptionPane.showMessageDialog(null, "Dontetlen! " +" Pontszamod: " + user.getPoints() + ", Ellenfel pontja: " + bot.getPoints(),"Eredmeny",JOptionPane.INFORMATION_MESSAGE);
            this.writeToResults("Dontetlent jatszott ellene!");
            System.exit(0);
        }
    }
    private void writeToResults(String result) throws IOException {

        BufferedWriter output = new BufferedWriter(new FileWriter("results.txt", true));
        PrintWriter pw = new PrintWriter(output);

        String difficulty;
                switch(bot.getDifficulty()) {
            case 1:
                difficulty = "kezdo";
                break;
            case 2:
                difficulty = "kozepes";
                break;
            case 3:
                difficulty = "nehez";
                break;
            default:
                difficulty = "";
        }
        pw.println(java.time.LocalDate.now() + ";" + user.getName() + ";" + difficulty + ";" + result +  ";" + user.getPoints() + ";" +bot.getPoints());
        pw.close();
    }

    public int getPrevWinner() {
        return prevWinner;
    }

    public Bot getBot(){
        return this.bot;
    }

}
