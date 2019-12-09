package mock;

import dogs.controller.ClientController;
import dogs.model.Client;
import dogs.model.IRepository;

public class DogControllerMock extends ClientController{

	public DogControllerMock(IRepository<Client> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
