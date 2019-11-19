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
import dogs.controller.IDogController;
import dogs.model.DogDTO;

public class AddView extends JDialog implements IView, ActionListener {

	private static final int MAX_LENGTH = 40;
	private IDogController dogController;
	private JTextField name = new JTextField(MAX_LENGTH);
	private JTextField breed = new JTextField(MAX_LENGTH);
	private String NAME_TEXT = "Name:";
	private String BREED_TEXT = "Race:";
	private String VIEW_TITLE = "Add dog";
	private String BUTTON_ACTION = "AddDog";
	 
	
	public AddView(DogController dogController) {
		super();
		this.dogController = dogController;
		this.setUpComponents();
		
	}

	private void setUpComponents() {
		this.setUpBreedPanel();
		this.setUpNamePanel();
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

	private void setUpNamePanel() {
		JPanel namePanel = new JPanel();
		this.add(namePanel, BorderLayout.NORTH);
		
		addNameText(namePanel);
		addTextLabel(namePanel, name);
	}

	private void addTextLabel(JPanel textPanel, JTextField text) {
		textPanel.add(text, BorderLayout.CENTER);
	}

	private void setUpBreedPanel() {
		JPanel breedPanel = new JPanel();
		this.add(breedPanel, BorderLayout.CENTER);
		
		addBreedText(breedPanel);
		addTextLabel(breedPanel, breed);
	}

	private void addNameText(JPanel text) {
		JLabel label = new JLabel(NAME_TEXT , SwingConstants.CENTER);
		text.add(label, BorderLayout.WEST);
		
	}

	private void addBreedText(JPanel text) {
		JLabel label = new JLabel(BREED_TEXT , SwingConstants.CENTER);
		text.add(label, BorderLayout.WEST);
		
	}
	
	@Override
	public void display() {
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_ACTION)){
			this.insertDog();
		}
		
	}

	private void insertDog() {
		DogDTO dto = new DogDTO(this.name.getText(), this.breed.getText());
		this.dogController.addDogToRepository(dto);
		
	}
	
	

}
