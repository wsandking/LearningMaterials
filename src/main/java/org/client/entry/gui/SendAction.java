package org.client.entry.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SendAction implements ActionListener {
	private final ClientInterface ci;
	private Socket socket;
	private OutputStream oos;

	public SendAction(final ClientInterface ci) {
		this.ci = ci;
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		final String text = ci.getTextPane().getText();
		System.err.println("Sending message: " + text);
		try {
			System.err.println("oos status : " + oos);
			oos.write(text.getBytes());
			oos.write('\n');
			System.err.println("Write finished.");
			ci.getTextPane().setText("");
		} catch (final IOException e1) {
			e1.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(final Socket socket) {
		this.socket = socket;
	}

	public void establishConnection() {
		try {
			oos = socket.getOutputStream();
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
