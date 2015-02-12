package Views;

import javax.swing.*;

import Models.Entity;
import Models.Player;

import java.awt.*;

public class OutputPanel extends JPanel {
    public OutputPanel(){
        add(new JLabel("Output"));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);	

    	g.drawString("I can write stuff here!", 20, 40);
    }
}