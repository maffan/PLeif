package Chat;

import java.net.*;
import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Chat extends JFrame implements ActionListener{
	String name;
	InetAddress iadr;
	int port;
	MulticastSocket so;
	JTextArea txt		= new JTextArea();
	JScrollPane sp		= new JScrollPane(txt);
	JTextField input	= new JTextField();
	JButton exit		= new JButton("Disconnect");
	
	public Chat() throws IOException {
		name = "Anonymous";
		iadr = InetAddress.getByName("234.235.236.237");
		port = 9999;
		
		initiateChat(name);
	}
	
	public Chat(String name, String gAdr, int portNr) throws IOException {
		
		this.name = name;
		iadr = InetAddress.getByName(gAdr);
		port = portNr;
		
		initiateChat(name);
	}

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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void sendMsg(String s){
		byte[] data = (name + ": " + s).getBytes();
		DatagramPacket packet = new DatagramPacket(data, data.length, iadr, port);
		try{so.send(packet);} catch (IOException ie) {}
	}
	
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
			//System.exit(0);
		}
	}
}
