package dogs;

import dogs.controller.DogController;
import dogs.controller.IDogController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;
import dogs.repository.DogRepository;
import dogs.repository.IDogRepository;
import dogs.view.WelcomeView;

public class MainAppDogs {

	IDogRepository repository;
	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		this.createRepository();
		this.createControllers();
	}
	
	private void createRepository() {
		this.repository = new DogRepository();
		this.seedData();
	}

	private void seedData() {
		new DataSeed(this.repository);
	}

	private void createControllers() {
		IDogController dogController = new DogController(this.repository);
		IWelcomeController appController = new WelcomeController(dogController);
		appController.startApplication();
	}
}
