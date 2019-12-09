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

public class SearchDogIdView extends JDialog implements IView,ActionListener {
	
	private static final String BUTTON_ID_TITLE = "Rechercher par ID";
	private static final String BUTTON_ACTION = "Search";
	private static final String ACTION_TO_DO_TEXT_ID = "Entrez le ID du chien à afficher";
	private static final int MAX_LENGHT = 25;
	private IDogController dogController;
	private JTextField dogIdField = new JTextField(MAX_LENGHT);
	private IView showDogView;


	public SearchDogIdView(IDogController dogController, IView showDogView) {
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
		addButton(action, BUTTON_ID_TITLE , BUTTON_ACTION);
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
		addTextLabel(dogSearchPanel, dogIdField );
	}

	private void addTextLabel(JPanel dogSearchPanel, JTextField dogIdField) {
		dogSearchPanel.add(dogIdField, BorderLayout.CENTER);
	}

	private void addDogSearchText(JPanel dogSearchPanel) {
		JLabel label = new JLabel(ACTION_TO_DO_TEXT_ID , SwingConstants.CENTER);
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
		this.dogController.showSearchedIdDog(Integer.parseInt(dogIdField.getText()), showDogView);;
	}
}
