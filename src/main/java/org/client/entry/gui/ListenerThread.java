package org.client.entry.gui;

import java.io.BufferedReader;
import java.io.IOException;

public class ListenerThread implements Runnable {
	private final ClientInterface ci;
	private final BufferedReader br;

	public ListenerThread(final BufferedReader br, final ClientInterface ci) {
		this.br = br;
		this.ci = ci;
	}

	@Override
	public void run() {
		String inputLine = null;
		try {
			while (!(inputLine = br.readLine()).equals("bye")) {
				System.err.println("Rreceived : " + inputLine);
				this.ci.getMessages().append("Someone said: " + inputLine + "\n");
			}
		} catch (final IOException e1) {
			e1.printStackTrace();
		}

	}

}
