package Chat;

import java.net.*;
import java.io.*;
import javax.swing.*;
import java.util.Date;

/**
 * "Backside" of the chat, receives messages and displays them in chat
 * @see Chat
 */
public class Reciever implements Runnable {
	Thread activity = new Thread(this);
	MulticastSocket so;
	JTextArea txt;
	
	Reciever(MulticastSocket sock, JTextArea txtAr) {
		so = sock;
		txt = txtAr;
		activity.start();
	}
	
	public void run(){
		byte[] data = new byte[1024];
		while(true)
			try{
				DatagramPacket packet = new DatagramPacket(data, data.length);
				so.receive(packet);
				Date date = new Date();
				String msg = new String(data, 0, packet.getLength());
				txt.append(date.toString() + "| " + msg + "\n");
			}
			catch (IOException e) {break;};
	}
}
