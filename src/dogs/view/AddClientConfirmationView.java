package dogs.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class AddClientConfirmationView extends JDialog implements IView {

	private String CONFIRMATION_MESSAGE = "- Le client a bien été ajouté. Vous pouvez fermer la fenetre. -";

	public AddClientConfirmationView() {
		super();
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
