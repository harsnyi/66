import logic.*;
import ui.menu.MenuWindow;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {


            MenuWindow menu = new MenuWindow();

            while (menu.getGame() == 0){
                Thread.sleep(1000);

            }

            GameLogic play  = new GameLogic(menu.getGame(),
                                            menu.getOptionsWindow().getCards().getSelectedIndex(),
                                            menu.getOptionsWindow().name.getText(),
                                            menu.getOptionsWindow().getSlider().getValue());

            play.initWindow();
            play.Game();


    }


}
