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

public class SearchBreedView extends JDialog implements IView, ActionListener{
	
	private static final String BUTTON_BREED_TITLE = "Rechercher par race";
	private static final String BUTTON_ACTION = "Search";
	private static final String ACTION_TO_DO_TEXT_BREED = "Entrez la race des chiens à afficher";
	private static final int MAX_LENGHT = 25;
	private DogController dogController;
	private JTextField dogBreedField = new JTextField(MAX_LENGHT);
	private ShowDogView showDogView;

	public SearchBreedView(DogController dogController, ShowDogView showDogView) {
		super();
		this.dogController = dogController;
		this.showDogView = showDogView;
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
		addButton(action, BUTTON_BREED_TITLE , BUTTON_ACTION);
	}

	private void addButton(JPanel action, String buttonTitle, String buttonAction) {
		JButton button = new JButton(buttonTitle);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		action.add(button);
	}

	private void setUpSearchDogPanel() {
		JPanel dogSearchPanel = new JPanel();
		this.add(dogSearchPanel, BorderLayout.CENTER);
		
		addDogSearchText(dogSearchPanel);
		addTextLabel(dogSearchPanel, dogBreedField );
	}

	private void addTextLabel(JPanel dogSearchPanel, JTextField dogBreedField) {
		dogSearchPanel.add(dogBreedField, BorderLayout.CENTER);
	}

	private void addDogSearchText(JPanel dogSearchPanel) {
		JLabel label = new JLabel(ACTION_TO_DO_TEXT_BREED , SwingConstants.CENTER);
		dogSearchPanel.add(label, BorderLayout.WEST);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.searchDogsConfirm();
			dispose();
		}
	}

	private void searchDogsConfirm() {
		this.dogController.showSearchedBreedDog(dogBreedField.getText(), this.showDogView);
	}
}