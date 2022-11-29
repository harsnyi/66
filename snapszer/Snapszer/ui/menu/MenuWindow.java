package ui.menu;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class MenuWindow implements ActionListener {

    JFrame frame = new JFrame();
    JButton newGame;
    JButton loadGame;
    JButton results;
    JButton gameRules;
    JButton exit;
    JPanel panel;
    JPanel layout;
    JPanel btnPanel;

    int game;
    JLabel title;
    JPanel flow;
    OptionsWindow optionsWindow;


     public MenuWindow(){


         MenuBar menuBar = new MenuBar();
         optionsWindow= new OptionsWindow();


         panel = new JPanel(new BorderLayout());
         title = new JLabel("Snapszer kártyajáték",SwingConstants.CENTER);
         title.setFont(new Font("Serif", Font.BOLD, 24));
         title.setForeground(Color.ORANGE);


         layout = new JPanel(new GridBagLayout());
         layout.setBackground(Color.GRAY);
         btnPanel = new JPanel(new GridLayout(6, 1, 20, 20));
         btnPanel.setBackground(Color.GRAY);

         newGame = new JButton("Új játék kezdése");
         newGame.setBackground(Color.ORANGE);
         newGame.setOpaque(true);
         newGame.setPreferredSize(new Dimension(150, 60));

         loadGame = new JButton("Játék betöltése");
         loadGame.setBackground(Color.ORANGE);
         loadGame.setOpaque(true);

         gameRules = new JButton("Játék szabályok");
         gameRules.setBackground(Color.ORANGE);
         gameRules.setOpaque(true);

         results = new JButton("Eredmények");
         results.setBackground(Color.ORANGE);
         results.setOpaque(true);

         exit = new JButton("Kilépés");
         exit.setBackground(Color.ORANGE);
         exit.setOpaque(true);

         newGame.addActionListener(this);
         loadGame.addActionListener(this);
         gameRules.addActionListener(this);
         results.addActionListener(this);
         exit.addActionListener(this);

         btnPanel.add(title);
         btnPanel.add(newGame);
         btnPanel.add(loadGame);
         btnPanel.add(gameRules);
         btnPanel.add(results);
         btnPanel.add(exit);


         layout.add(btnPanel);
         panel.add(layout, BorderLayout.CENTER);
         frame.setTitle("66 Játék");

         flow = new JPanel(new GridLayout(1, 2, 20, 20));


         flow.add(optionsWindow);
         flow.add(panel);

         frame.add(flow);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLocationByPlatform(true);
         frame.setSize(700, 600);
         frame.setResizable(false);
         frame.setJMenuBar(menuBar);
         frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
        if(e.getSource() == newGame && this.getGame() == 0){

            if(this.getOptionsWindow().name.getText().equals("")){
                this.optionsWindow.getNameText().setForeground(Color.RED);
            }else{
                this.game = 1;

            }


        }
        if(e.getSource() == loadGame){

            this.game = 2;
        }
        if(e.getSource() == gameRules){
            new GameRules();
        }
        if(e.getSource() == results){
            try {
                new ResultsWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public int getGame() {
        return game;
    }
    public OptionsWindow getOptionsWindow() {
        return optionsWindow;
    }

}
