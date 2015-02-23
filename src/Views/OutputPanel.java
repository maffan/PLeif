package Views;

import javax.swing.*;

import Models.Entity;
import Models.Player;

import java.awt.*;

public class OutputPanel extends JPanel {
    private JTextArea textArea;
    public OutputPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void setText(String text){
        textArea.setText(text);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    }
}