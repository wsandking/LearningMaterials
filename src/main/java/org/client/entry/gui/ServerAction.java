package org.client.entry.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerAction implements ActionListener {

	private final ClientInterface ci;
	private final SendAction al;

	public ServerAction(final ClientInterface ci, final SendAction al) {
		this.ci = ci;
		this.al = al;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		ServerSocket serverSocket;
		try {
			System.err.println("Server starting...");
			serverSocket = new ServerSocket(9999);
			final Socket clientSocket = serverSocket.accept();

			System.err.println("Connection established...");

			final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			al.setSocket(clientSocket);
			al.establishConnection();
			new Thread(new ListenerThread(in, ci)).start();
			System.err.println("Server finished initialization.");

		} catch (final IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
