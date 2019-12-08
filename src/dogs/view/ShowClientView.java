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

import dogs.controller.ClientController;
import dogs.dto.ClientDTOWithId;

public class ShowClientView extends JDialog implements IView, ActionListener{

	private static final int ID_COLUMN = 0;
	private static final int FIRST_NAME_COLUMN = 1;
	private static final int LAST_NAME_COLUMN = 2;
	private static final int PHONE_NUMBER_COLUMN = 3;
	private static final int MAX_COLUMN = 4;
	private static final String BUTTON_DELETE = "DeleteClient";
	private static final String BUTTON_MODIFY = "modifiCliennt";
	private static final String BUTTON_SEARCH_BY_NAME = "searchClientName";
	private static final String BUTTON_SEARCH_BY_ID = "searchClientId";
	private static final String VIEW_DELETE_TITLE = "Suprimer un client";
	private static final String VIEW_SEARCH_TITLE_NAME = "Recherche par nom";
	private static final String VIEW_DELETE_TITLE_ID = "Recherceh par id";
	private static final String VIEW_MODIFY_TITLE = "Modifier un client";
	private List<ClientDTOWithId> list;
	private ClientController clientController;

	public ShowClientView(ClientController clientController, List<ClientDTOWithId> Clientslist) {
		super();
		this.list = Clientslist;
		this.clientController = clientController;
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUPTable();
		this.setUpActionPanel();
		this.pack();
	}

	private void setUPTable() {	
		String[] tab = {"id","First Name","Last Name","Phone number"};
		final int SIZE = list.size();
		String[][] tab2D = new String[SIZE][MAX_COLUMN];
		for(int i = 0; i < SIZE; i++) {
			tab2D [i][ID_COLUMN] = list.get(i).id+"";
			tab2D [i][FIRST_NAME_COLUMN] = list.get(i).firstName;
			tab2D [i][LAST_NAME_COLUMN] = list.get(i).lastName;
			tab2D [i][PHONE_NUMBER_COLUMN] = list.get(i).number;	
		}
		JTable table = new JTable(tab2D, tab);
		//voir showDogView pour info
		table.setAutoCreateRowSorter(true);
		JScrollPane scr = new JScrollPane(table);
		this.add(scr);
	}
	
	@Override
	public void display() {
		this.setVisible(true);
	}
	
	private void setUpActionPanel() {
		JPanel action = new JPanel();
		JPanel search = new JPanel();
		this.add(action, BorderLayout.SOUTH);
		this.add(search, BorderLayout.WEST);
		addButton(action, VIEW_DELETE_TITLE, BUTTON_DELETE);
		addButton(search, VIEW_SEARCH_TITLE_NAME, BUTTON_SEARCH_BY_NAME);
		addButton(search, VIEW_DELETE_TITLE_ID, BUTTON_SEARCH_BY_ID);
		addButton(action, VIEW_MODIFY_TITLE, BUTTON_MODIFY);
	}
	
	private void addButton(JPanel panel, String message, String buttonAction) {
		JButton button = new JButton(message);
		button.setActionCommand(buttonAction);
		button.addActionListener(this);
		
		panel.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent act) {
		if(act.getActionCommand().equals(BUTTON_DELETE)){
			this.clientController.showDeleteClienViewAsked(this);
		}
		if(act.getActionCommand().equals(BUTTON_MODIFY)){
			this.clientController.showModifyClienViewAsked(this);
		}
		if(act.getActionCommand().equals(BUTTON_SEARCH_BY_NAME)){
			this.clientController.showSearchNameViewClienAsked(this);
		}
		if(act.getActionCommand().equals(BUTTON_SEARCH_BY_ID)){
			this.clientController.showSearchIdViewClienAsked(this);
		}
	}
}
