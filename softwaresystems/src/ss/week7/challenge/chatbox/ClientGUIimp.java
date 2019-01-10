package ss.week7.challenge.chatbox;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * P2 prac wk4. <br>
 * Client. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class ClientGUIimp extends Thread {

	private String clientName;
	private MessageUI mui;
	private Socket sock;
	private BufferedReader in;
	private BufferedWriter out;

	/**
	 * Constructs a Client-object and tries to make a socket connection
	 */
	public ClientGUIimp(String name, InetAddress host, int port, MessageUI muiArg)
			throws IOException {
		clientName = name;
		sock = new Socket(host, port);
		mui = muiArg;
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
	}

	/**
	 * Reads the messages in the socket connection. 
	 * Each message will be forwarded to the MessageUI
	 */
	public void run() {
		String line = null;
		try {
			while ((line = in.readLine()) != null) {
					mui.addMessage(line);
				}
			shutdown();
		} catch (IOException e) {
			shutdown();
		}
	}

	/** send a message to a ClientHandler. */
	public void sendMessage(String msg) {
		try {
			out.write(msg);
			out.newLine();
			out.flush();
		} catch (IOException e) {
			shutdown();
		}
	}

	/** close the socket connection. */
	public void shutdown() {
		mui.addMessage("Closing socket connection...");
		try {
			sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

	/** returns the client name */
	public String getClientName() {
		return clientName;
	}

}