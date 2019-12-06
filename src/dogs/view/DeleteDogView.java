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

import dogs.controller.DogController;

public class DeleteDogView extends JDialog implements IView, ActionListener {

	private static final int MAX_LENGTH = 4;
	private static final String FIRST_NAME_TEXT = "Entrez le ID du chien à supprimer: ";
	private static final String BUTTON_TITLE = "Supprimer le chien";
	private static final String BUTTON_ACTION = "DeleteDog";
	private DogController dogController;
	private JTextField dogIdField = new JTextField(MAX_LENGTH);
	private ShowDogView showDogView;

	public DeleteDogView(DogController dogController, ShowDogView showDogView) {
		super();
		this.dogController = dogController;
		this.showDogView = showDogView;
		this.setUpComponents();
		this.pack();
	}

	private void setUpComponents() {
		this.setUpIdDogPanel();
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

	private void setUpIdDogPanel() {
		JPanel dogIdPanel = new JPanel();
		this.add(dogIdPanel, BorderLayout.CENTER);
		
		addDogIdText(dogIdPanel);
		addTextLabel(dogIdPanel, dogIdField);
	}

	private void addTextLabel(JPanel dogIdPanel, JTextField dogId) {
		dogIdPanel.add(dogId, BorderLayout.CENTER);
	}

	private void addDogIdText(JPanel firstNamePanel) {
		JLabel label = new JLabel(FIRST_NAME_TEXT , SwingConstants.CENTER);
		firstNamePanel.add(label, BorderLayout.WEST);
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.deleteDogConfirmation();
			dispose();
		}
	}

	private void deleteDogConfirmation() {
		this.dogController.showDeleteDogConfirmation(this.dogIdField.getText(), this.showDogView);	
	}
}
