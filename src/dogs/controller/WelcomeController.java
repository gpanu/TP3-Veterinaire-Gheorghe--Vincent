package dogs.controller;
import dogs.view.IView;
import dogs.view.WelcomeView;

public class WelcomeController implements IWelcomeController {


	private IDogController dogController;
	private IClientController clientController;
	
	public WelcomeController (IDogController dogController, IClientController clientController) {
		this.dogController = dogController;
		this.clientController = clientController;
	}

	public void startApplication() {;
		IView welcomeView = new WelcomeView(this);
		welcomeView.display();
	}

	public void wantCreateDog() {
		this.dogController.createDogView();
		
	}

	@Override
	public void wantShowDogs() {
		this.dogController.goToShow();
		
	}
	
	public void wantToCreateClient() {
		this.clientController.createClientView();
	}
	
}
