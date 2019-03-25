package org.client.entry.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ClientInterface extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final JTextArea Messages;
	private final JTextArea textPane;

	public ClientInterface() {
		this.getContentPane().setLayout(null);

		Messages = new JTextArea();
		Messages.setText("Welcome to chatRoom\r\n");
		Messages.setBounds(30, 11, 415, 201);
		Messages.setColumns(10);
		this.getContentPane().add(Messages);

		final JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(30, 290, 89, 23);
		final SendAction al = new SendAction(this);
		btnNewButton.addActionListener(al);

		textPane = new JTextArea();
		textPane.setBounds(30, 234, 415, 23);
		this.getContentPane().add(textPane);

		this.getContentPane().add(btnNewButton);

		final JButton serverButton = new JButton("Server");
		serverButton.setBounds(356, 268, 89, 23);
		this.getContentPane().add(serverButton);
		serverButton.addActionListener(new ServerAction(this, al));

		final JButton clientButton = new JButton("Client");
		clientButton.setBounds(356, 302, 89, 23);
		this.getContentPane().add(clientButton);
		clientButton.addActionListener(new ClientAction(al, this));

		this.setResizable(false);
		this.setVisible(true);

	}

	public JTextArea getMessages() {
		return Messages;
	}

	public JTextArea getTextPane() {
		return textPane;
	}

}
