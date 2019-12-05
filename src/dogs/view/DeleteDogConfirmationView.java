package dogs.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dogs.controller.DogController;

public class DeleteDogConfirmationView extends JDialog implements IView, ActionListener {

	private static String CONFIRMATION_MESSAGE = String.format("Etes vous sur de vouloir supprimer le chien avec le id - ");
	private DogController dogController;
	private static String id;

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
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
