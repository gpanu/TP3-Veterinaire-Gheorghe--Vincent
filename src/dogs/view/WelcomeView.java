package dogs.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.IWelcomeController;
import util.image.ImageUtil;

public class WelcomeView extends JFrame implements IView, ActionListener{   // Configurer Eclipse pour ignorer les avertissements sur serial Id
	
	private static final String VIEW_TITLE = "Nos amis les chiens";
	private static final String WELCOME_MESSAGE = "Bienvenue !";
	private static final String WELCOME_PICTURE = "../resource/dog.jpg";
	private static final Dimension DEFAULT_SIZE = new Dimension(475, 530);
	private static final String BUTTON_ADD_ACTION = "AddDog";
	private static final String ADD_CLIENT_TITLE = "Add client";
	private static final String BUTTON_ADD_CLIENT = "AddClient";
	private String SHOW_TITLE = "Show dog list";
	private String BUTTON_SHOW_ACTION = "SHOW_DOGS";
	
	private IWelcomeController controller;		// Pas encore utilisé dans cette version...
	
	
	public WelcomeView(IWelcomeController controller) {
		super(VIEW_TITLE);
		
		this.controller = controller;
		
		this.initialize();
		this.setUpComponents();
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void initialize() {
		// setSize(): uniquement car JFrame avec une image - Ne pas utiliser avec les gestionnaires de mise en forme-Utiliser la méthode pack() à la place
		this.setSize(DEFAULT_SIZE);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// par défaut: HIDE_ON_CLOSE
	}
	
	private void setUpComponents() {
		//this.setLayout(new BorderLayout());  					// Inutile car par défaut...
		this.setUpWelcomePanel();
		this.setUpActionPanel();
	}

	private void setUpWelcomePanel() {
		JPanel welcomePanel = new JPanel();
		this.add(welcomePanel, BorderLayout.CENTER);  // CENTER -> par défaut

		welcomePanel.setLayout(new BorderLayout());   // Strategy pattern: le gestionnaire de mise en forme		
		addWelcomePicture(welcomePanel);		
		addWelcomeMessage(welcomePanel);		
	}

	private void addWelcomeMessage(JPanel welcomePanel) {
		JLabel welcomeMessage = new JLabel(WELCOME_MESSAGE, SwingConstants.CENTER);
		welcomePanel.add(welcomeMessage, BorderLayout.NORTH);
	}

	private void addWelcomePicture(JPanel welcomePanel) {
		ImageIcon image = ImageUtil.getImageIcon(this, WELCOME_PICTURE);
		JLabel welcomePicture = new JLabel(image);		
		welcomePanel.add(welcomePicture, BorderLayout.CENTER);   // CENTER -> par défaut
	}

	private void setUpActionPanel() {
		JPanel action = new JPanel();
		this.add(action, BorderLayout.SOUTH);
		addButton(action, VIEW_TITLE, BUTTON_ADD_ACTION);
		addButton(action, SHOW_TITLE, BUTTON_SHOW_ACTION);
		addButton(action, ADD_CLIENT_TITLE, BUTTON_ADD_CLIENT);
	}
	
	private void addButton(JPanel panel, String message, String buttonAction) {
		JButton button = new JButton(message);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		panel.add(button);
		
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ADD_ACTION)) {
			this.actionAndDogAsked();
		}
		if(act.getActionCommand().equals(BUTTON_SHOW_ACTION)) {
			this.showDogsAsked();
		}
		if(act.getActionCommand().equals(BUTTON_ADD_CLIENT)) {
			this.addClientAsked();
		}
		
	}

	private void addClientAsked() {
		this.controller.wantToCreateClient();
	}

	private void showDogsAsked() {
		this.controller.wantShowDogs();
		
	}

	private void actionAndDogAsked() {
		this.controller.wantCreateDog();
	}
	
}
