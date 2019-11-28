package dogs;

import dogs.controller.ClientController;
import dogs.controller.DogController;
import dogs.controller.IClientController;
import dogs.controller.IDogController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;
import dogs.model.Client;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.model.Repository;

public class MainAppDogs {

	IRepository<Dog> dogRepository;
	IRepository<Client> clientRepository;
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		this.createRepository();
		this.createControllers();
	}
	
	private void createRepository() {
		this.dogRepository = new Repository<Dog>();
		this.clientRepository = new Repository<Client>();
		this.seedData();
	}

	private void seedData() {
		new DogDataSeed(this.dogRepository);
		new ClientDataSeed(this.clientRepository);
	}

	private void createControllers() {
		IDogController dogController = new DogController(this.dogRepository);
		IClientController clientController = new ClientController(this.clientRepository);
		IWelcomeController appController = new WelcomeController(dogController, clientController);
		appController.startApplication();
	}
}
