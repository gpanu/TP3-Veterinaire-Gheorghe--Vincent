package dogs;

import dogs.controller.ClientController;
import dogs.controller.DogController;
import dogs.controller.IClientController;
import dogs.controller.IDogController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;
import dogs.repository.Repository;
import dogs.repository.IRepository;
import dogs.view.WelcomeView;

public class MainAppDogs {

	IRepository repository;
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		this.createRepository();
		this.createControllers();
	}
	
	private void createRepository() {
		this.repository = new Repository();
		this.seedData();
	}

	private void seedData() {
		new DataSeed(this.repository);
	}

	private void createControllers() {
		IDogController dogController = new DogController(this.repository);
		IClientController clientController = new ClientController(this.repository);
		IWelcomeController appController = new WelcomeController(dogController, clientController);
		appController.startApplication();
	}
}
