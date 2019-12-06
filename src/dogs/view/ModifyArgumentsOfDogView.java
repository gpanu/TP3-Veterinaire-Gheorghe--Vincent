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
import dogs.dto.DogDTOWithId;

public class ModifyArgumentsOfDogView extends JDialog implements IView, ActionListener {

	private static final int MAX_LENGTH = 40;
	private IDogController dogController;
	private JTextField name = new JTextField(MAX_LENGTH);
	private JTextField breed = new JTextField(MAX_LENGTH);
	private JPanel inputPanel = new JPanel();
	private String NAME_TEXT = "Nom:";
	private String BREED_TEXT = "Race:";
	private String VIEW_TITLE = "Confirmer et modifier ce chien";
	private String BUTTON_ACTION = "ModifyDog";
	private ShowDogView showDogView;
	private String dogId;

	public ModifyArgumentsOfDogView(DogController dogController, ShowDogView showDogView, String dogId) {
		super();
		this.inputPanel.setLayout(new BorderLayout());
		this.dogController = dogController;
		this.showDogView = showDogView;
		this.dogId = dogId;
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUpBreedPanel();
		this.setUpNamePanel();
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

	private void setUpNamePanel() {
		JPanel namePanel = new JPanel();
		this.inputPanel.add(namePanel, BorderLayout.NORTH);
		
		addNameText(namePanel);
		addTextLabel(namePanel, name);
	}

	private void addTextLabel(JPanel textPanel, JTextField text) {
		textPanel.add(text, BorderLayout.CENTER);
	}

	private void setUpBreedPanel() {
		JPanel breedPanel = new JPanel();
		this.inputPanel.add(breedPanel, BorderLayout.CENTER);
		
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
			this.dogController.showConfirmationAsked();
			dispose();
		}
	}

	private void insertDog() {
		DogDTOWithId dto = new DogDTOWithId(this.name.getText(), this.breed.getText(), Integer.parseInt(dogId), Integer.parseInt(dogId));
		this.dogController.modifyDog(showDogView, dto);
	}
}
