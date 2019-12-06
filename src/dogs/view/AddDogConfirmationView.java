package dogs.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.DogController;

public class AddDogConfirmationView extends JDialog implements IView {

	private DogController dogController;
	private String CONFIRMATION_MESSAGE = "- Le chien a bien été ajouté. Vous pouvez fermer la fenetre. -";

	public AddDogConfirmationView(DogController dogController) {
		super();
		this.dogController = dogController;
		this.setUpComponents();
		this.pack();
	}

	private void setUpComponents() {
		JLabel label = new JLabel(CONFIRMATION_MESSAGE , SwingConstants.CENTER);
		this.add(label, BorderLayout.WEST);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}
}
