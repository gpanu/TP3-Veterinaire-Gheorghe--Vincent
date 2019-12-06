package dogs.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.DogController;

public class DeleteDogConfirmationView extends JDialog implements IView, ActionListener {

	private static final String NO_BUTTON_TITLE = "Non";
	private static final String EXIT_BUTTON_ACTION = "Exit";
	private static final String YES_BUTTON_TITLE = "Oui";
	private static final String CONFIRM_BUTTON_ACTION = "Confirm";
	private static String CONFIRMATION_MESSAGE = String.format("Etes vous sur de vouloir supprimer le chien avec le id - ");
	private DogController dogController;
	private String id;

	public DeleteDogConfirmationView(DogController dogController, String id) {
		super();
		this.id = id;
		this.dogController = dogController;
		this.setUpComponents();
		this.pack();
	}

	private void setUpComponents() {
		JLabel label = new JLabel(CONFIRMATION_MESSAGE , SwingConstants.CENTER);
		JLabel label1 = new JLabel(this.id, SwingConstants.RIGHT);
		this.add(label, BorderLayout.CENTER);
		this.add(label1, BorderLayout.EAST);
		setUpActionPanel();
	}
	
	private void setUpActionPanel() {
		JPanel action = new JPanel();
		this.add(action, BorderLayout.SOUTH);
		addButton(action, NO_BUTTON_TITLE, EXIT_BUTTON_ACTION);
		addButton(action, YES_BUTTON_TITLE, CONFIRM_BUTTON_ACTION);
	}
	
	private void addButton(JPanel panel, String message, String buttonAction) {
		JButton button = new JButton(message);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		panel.add(button);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(EXIT_BUTTON_ACTION)) {
			dispose();
		}
		if(act.getActionCommand().equals(CONFIRM_BUTTON_ACTION)) {
			this.deleteDog();
			dispose();
			this.dogController.goToShow();
		}
	}

	private void deleteDog() {
		this.dogController.deleteDogFromList(this.id);
	}
}
