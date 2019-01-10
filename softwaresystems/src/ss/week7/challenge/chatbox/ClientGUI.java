package ss.week7.challenge.chatbox;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ss.week7.cmdchat.Client;

public class ClientGUI extends JFrame implements ActionListener, MessageUI {
	private JButton bConnect;
	private JTextField tfPort;
	private JTextField tfName;
	private JTextField tfHostname;
	private JTextField tfMymessage;
	private JScrollPane pane;

	private JTextArea taMessages;

	private String clientName;
	private int port;
	private InetAddress host;
	boolean t1 = false, t2 = false, t3 = false;
	ClientGUIimp client;

	/** Constructs a ServerGUI object. */
	public ClientGUI() {
		super("ClientGUI");

		buildGUI();
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}

			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/** Builds the GUI. */
	public void buildGUI() {
		setSize(600, 600);

		// Panel p1 - Listen

		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p11 = new JPanel(new GridLayout(2, 1));
		JPanel pp = new JPanel(new GridLayout(3, 3));
		JPanel pm = new JPanel(new GridLayout(2, 1));

		JLabel lbHostname = new JLabel("Hostname: ");
		tfHostname = new JTextField("", 12);
		tfHostname.addActionListener(this);

		JLabel lbPort = new JLabel("Port:");
		tfPort = new JTextField("", 5);
		tfPort.addActionListener(this);

		JLabel lbName = new JLabel("Name:");
		tfName = new JTextField("", 5);
		tfName.addActionListener(this);

		pp.add(lbHostname);
		pp.add(tfHostname);
		pp.add(lbPort);
		pp.add(tfPort);
		pp.add(lbName);
		pp.add(tfName);

		JLabel lbMymessage = new JLabel("My message: ");
		tfMymessage = new JTextField("", 50);
		tfMymessage.setEnabled(false);
		tfMymessage.addActionListener(this);
		pm.add(lbMymessage);
		pm.add(tfMymessage);

		bConnect = new JButton("Connect");
		bConnect.setEnabled(false);
		bConnect.addActionListener(this);

		p1.add(pp, BorderLayout.WEST);
		p1.add(bConnect, BorderLayout.EAST);
		p11.add(p1, BorderLayout.NORTH);
		p11.add(pm, BorderLayout.SOUTH);

		// Panel p2 - Messages

		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());

		JLabel lbMessages = new JLabel("Messages:");
		taMessages = new JTextArea("", 15, 50);
		taMessages.setEditable(false);
		pane = new JScrollPane(taMessages, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		p2.add(lbMessages);
		p2.add(pane, BorderLayout.SOUTH);
		

		Container cc = getContentPane();
		cc.setLayout(new FlowLayout());
		cc.add(p11);
		cc.add(p2);
	}

	/**
	 * listener for the "Start Listening" button
	 */
	public void actionPerformed(ActionEvent ev) {
		Object src = ev.getSource();

		if (src == bConnect) {
			try {
				findServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ((src == tfName)) {
			if (tfName.getText() != "") {
				clientName = tfName.getText();
				addMessage("Client name is: " + clientName);
				tfName.setEnabled(false);
				t1 = true;
				if (t1 && t2 && t3) {
					bConnect.setEnabled(true);

				}
			}
		}
		if ((src == tfPort)) {
			try {
				port = Integer.parseInt(tfPort.getText());
				t2 = true;
				tfPort.setEnabled(false);
				addMessage("Port number is is:" + tfPort.getText());
				if (t1 && t2 && t3) {
					bConnect.setEnabled(true);
				}
			} catch (NumberFormatException e) {
				addMessage("ERROR: not a valid portnumber!");
				return;
			}

		}

		if ((src == tfHostname)) {
			try {
				host = InetAddress.getByName(tfHostname.getText());
				t3 = true;
				tfHostname.setEnabled(false);
				addMessage("Host adress is:" + tfHostname.getText());
				if (t1 && t2 && t3) {
					bConnect.setEnabled(true);
				}
			} catch (UnknownHostException e) {
				addMessage("ERROR: no valid hostname!");
			}
		}

		if ((src == tfMymessage)) {
			client.sendMessage(tfMymessage.getText());
			tfMymessage.setText("");

		}

	}

	/**
	 * Construct a Server-object, which is waiting for clients. The port field and
	 * button should be disabled
	 * 
	 * @throws IOException
	 */
	private void findServer() throws IOException {
		try {
			client = new ClientGUIimp(clientName, host, port, this);
			client.sendMessage(clientName);
			client.start();
			tfMymessage.setEnabled(true);
			bConnect.setEnabled(false);
			addMessage("Connection Succesfull!");
		} catch (IOException e) {
			addMessage("ERROR: couldn't construct a client object!");
		}

	}

	/** add a message to the textarea */
	public void addMessage(String msg) {
		taMessages.append(msg + "\n");
	}

	/** Start a ServerGUI application */
	public static void main(String[] args) {
		new ClientGUI();
	}
}
