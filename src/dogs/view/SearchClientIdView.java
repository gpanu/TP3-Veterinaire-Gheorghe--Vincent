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

public class SearchClientIdView extends JDialog implements IView, ActionListener {
	
	private static final String BUTTON_ID_TITLE = "Rechercher par ID";
	private static final String BUTTON_ACTION = "Search";
	private static final int MAX_LENGHT = 4;
	private static final String ACTION_TO_DO_TEXT_ID = "Entrez le ID du client à afficher";
	private ClientController clientController;
	private ShowClientView showClientView;
	private JTextField clientIdField = new JTextField(MAX_LENGHT);

	public SearchClientIdView(ClientController clientController, ShowClientView showClientView) {
		super();
		this.clientController = clientController;
		this.showClientView = showClientView;
		this.setUpComponents();
		this.pack();
	}

	private void setUpComponents() {
		this.setUpSearchClientPanel();
		this.setUpActionPanel();
	}

	private void setUpActionPanel() {
		JPanel action = new JPanel();
		this.add(action, BorderLayout.EAST);
		addButton(action, BUTTON_ID_TITLE , BUTTON_ACTION);
	}

	private void addButton(JPanel action, String buttonTitle, String buttonAction) {
		JButton button = new JButton(buttonTitle);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		action.add(button);
	}

	private void setUpSearchClientPanel() {
		JPanel clientSearchPanel = new JPanel();
		this.add(clientSearchPanel, BorderLayout.CENTER);
		
		addClientSearchText(clientSearchPanel);
		addTextLabel(clientSearchPanel, clientIdField);
	}

	private void addClientSearchText(JPanel clientSearchPanel) {
		JLabel label = new JLabel(ACTION_TO_DO_TEXT_ID , SwingConstants.CENTER);
		clientSearchPanel.add(label, BorderLayout.WEST);
	}

	private void addTextLabel(JPanel clientSearchPanel, JTextField clientIdField) {
		clientSearchPanel.add(clientIdField, BorderLayout.CENTER);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.searchClientConfirm();
			dispose();
		}
	}

	private void searchClientConfirm() {
		this.clientController.showSearchedIdClient(Integer.parseInt(clientIdField.getText()), showClientView);;
	}
}
