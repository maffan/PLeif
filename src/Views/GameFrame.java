package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JFrame {
    public static final String TITLE = "Leif: Epic Adventures";
    private BoardPanel boardPanel;
    private static InfoPanel infoPanel;
    private static StatusPanel statusPanel;

    public GameFrame(){
        super(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        makePanels();
        makeMenu();
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowActivated(WindowEvent e) {
            	boardPanel.requestFocus();
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void makeMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem quitItem = new JMenuItem("Quit");
        //quitItem.addActionListener(e -> {System.exit(0);}); // Gave me an error, just want to run and test the damn thing! MJ
        quitItem.setMnemonic(KeyEvent.VK_Q);
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        fileMenu.add(quitItem);
        setJMenuBar(menuBar);
    }

    private void makePanels() {
        boardPanel = new BoardPanel();
        infoPanel = new InfoPanel();
        statusPanel = new StatusPanel();
        add(boardPanel,BorderLayout.CENTER);
        add(infoPanel,BorderLayout.EAST);
        add(statusPanel, BorderLayout.SOUTH);
    }
    
    public static void infoPanelUpdate() // Moved these methods somewhere else.. ? MJ
    {
    	 infoPanel.revalidate();
    	 infoPanel.repaint();
    }
    
    public static void statusPanelUpdate()
    {
    	statusPanel.revalidate();
    	statusPanel.repaint();
    }
}