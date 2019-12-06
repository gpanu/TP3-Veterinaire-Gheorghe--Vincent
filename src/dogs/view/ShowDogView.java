package dogs.view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dogs.controller.DogController;
import dogs.dto.ClientDTOWithId;
import dogs.dto.DogDTOWithId;

public class ShowDogView extends JDialog implements IView, ActionListener {

	private static final int ID_COLUMN = 0;
	private static final int NAME_COLUMN = 1;
	private static final int BREED_COLUMN = 2;
	private static final int OWNER_ID = 3;
	private static final int OWNER_FIRST_NAME = 4;
	private static final int OWNER_LAST_NAME = 5;
	private static final int OWNER_NUMBER = 6;
	private static final int MAX_COLUMN = 7;
	private static final String VIEW_DELETE_TITLE = "Supprimer un chien";
	private static final String VIEW_SEARCH_TITLE = "Recherche d'un chien";
	private static final String VIEW_MODIFY_TITLE = "Modifier un chien";
	private static final String BUTTON_DELETE = "DeleteDog";
	private static final String BUTTON_SEARCH = "SearchDog";
	private static final String BUTTON_MODIFY = "Modify";
	private DogController dogController;
	private List<DogDTOWithId> Dogslist;
	private List<ClientDTOWithId> clientsList;

	public ShowDogView(DogController dogController, List<DogDTOWithId> Dogslist, List<ClientDTOWithId> clientsList) {
		super();
		this.dogController = dogController;
		this.Dogslist = Dogslist;
		this.clientsList = clientsList;
		this.setUpComponents();
		this.pack();
	}

	private void setUpComponents() {
		this.setUPTable();
		this.setUpActionPanel();
	}

	private void setUPTable() {	
		String[] tab = {"id","name","breed","owner Id", "owner First Name", "owner Last Name", "phone"};
		final int SIZE = Dogslist.size();
		String[][] tab2D = new String[SIZE][MAX_COLUMN];
		for(int i = 0; i < SIZE; i++) {
			tab2D [i][ID_COLUMN] = Integer.toString(Dogslist.get(i).id);
			tab2D [i][NAME_COLUMN] = Dogslist.get(i).name;
			tab2D [i][BREED_COLUMN] = Dogslist.get(i).breed;
			tab2D [i][OWNER_ID] = Dogslist.get(i).ownerId + "";
			tab2D [i][OWNER_FIRST_NAME] = clientsList.get(Dogslist.get(i).ownerId - 1).firstName;
			tab2D [i][OWNER_LAST_NAME] = clientsList.get(Dogslist.get(i).ownerId - 1).lastName;
			tab2D [i][OWNER_NUMBER] = clientsList.get(Dogslist.get(i).ownerId - 1).number;
		}
		JTable table = new JTable(tab2D, tab);
		JScrollPane scr = new JScrollPane(table);
		this.add(scr);
	}
	
	private void setUpActionPanel() {
		JPanel action = new JPanel();
		JPanel search = new JPanel();
		this.add(action, BorderLayout.SOUTH);
		this.add(search, BorderLayout.WEST);
		addButton(action, VIEW_DELETE_TITLE, BUTTON_DELETE);
		addButton(search, VIEW_SEARCH_TITLE, BUTTON_SEARCH);
		addButton(action, VIEW_MODIFY_TITLE, BUTTON_MODIFY);
	}
	
	private void addButton(JPanel panel, String message, String buttonAction) {
		JButton button = new JButton(message);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		panel.add(button);
	}

	@Override
	public void display() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_DELETE)){
			this.dogController.showDeleteDogViewAsked(this);
		}
		if(act.getActionCommand().equals(BUTTON_MODIFY)){
			this.dogController.showModifyDogViewAsked(this);
		}
	}
}
