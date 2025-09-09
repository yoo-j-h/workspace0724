package com.kh.thread.chat;

import java.io.IOException;
import java.net.Socket;

public class TCPClient {
	public static void min(String args) {
		String serverIP = "192.168.10.31";
		int port = 3000;
		
		Socket socket;
		try {
			socket = new Socket(serverIP, port);
			if(socket != null) {
				ClientReceive cr = new ClientReceive(socket);
				cr.start();
				
				ClientSend cs = new ClientSend(socket);
				cs.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			

	}
}
