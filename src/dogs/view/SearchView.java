package dogs.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dogs.controller.DogController;

public class SearchView extends JDialog implements IView {
	
	private static final String BUTTON_TITLE = "Rechercher";
	private static final String BUTTON_ACTION = "Search";
	private DogController dogController;

	public SearchView(DogController dogController) {
		super();
		this.dogController = dogController;
		this.setUpComponents();
		this.pack();
	}

	private void setUpComponents() {
		this.setUpSearchDogPanel();
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

	private void setUpSearchDogPanel() {
		JPanel dogIdPanel = new JPanel();
		this.add(dogIdPanel, BorderLayout.CENTER);
		
		addDogIdText(dogIdPanel);
		addTextLabel(dogIdPanel, dogIdField);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}
	
}
