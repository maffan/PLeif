package Views;

import javax.swing.*;

import java.awt.*;

/**
 * @author Grupp3
 * @version 2015-03-09
 */
public class OutputPanel extends JPanel {
    private JTextArea textArea;
    private int rows;
    /**
     * Initiates outputpanel
     */
    public OutputPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rows = 0;
    }

    /**
     * Removes old text and prints new text
     * @param text new text 
     */
    public void setText(String text){
        textArea.setText(text);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    }

    /**
     * Adds another line to outputfield
     * @param text to add
     */
    public void addLine(String text) {
        if(textArea.getText().equals("")){
            setText(text);
            return;
        }
        if(rows < 2) {
            textArea.append("\n" + text);
            rows++;
        }
        else{
            setText(text);
            rows = 0;
        }
    }
}