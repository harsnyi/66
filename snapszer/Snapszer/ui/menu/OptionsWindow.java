package ui.menu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class OptionsWindow extends JPanel implements ChangeListener {

    JPanel panel;
    JLabel label;
    public JTextField name;
    JSlider slider;
    JPanel field;
    JPanel outerPanel;
    JPanel layout;
    JLabel nameText;
    JComboBox<String> cards;
    String[] cardVariations;
    OptionsWindow(){


        outerPanel = new JPanel(new BorderLayout());
        layout = new JPanel();

        field = new JPanel();
        field.setLayout(new FlowLayout());

        nameText = new JLabel("Név:");
        name = new JTextField();

        name.setPreferredSize(new Dimension(160,40));
        panel = new JPanel(new GridLayout(4, 1, 10, 20));
        label = new JLabel("",SwingConstants.CENTER);

        slider = new JSlider(1,3,1);
        slider.setSize(new Dimension(100,20));
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        Font font = new Font("Serif", Font.BOLD, 18);
        slider.setFont(font);
        slider.setOrientation(SwingConstants.HORIZONTAL);
        slider.addChangeListener(this);

        label.setText("Az ellenfél erőssége: "+slider.getValue());
        label.setFont(new Font("Serif", Font.BOLD, 18));

        cardVariations = new String[]{"Kilencesek nélkül","Kilencesekkel"};
        cards = new JComboBox<>(cardVariations);


        field.add(nameText);
        field.add(name);


        panel.add(cards);
        panel.add(field);
        panel.add(slider);
        panel.add(label);


        layout.add(panel);
        outerPanel.add(layout);
        this.add(outerPanel);

    }

    public void stateChanged(ChangeEvent e){
        label.setText("Az ellenfél erőssége: "+slider.getValue());
    }
    public JSlider getSlider() {
        return slider;
    }
    public JLabel getNameText() {
        return nameText;
    }
    public JComboBox<String> getCards() {
        return cards;
    }

}