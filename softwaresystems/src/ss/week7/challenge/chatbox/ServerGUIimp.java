package ss.week7.challenge.chatbox;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Vector;

import ss.week7.cmdchat.ClientHandler;

/**
 * P2 prac wk5. <br>
 * Server. A Thread class that listens to a socket connection on a 
 * specified port. For every socket connection with a Client, a new 
 * ClientHandler thread is started. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class ServerGUIimp extends Thread {
    private int port;
    private MessageUI mui;
    private Collection<ClientHandlerGUI> threads;

    /** Constructs a new Server object */
    public ServerGUIimp(int portArg, MessageUI muiArg) {
      	this.port = portArg;
      	mui = muiArg;
      	this. threads = new Vector < ClientHandlerGUI >();
    }

    /**
     * Listens to a port of this Server if there are any Clients that 
     * would like to connect. For every new socket connection a new
     * ClientHandler thread is started that takes care of the further
     * communication with the Client.
     */
    public void run() {
    	ServerSocket servsock;
		try {
			servsock = new ServerSocket(port);
		 	int i = 0;
	    	while(true) {
	    		ClientHandlerGUI handler = new ClientHandlerGUI(this, servsock.accept());
	    		mui.addMessage(("Client("+ i++ +") has connected"));
	    		handler.announce();
	    		handler.start();
	    		addHandler(handler);
	    	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
    }

    /**
     * Sends a message using the collection of connected ClientHandlers
     * to all connected Clients.
     * @param msg message that is send
     */
    public void broadcast(String msg) {
    	mui.addMessage(msg);
    	for(ClientHandlerGUI s: threads) {
    		s.sendMessage(msg);
    		
    	}
    }

    /**
     * Add a ClientHandler to the collection of ClientHandlers.
     * @param handler ClientHandler that will be added
     */
    public void addHandler(ClientHandlerGUI handler) {
    	threads.add(handler);
    }

    /**
     * Remove a ClientHandler from the collection of ClientHanlders. 
     * @param handler ClientHandler that will be removed
     */
    public void removeHandler(ClientHandlerGUI handler) {
    	threads.remove(handler);
    }

}
