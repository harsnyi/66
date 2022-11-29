package ui.menu;

import logic.GameLogic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuBar extends JMenuBar implements ActionListener {

    JMenu files;
    JMenu edit;
    JMenuItem filesExit,results,rules;
    JMenuItem cut,copy,paste,selectAll;
    public MenuBar(){

        files = new JMenu("66");
        edit = new JMenu("Szerkesztés");


        filesExit = new JMenuItem("Kilépés");
        results = new JMenuItem("Eredmények");
        rules = new JMenuItem("Szabályok");

        filesExit.addActionListener(this);
        results.addActionListener(this);
        rules.addActionListener(this);

        cut=new JMenuItem("Kivágás");
        copy=new JMenuItem("Másolás");
        paste=new JMenuItem("Beillesztés");
        selectAll=new JMenuItem("Összes kiválasztása");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);


        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);
        files.add(results); files.add(rules);files.add(filesExit);

        this.add(files);
        this.add(edit);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == filesExit){
            System.exit(0);
        }
        if(e.getSource() == results){
            try {
                new ResultsWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(e.getSource() == rules){

                new GameRules();

        }

    }
}

