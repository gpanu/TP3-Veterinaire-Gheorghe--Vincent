package dogs;

import dogs.controller.DogController;
import dogs.controller.IDogController;
import dogs.controller.IWelcomeController;
import dogs.controller.WelcomeController;
import dogs.repository.DogRepository;
import dogs.repository.IDogRepository;
import dogs.view.WelcomeView;

public class MainAppDogs {

	
	public static void main(String[] args) {
		new MainAppDogs();
	}

	public MainAppDogs() {
		this.createControllers();
	}
	
	private void createControllers() {
		IDogRepository repository = new DogRepository();
		IDogController dogController = new DogController(repository);
		IWelcomeController appController = new WelcomeController(dogController);
		appController.startApplication();
	}

}
