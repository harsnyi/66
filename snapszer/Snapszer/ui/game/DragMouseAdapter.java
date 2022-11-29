package ui.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

class DragMouseAdapter extends MouseAdapter implements Serializable {

    private final GameWindow window;
    DragMouseAdapter(GameWindow window){
        this.window = window;
    }
    public void mouseReleased(MouseEvent e){
        JLabel c = (JLabel) e.getSource();
        Point p = e.getPoint();
        if(p.y < 0 && window.getMidPanel().getPlayCard1().getIcon() == null){
            if(c.getIcon() != null){
                window.getMidPanel().getPlayCard1().setIcon(c.getIcon());
                window.getMidPanel().getPlayCard1().setText("");

            }

        }

    }
}
