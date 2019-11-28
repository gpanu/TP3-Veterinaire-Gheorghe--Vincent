package dogs.view;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import dogs.controller.DogController;
import dogs.dto.DogDTOWithId;

public class ShowDogView extends JDialog implements IView {

	private static final int ID_COLUMN = 0;
	private static final int NAME_COLUMN = 1;
	private static final int BREED_COLUMN = 2;
	private static final int MAX_COLUMN = 3;
	private DogController dogController;
	private List<DogDTOWithId> list;

	public ShowDogView(DogController dogController, List<DogDTOWithId> list) {
		super();
		this.dogController = dogController;
		this.list = list;
		this.setUpComponents();
	}

	private void setUpComponents() {
		this.setUPTable();
		this.pack();
	}

	private void setUPTable() {	
		String[] tab = {"id","name","breed"};
		final int SIZE = list.size();
		String[][] tab2D = new String[SIZE][MAX_COLUMN];
		for(int i = 0; i < SIZE; i++) {
			tab2D [i][ID_COLUMN] = Integer.toString(list.get(i).id);
			tab2D [i][NAME_COLUMN] = list.get(i).name;
			tab2D [i][BREED_COLUMN] = list.get(i).breed;
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
