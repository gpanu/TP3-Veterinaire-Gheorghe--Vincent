package dogs.controller;

import dogs.dto.ClientDTO;
import dogs.model.Client;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.view.AddClientView;
import dogs.view.IView;

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
}
