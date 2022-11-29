package ui.game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.Serializable;

public class MidPanel extends JPanel implements Serializable {


    private final JButton twentyOrForty;
    private final JLabel adu;
    private final JButton actionButton;

    private final JLabel points;
    private final JButton aduAlsoSwitch;
    private final JLabel playCard1;
    private final JLabel playCard2;
    MidPanel(){

        this.setBounds(0, 300, 1000, 300);

        this.setBackground(Color.white);

        this.setLayout(new GridLayout(1, 2, 0, 0));
        Border border = BorderFactory.createLineBorder(Color.ORANGE, 1);

        playCard1 = new JLabel("",SwingConstants.CENTER);
        playCard1.setBorder(border);


        playCard2 = new JLabel("",SwingConstants.CENTER);
        playCard2.setBorder(border);

        JPanel playGroundLeft = new JPanel(new GridLayout(1, 2, 0, 0));
        playGroundLeft.setBackground(Color.white);
        JPanel playGroundRight = new JPanel(new GridLayout(2, 2, 0, 0));
        playGroundRight.setBackground(Color.white);
        playGroundRight.setBorder(border);

        this.add(playGroundLeft);
        this.add(playGroundRight);

        playGroundLeft.add(playCard1);
        playGroundLeft.add(playCard2);

        JPanel aduHolder = new JPanel(new GridLayout(1, 2, 0, 0));
        aduHolder.setBackground(Color.white);

        JLabel aduText = new JLabel("Adu: ");
        aduText.setHorizontalAlignment(SwingConstants.CENTER);
        aduText.setFont(new Font("MV Boli", Font.BOLD, 20));
        aduText.setBackground(Color.white);

        twentyOrForty = new JButton("20,40");
        twentyOrForty.setFont(new Font("MV Boli", Font.BOLD, 20));
        twentyOrForty.setBackground(Color.white);
        twentyOrForty.setBorder(border);

        adu = new JLabel();

        actionButton = new JButton("Kilepes");
        actionButton.setFont(new Font("MV Boli", Font.BOLD, 20));
        actionButton.setBackground(Color.white);
        actionButton.setBorder(border);


        points = new JLabel("0 Pont");
        points.setHorizontalAlignment(SwingConstants.CENTER);
        points.setFont(new Font("MV Boli", Font.BOLD, 20));
        points.setBackground(Color.white);

        JPanel pointsCardChange = new JPanel(new GridLayout(1, 2, 0, 0));
        pointsCardChange.setBackground(Color.white);

        aduAlsoSwitch = new JButton("Csere");
        aduAlsoSwitch.setFont(new Font("MV Boli", Font.BOLD, 20));
        aduAlsoSwitch.setBackground(Color.white);
        aduAlsoSwitch.setBorder(border);


        aduHolder.add(aduText);
        aduHolder.add(adu);

        playGroundRight.add(twentyOrForty);
        playGroundRight.add(aduHolder);
        playGroundRight.add(pointsCardChange);
        playGroundRight.add(actionButton);

        pointsCardChange.add(aduAlsoSwitch);
        pointsCardChange.add(points);

    }

    public JButton getTwentyOrForty() {
        return twentyOrForty;
    }
    public JLabel getAdu() {
        return adu;
    }
    private void setCard(String cardName,int width,int height,JLabel holder){


        String separator = System.getProperty("file.separator");
        ImageIcon imgThisImg = new ImageIcon("Snapszer"+separator+"cardpictures"+separator+cardName+".jpg");
        Image image = imgThisImg.getImage();
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        imgThisImg = new ImageIcon(newimg);
        holder.setIcon(imgThisImg);
    }

    public void setAdu(String cardName) {
        this.setCard(cardName,80,120,adu);
    }
    public JButton getActionButton() {
        return actionButton;
    }
    public JLabel getPoints() {
        return points;
    }
    public JButton getAduAlsoSwitch() {
        return aduAlsoSwitch;
    }
    public JLabel getPlayCard1() {
        return playCard1;
    }
    public JLabel getPlayCard2() {
        return playCard2;
    }
    public void setPlayCard2(String cardName) {
        this.setCard(cardName,160,200,playCard2);
    }
}
