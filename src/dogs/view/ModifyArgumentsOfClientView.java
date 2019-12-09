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

import dogs.controller.IClientController;
import dogs.dto.ClientDTOWithId;

public class ModifyArgumentsOfClientView extends JDialog implements IView, ActionListener {
	
	private static final String VIEW_TITLE = "Confirmer et modifier ce client";
	private static final String BUTTON_ACTION = "ModifyDog";
	private static final int MAX_LENGTH = 40;
	private static final String NUMBER_TEXT = "Numero: ";
	private static final String LAST_NAME_TEXT = "Nom de famille: ";
	private static final String FIRST_NAME_TEXT = "Nom:";
	private JPanel inputPanel = new JPanel();
	private IClientController clientController;
	private IView showClientView;
	private int clientId;
	private JTextField firstName = new JTextField(MAX_LENGTH);
	private JTextField lastName = new JTextField(MAX_LENGTH);
	private JTextField number = new JTextField(MAX_LENGTH);

	public ModifyArgumentsOfClientView(IClientController clientController, IView showClientView, int clientId) {
		super();
		this.inputPanel.setLayout(new BorderLayout());
		this.clientController = clientController;
		this.showClientView = showClientView;
		this.clientId = clientId;
		this.setUpComponents();	}

	private void setUpComponents() {
		this.setUpFirstNamePanel();
		this.setUpLastNamePanel();
		this.setUpNumberPanel();
		this.add(inputPanel, BorderLayout.CENTER);
		this.setUpActionPanel();
		this.pack();
	}

	private void setUpActionPanel() {
		JPanel action = new JPanel();
		this.add(action, BorderLayout.SOUTH);
		addButton(action, VIEW_TITLE , BUTTON_ACTION);
	}

	private void addButton(JPanel panel, String message, String buttonAction) {
		JButton button = new JButton(message);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		panel.add(button);
	}

	private void setUpNumberPanel() {
		JPanel numberPanel = new JPanel();
		this.inputPanel.add(numberPanel, BorderLayout.SOUTH);
		
		addNumberText(numberPanel);
		addTextLabel(numberPanel, number);
	}

	private void addNumberText(JPanel text) {
		JLabel label = new JLabel(NUMBER_TEXT , SwingConstants.CENTER);
		text.add(label, BorderLayout.WEST);
	}

	private void setUpLastNamePanel() {
		JPanel lastNamePanel = new JPanel();
		this.inputPanel.add(lastNamePanel, BorderLayout.CENTER);
		
		addLastNameText(lastNamePanel);
		addTextLabel(lastNamePanel, lastName);
	}

	private void addTextLabel(JPanel textPanel, JTextField text) {
		textPanel.add(text, BorderLayout.CENTER);
	}

	private void addLastNameText(JPanel text) {
		JLabel label = new JLabel(LAST_NAME_TEXT , SwingConstants.CENTER);
		text.add(label, BorderLayout.WEST);
	}

	private void setUpFirstNamePanel() {
		JPanel firstNamePanel = new JPanel();
		this.inputPanel.add(firstNamePanel, BorderLayout.NORTH);
		
		addFirstNameText(firstNamePanel);
		addTextLabel(firstNamePanel, firstName);
	}

	private void addFirstNameText(JPanel text) {
		JLabel label = new JLabel(FIRST_NAME_TEXT , SwingConstants.CENTER);
		text.add(label, BorderLayout.WEST);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.insertClient();
			this.clientController.showConfirmationAsked();
			dispose();
		}
	}

	private void insertClient() {
		ClientDTOWithId dto = new ClientDTOWithId(this.firstName.getText(), this.lastName.getText(), this.number.getText(), clientId);
		this.clientController.modifyClient(showClientView, dto);
	}

}
