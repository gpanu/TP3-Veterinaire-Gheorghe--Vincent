package dogs.view;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dogs.controller.ClientController;
import dogs.dto.ClientDTOWithId;

public class ShowClientView extends JDialog implements IView{

	private static final int ID_COLUMN = 0;
	private static final int FIRST_NAME_COLUMN = 1;
	private static final int LAST_NAME_COLUMN = 2;
	private static final int PHONE_NUMBER_COLUMN = 3;
	private static final int MAX_COLUMN = 4;
	private List<ClientDTOWithId> list;

	public ShowClientView(ClientController clientController, List<ClientDTOWithId> list) {
		super();
		this.list = list;
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUPTable();
		this.pack();
	}

	private void setUPTable() {	
		String[] tab = {"id","First Name","Last Name","Phone number"};
		final int SIZE = list.size();
		String[][] tab2D = new String[SIZE][MAX_COLUMN];
		for(int i = 0; i < SIZE; i++) {
			tab2D [i][ID_COLUMN] = Integer.toString(list.get(i).id);
			tab2D [i][FIRST_NAME_COLUMN] = list.get(i).firstName;
			tab2D [i][LAST_NAME_COLUMN] = list.get(i).lastName;
			tab2D [i][PHONE_NUMBER_COLUMN] = list.get(i).number;	
		}
		JTable table = new JTable(tab2D, tab);
		JScrollPane scr = new JScrollPane(table);
		this.add(scr);
	}
	@Override
	public void display() {
		this.setVisible(true);
	}

}
