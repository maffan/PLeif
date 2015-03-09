package Chat;

import java.net.*;
import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * "Frontside" of the chat, sets up the window and connection and parses user input
 * @see Reciever
 */
public class Chat extends JFrame implements ActionListener{
	String name;
	InetAddress iadr;
	int port;
	MulticastSocket so;
	JTextArea txt		= new JTextArea();
	JScrollPane sp		= new JScrollPane(txt);
	JTextField input	= new JTextField();
	JButton exit		= new JButton("Disconnect");
	
	/**
	 * sets variables to default values
	 * @see #initiateChat(String)
	 * @throws IOException If something goes wrong with the connection
	 */
	public Chat() throws IOException {
		name = "Anonymous";
		iadr = InetAddress.getByName("234.235.236.237");
		port = 9999;
		
		initiateChat(name);
	}
	
	/**
	 * sets variables to arguments
	 * @param name The name to be displayed
	 * @param gAdr The IP-address which to connect to 
	 * @param portNr The Portnumber which to connect to
	 * @see #initiateChat(String)
	 * @throws IOException If something goes wrong with the connection
	 */
	public Chat(String name, String gAdr, int portNr) throws IOException {
		
		this.name = name;
		iadr = InetAddress.getByName(gAdr);
		port = portNr;
		
		initiateChat(name);
	}

	/**
	 * Connects to the chat and creates the chat ui
	 * @param name The name to be displayed
	 * @throws IOException If something goes wrong with the connection
	 */
	private void initiateChat(String name) throws IOException {
		so = new MulticastSocket(port);
		so.joinGroup(iadr);
		new Reciever(so, txt);
		sendMsg("CONNECTED");
		
		setTitle("Chat " + name);
		txt.setEditable(false);
		add(exit, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		add(input, BorderLayout.SOUTH);
		exit.addActionListener(this);
		input.addActionListener(this);
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	/**
	 * Converts a string to datagram and sends it to the chat
	 * @param s
	 */
	private void sendMsg(String s){
		byte[] data = (name + ": " + s).getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, iadr, port);
		try{so.send(packet);} catch (IOException ie) {}
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == input){
			sendMsg(input.getText());
			input.setText("");
		}
		else if(e.getSource() == exit) {
			sendMsg("DISCONNECTED");
			try{so.leaveGroup(iadr);} catch (IOException ie) {}
			so.close();
			dispose();
		}
	}
}
