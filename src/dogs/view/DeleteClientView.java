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

public class DeleteClientView extends JDialog implements IView, ActionListener {
	
	private static final int MAX_LENGTH = 4;
	private static final String BUTTON_TITLE = "Suprimer le client";
	private static final String BUTTON_ACTION = "DeleteClient";
	private static final String MESSAGE = "Entrez le ID du client";
	private JTextField clientIdField = new JTextField(MAX_LENGTH);
	private ClientController clientController;
	private ShowClientView showClientView;

	public DeleteClientView(ClientController clientController, ShowClientView showClientView) {
		super();
		this.clientController = clientController;
		this.showClientView = showClientView;
		this.setUpComponents();
		this.pack();
		} 

	private void setUpComponents() {
		this.setUpIdClientPanel();
		this.setUpActionPanel();
	}

	private void setUpActionPanel() {
		JPanel action = new JPanel();
		this.add(action, BorderLayout.EAST);
		addButton(action, BUTTON_TITLE , BUTTON_ACTION);
	}

	private void setUpIdClientPanel() {
		JPanel clientIdPanel = new JPanel();
		this.add(clientIdPanel, BorderLayout.CENTER);
		
		addClientIdText(clientIdPanel);
		addTextLabel(clientIdPanel, clientIdField);
	}

	private void addTextLabel(JPanel clientIdPanel, JTextField clientIdField) {
		clientIdPanel.add(clientIdField, BorderLayout.CENTER);
	}

	private void addClientIdText(JPanel clientIdPanel) {
		JLabel label = new JLabel(MESSAGE , SwingConstants.CENTER);
		clientIdPanel.add(label, BorderLayout.WEST);
	}

	private void addButton(JPanel action, String buttonTitle, String buttonAction) {
		JButton button = new JButton(buttonTitle);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		action.add(button);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.DeleteClientConfirmationView();
			dispose();
		}
	}

	private void DeleteClientConfirmationView() {
		this.clientController.showDeleteDogConfirmation(this.clientIdField.getText(), this.showClientView);
	}

}
