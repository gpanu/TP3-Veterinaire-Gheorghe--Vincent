package dogs.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import dogs.dto.ClientDTO;
import dogs.dto.ClientDTOWithId;
import dogs.model.Client;
import dogs.model.IRepository;
import dogs.view.AddClientView;
import dogs.view.IView;
import dogs.view.ShowClientView;
import dogs.view.ShowDogView;

public class ClientController implements IClientController {

	private IRepository<Client> repository;

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
			ClientDTOWithId dto = new ClientDTOWithId(client.getFirstName(),client.getLastName(),client.getNumber(),client.getId());
			clients.add(dto);
		}
		return clients;
	}
}
