package dogs.view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dogs.controller.DogController;

public class ShowView extends JDialog implements IView {

	private DogController dogController;

	public ShowView(DogController dogController) {
		super();
		this.dogController = dogController;
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUpActionPanel();
		this.setUPTable();
		this.pack();
		
	}

	private void setUPTable() {
		String[] tab = {"id","name","breed"};
		String[][] tab2D = {{"1","gyyg","pitb"}};
		JTable table = new JTable(tab2D, tab);
		JScrollPane scr = new JScrollPane(table);
		this.add(scr);
		
	}

	private void setUpActionPanel() {
		JPanel action = new JPanel();
	}

	@Override
	public void display() {
		this.setVisible(true);

	}
}
