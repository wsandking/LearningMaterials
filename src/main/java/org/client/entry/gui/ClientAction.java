package org.client.entry.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientAction implements ActionListener {

	private final SendAction sendAction;
	private final ClientInterface ci;

	public ClientAction(final SendAction sendAction, final ClientInterface ci) {
		this.ci = ci;
		this.sendAction = sendAction;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			final Socket cs = new Socket("127.0.0.1", 9999);
			sendAction.setSocket(cs);
			sendAction.establishConnection();
			final BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
			new Thread(new ListenerThread(in, ci)).start();
			System.err.println("Connection established.");
		} catch (final UnknownHostException e1) {
			e1.printStackTrace();
		} catch (final IOException e1) {
			e1.printStackTrace();
		}

	}

}
