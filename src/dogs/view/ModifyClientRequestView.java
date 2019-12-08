package dogs.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dogs.controller.ClientController;

public class ModifyClientRequestView extends JDialog implements IView, ActionListener {
	
	private static final String BUTTON_TITLE = "Modifier le client";
	private static final String BUTTON_ACTION = "Modify";
	private static final int MAX_LENGTH = 4;
	private static final String MESSAGE = "Entrez le ID du client à modifier: ";;
	private ClientController clientController;
	private ShowClientView showClientView;
	private JTextField clientIdField = new JTextField(MAX_LENGTH);

	public ModifyClientRequestView(ClientController clientController, ShowClientView showClientView) {
		super();
		this.clientController = clientController;
		this.showClientView = showClientView;
		this.setUpComponents();
		this.pack();	}

	private void setUpComponents() {
		this.setUpClientIdDPanel();
		this.setUpActionPanel();
	}

	private void setUpActionPanel() {
		JPanel action = new JPanel();
		this.add(action, BorderLayout.EAST);
		addButton(action, BUTTON_TITLE , BUTTON_ACTION);
	}

	private void addButton(JPanel action, String buttonTitle, String buttonAction) {
		JButton button = new JButton(buttonTitle);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		action.add(button);
	}

	private void setUpClientIdDPanel() {
		JPanel clientdPanel = new JPanel();
		this.add(clientdPanel, BorderLayout.CENTER);
		
		addClientIdText(clientdPanel);
		addTextLabel(clientdPanel, clientIdField );
	}

	private void addTextLabel(JPanel clientdPanel, JTextField clientId) {
		clientdPanel.add(clientId, BorderLayout.CENTER);
	}

	private void addClientIdText(JPanel clientdPanel) {
		JLabel label = new JLabel(MESSAGE , SwingConstants.CENTER);
		clientdPanel.add(label, BorderLayout.WEST);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.modifyClientConfirmation();
			dispose();
		}
	}

	private void modifyClientConfirmation() {
		this.clientController.showModifyElementsOfClient(this.showClientView, Integer.parseInt(clientIdField.getText()));
	}
}
