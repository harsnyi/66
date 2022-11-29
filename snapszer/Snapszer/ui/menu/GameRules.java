package ui.menu;

import javax.swing.*;

public class GameRules extends JFrame{
    JLabel rules;
    public GameRules(){
        rules = new JLabel("<html>\n" +
                "    <body>" +
                "        <h1> kártyalapok értékei:</h1>" +
                "            <ul>" +
                "                <li>Ász: 11 pont</li>    \n" +
                "                <li>Tízes: 10 pont</li> \n" +
                "                <li>Király: 4 pont</li> \n" +
                "                <li>Felső: 3 pont</li> \n" +
                "                <li>Alsó: 2 pont</li> \n" +
                "\n" +
                "            </ul>\n" +
                "        <h1>Húsz, Negyven:</h1> " +
                "" +
                "            <p>Az egy kézben lévő azonos színű király és felső 20-at, ha az adu színéből van, 40 pontot ér – de a végelszámolásnál csak akkor számít be a pont, ha ütések is vannak mellette. Ha kettő is van kézben, csak egy mondható be. A bemondott húsz vagy negyven után ki kell hívni a királyt vagy a felsőt. Összesen elvileg 100 pontot lehet bemondani.</p>  \n" +
                "        <h1>Cserélés</h1>\n" +
                "            <p>A soron következő játékos a talon alján levő adut az adu alsóval kicserélheti.</p>\n" +
                "\n" +
                "    </body>\n" +
                "\n" +
                "</html>");
        this.add(rules);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.setTitle("Játék szabályok");
        this.setSize(400, 600);
        this.setResizable(false);
        this.setVisible(true);

    }
}
