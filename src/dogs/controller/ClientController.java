package dogs.controller;

import dogs.model.IRepository;
import dogs.view.AddClientView;
import dogs.view.AddDogView;
import dogs.view.IView;

public class ClientController implements IClientController {

	private IRepository repository;

	public ClientController(IRepository repository) {
		this.repository = repository;
	}

	@Override
	public void createClientView() {
		IView addDogView = new AddClientView(this);
		addDogView.display();
	}

}
