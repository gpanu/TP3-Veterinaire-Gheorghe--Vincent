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
import dogs.dto.ClientDTO;

public class AddClientView extends JDialog implements IView, ActionListener {

	private static final int MAX_LENGTH = 40;
	private static final String FIRST_NAME_TEXT = "Prenom:";
	private static final String LAST_NAME_TEXT = "Nom:";
	private static final String BUTTON_TITLE = "Ajouter ce client";
	private static final String BUTTON_ACTION = "AddClient";
	private static final String NUMBER_TEXT = "Numero de telephone:";
	private IClientController clientController;
	private JTextField firstName = new JTextField(MAX_LENGTH);
	private JTextField lastName = new JTextField(MAX_LENGTH);
	private JTextField number = new JTextField(MAX_LENGTH);
	private JPanel inputPanel = new JPanel();

	public AddClientView(IClientController clientController) {
		super();
		this.clientController = clientController;
		this.inputPanel.setLayout(new BorderLayout());
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.add(inputPanel, BorderLayout.CENTER);
		this.setUpFirstNamePanel();
		this.setUpLastNamePanel();
		this.setUpNumberPanel();
		this.setUpActionPanel();
		this.pack();
	}

	private void setUpFirstNamePanel() {
		JPanel firstNamePanel = new JPanel();
		this.inputPanel.add(firstNamePanel, BorderLayout.NORTH);
		
		addFistNameText(firstNamePanel);
		addTextLabel(firstNamePanel, firstName);	
	}
	
	private void setUpLastNamePanel() {
		JPanel lastNamePanel = new JPanel();
		this.inputPanel.add(lastNamePanel, BorderLayout.CENTER);
		
		addLastNameText(lastNamePanel);
		addTextLabel(lastNamePanel, lastName);
	}

	private void setUpNumberPanel() {
		JPanel numberPanel = new JPanel();
		this.inputPanel.add(numberPanel, BorderLayout.SOUTH);
		
		addNumberText(numberPanel);
		addTextLabel(numberPanel, number);
	}
	
	private void addFistNameText(JPanel firstNamePanel) {
		JLabel label = new JLabel(FIRST_NAME_TEXT , SwingConstants.CENTER);
		firstNamePanel.add(label, BorderLayout.WEST);
		
	}
	
	private void addLastNameText(JPanel lastNamePanel) {
		JLabel label = new JLabel(LAST_NAME_TEXT , SwingConstants.CENTER);
		lastNamePanel.add(label, BorderLayout.WEST);
	}

	private void addNumberText(JPanel numberPanel) {
		JLabel label = new JLabel(NUMBER_TEXT , SwingConstants.CENTER);
		numberPanel.add(label, BorderLayout.WEST);
	}

	private void addTextLabel(JPanel textPanel, JTextField text) {
		textPanel.add(text, BorderLayout.CENTER);
	}
	
	private void setUpActionPanel() {
		JPanel action = new JPanel();
		this.add(action, BorderLayout.SOUTH);
		addButton(action, BUTTON_TITLE , BUTTON_ACTION);
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
			this.insertClient();
			this.clientController.showAddConfirmation();
			dispose();
		}
	}

	private void insertClient() {
		ClientDTO dto = new ClientDTO(this.firstName.getText(), this.lastName.getText(), this.number.getText());
		this.clientController.addClientToRepository(dto);
	}

}
