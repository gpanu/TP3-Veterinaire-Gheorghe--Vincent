package dogs.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JDialog;
import dogs.dto.ClientDTO;
import dogs.dto.ClientDTOWithId;
import dogs.dto.DogDTOWithId;
import dogs.model.Client;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.view.AddClientConfirmationView;
import dogs.view.AddClientView;
import dogs.view.AddDogConfirmationView;
import dogs.view.DeleteClientConfirmationView;
import dogs.view.DeleteClientView;
import dogs.view.DeleteDogConfirmationView;
import dogs.view.DeleteDogView;
import dogs.view.IView;
import dogs.view.ModifyArgumentsOfClientView;
import dogs.view.ModifyArgumentsOfDogView;
import dogs.view.ModifyClientRequestView;
import dogs.view.ModifyDogRequestView;
import dogs.view.SearchClientIdView;
import dogs.view.SearchClientNameView;
import dogs.view.SearchDogIdView;
import dogs.view.ShowClientView;
import dogs.view.ShowDogView;

public class ClientController extends JDialog implements IClientController {

	private IRepository<Client> repository;
	private ClientController clientController;

	public ClientController(IRepository<Client> repository) {
		this.repository = repository;
	}

	@Override
	public void createClientView() {
		IView addDogView = new AddClientView(this);
		addDogView.display();
	}

	public void addClientToRepository(ClientDTO dto) {
		Client client = new Client(dto.firstName, dto.lastName, dto.number);
		this.repository.add(client);
	}

	@Override
	public void showClient() { 
		List<ClientDTOWithId> clients = getDTOList();
		
		IView ShowClientView = new ShowClientView(this, clients);
		ShowClientView.display();
	}

	public List<ClientDTOWithId> getDTOList() {
		List<ClientDTOWithId> clients = new ArrayList<ClientDTOWithId>();
		for(Client client : this.repository.getList()) {
			ClientDTOWithId dto = new ClientDTOWithId(client.getFirstName(),client.getLastName(),client.getNumber(), client.getId());
			clients.add(dto);
		}
		return clients;
	}

	public void showAddConfirmation() {
		IView confirmation = new AddClientConfirmationView();
		confirmation.display();
		this.dispose();
	}

	public void showDeleteClienViewAsked(ShowClientView showClientView) {
		IView deleteView = new DeleteClientView(this, showClientView);
		deleteView.display();
	}

	public void showModifyClienViewAsked(ShowClientView showClientView) {
		IView deleteView = new ModifyClientRequestView(this, showClientView);
		deleteView.display();
	}

	public void showSearchNameViewClienAsked(ShowClientView showClientView) {
		IView searchView = new SearchClientNameView(this, showClientView);
		searchView.display();
	}

	public void showSearchIdViewClienAsked(ShowClientView showClientView) {
		IView searchView = new SearchClientIdView(this, showClientView);
		searchView.display();
	}

	public void goToShow() {
		Collection<Client> list = repository.getList(); 
		List<ClientDTOWithId> clients = new ArrayList<ClientDTOWithId>();
		for(Client client : list) {
			ClientDTOWithId dto = new ClientDTOWithId(client.getFirstName(),client.getLastName(), client.getNumber(), client.getId());
			clients.add(dto);
		}
		IView ShowClientView = new ShowClientView(this, clients);
		ShowClientView.display();
	}

	public void deleteClientFromList(String id) {
		Collection<Integer> list = repository.getKeys(); 
		int idInInt = Integer.parseInt(id);
		list.remove(idInInt);
	}

	public void showDeleteDogConfirmation(String idToDelete, ShowClientView showClientView) {
		IView deleteView = new DeleteClientConfirmationView(this, idToDelete, showClientView);
		deleteView.display();
	}

	public void showSearchedIdClient(int id, ShowClientView showClientView) {
		searchId(id);
		showClientView.dispose();
	}

	private void searchId(int id) {
		Collection<Client> list = this.repository.getList();
		List<ClientDTOWithId> newListClient = new ArrayList<ClientDTOWithId>();
		for(Client client : list) {
			ClientDTOWithId dto = new ClientDTOWithId(client.getFirstName(),client.getLastName(),client.getNumber(), client.getId());
			if(dto.id == id) {newListClient.add(dto);}	
		}
		IView ShowClienView = new ShowClientView(this, newListClient);
		ShowClienView.display();
	}

	public void showModifyElementsOfClient(ShowClientView showClientView, int id) {
		IView modifyView = new ModifyArgumentsOfClientView(this, showClientView, id);
		modifyView.display();
	}

	public void showConfirmationAsked() {
		IView confirmation = new AddClientConfirmationView();
		confirmation.display();
		this.dispose();
	}

	public void modifyClient(ShowClientView showClientView, ClientDTOWithId dto) {
		Client client = new Client(dto.firstName, dto.lastName, dto.number);
		client.setId(dto.id);
		this.repository.modify(dto.id, client);
		showClientView.dispose();
		goToShow();
	}

	public void showSearchedNameClient(String name, ShowClientView showClientView) {
		searchName(name);
		showClientView.dispose();
	}

	private void searchName(String name) {
		Collection<Client> list = this.repository.getList();
		List<ClientDTOWithId> newListClient = new ArrayList<ClientDTOWithId>();
		for(Client client : list) {
			ClientDTOWithId dto = new ClientDTOWithId(client.getFirstName(),client.getLastName(),client.getNumber(), client.getId());
			if(dto.firstName.equals(name)) {newListClient.add(dto);}	
		}
		IView ShowClienView = new ShowClientView(this, newListClient);
		ShowClienView.display();
	}

	
}
