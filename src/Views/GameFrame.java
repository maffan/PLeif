package Views;

import Controllers.InputController;
import Utils.BoardPanelProvider;
import Utils.FilesRW;
import Utils.GamePaths;
import Utils.Help;
import Audio.*;

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
    
    public static void main(String[] args) {
        new GameFrame();
    }

    public GameFrame(){
        super(TITLE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));
        makePanels();
        makeMenu();
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowActivated(WindowEvent e) {
            	statusPanel.getInputPanel().getTextField().requestFocus();
            }
        });
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        FilesRW.saveTo(BoardPanel.world, GamePaths.StartState);
        
        //Reset audio and start bgmusic
        VolumeControl.changeVolume(0.8f);
        SoundPlayer.playBg();
        
    }

    private void makeMenu() {
        JMenuBar menuBar = new JMenuBar();
        
        //FileMenu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        JMenuItem newItem = new JMenuItem("New game");
        newItem.addActionListener(e -> {boardPanel.reset();});
        newItem.setMnemonic(KeyEvent.VK_N);
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        fileMenu.add(newItem);
        
        
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> {boardPanel.save();});
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        fileMenu.add(saveItem);
        
        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.addActionListener(e -> {boardPanel.load();});
        loadItem.setMnemonic(KeyEvent.VK_O);
        loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        fileMenu.add(loadItem);
        
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e -> {System.exit(0);});
        quitItem.setMnemonic(KeyEvent.VK_Q);
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        fileMenu.add(quitItem);
        
        //MusicMenu
        JMenu musicMenu = new JMenu("Music");
        menuBar.add(musicMenu);
        
        JMenuItem startMusic = new JMenuItem("Start Music");
        startMusic.addActionListener(e -> {SoundPlayer.playBg();});
        musicMenu.add(startMusic);
                
        JMenuItem stopMusic = new JMenuItem("Stop Music");        
        stopMusic.addActionListener(e -> {SoundPlayer.stopMusic();});        
        musicMenu.add(stopMusic);
        
        JMenuItem volume = new JMenuItem("Volume");
        volume.addActionListener(e -> { 
        	VolumeControl.changeVolume(
        			Float.parseFloat(
        			JOptionPane.showInputDialog(
        					this,
        					"Current Volume: " +String.valueOf(VolumeControl.getVolume()) +"\n"
        					+"Enter a value between 0 to 1 (i.e 0.34)",        					
        					"Enter Value"
        					)
        				)
        			); 
        });
        volume.setMnemonic(KeyEvent.VK_V);
        volume.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.ALT_MASK));
        musicMenu.add(volume);
        
        //HelpMenu
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);
        
        JMenuItem helpItem = new JMenuItem("Help");
        helpItem.addActionListener(e -> {Help.help();});
        helpMenu.add(helpItem);
        
        setJMenuBar(menuBar);
    }

    private void makePanels() {
        infoPanel = new InfoPanel();
        boardPanel = new BoardPanel();
        BoardPanelProvider.setBoardPanel(boardPanel);
        statusPanel = new StatusPanel();
        statusPanel.addInputListener(new InputController(statusPanel,boardPanel));
        add(boardPanel, BorderLayout.CENTER);
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