package mock;

import dogs.controller.ClientController;
import dogs.model.Client;
import dogs.model.IRepository;

public class DogControllerMok extends ClientController{

	public DogControllerMok(IRepository<Client> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

}
