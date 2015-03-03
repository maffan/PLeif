package Views;

import javax.swing.*;

import java.awt.*;

public class OutputPanel extends JPanel {
    private JTextArea textArea;
    private int rows;
    public OutputPanel(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rows = 0;
    }

    public void setText(String text){
        textArea.setText(text);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    }

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