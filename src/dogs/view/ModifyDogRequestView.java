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
import dogs.controller.IDogController;


public class ModifyDogRequestView extends JDialog implements IView, ActionListener {

	private static final String BUTTON_TITLE = "Modifier le chien";
	private static final String BUTTON_ACTION = "Modify";
	private static final int MAX_LENGTH = 4;
	private static final String MESSAGE = "Entrez le ID du chien � modifier: ";
	private JTextField dogIdField = new JTextField(MAX_LENGTH);
	private IDogController dogController;
	private IView showDogView;

	public ModifyDogRequestView(IDogController dogController, IView showDogView) {
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
		addTextLabel(dogIdPanel, dogIdField );
	}
	
	private void addTextLabel(JPanel dogIdPanel, JTextField dogId) {
		dogIdPanel.add(dogId, BorderLayout.CENTER);
	}

	private void addDogIdText(JPanel firstNamePanel) {
		JLabel label = new JLabel(MESSAGE , SwingConstants.CENTER);
		firstNamePanel.add(label, BorderLayout.WEST);
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.modifyDogConfirmation();
			dispose();
		}
	}

	private void modifyDogConfirmation() {
		this.dogController.showModifyElementsOfDog(this.showDogView, dogIdField.getText());
	}
}
