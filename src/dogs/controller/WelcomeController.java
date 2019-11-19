package dogs.controller;

import javax.swing.JButton;

import dogs.view.IView;
import dogs.view.WelcomeView;

public class WelcomeController implements IWelcomeController {


	private IDogController dogController;
	
	public WelcomeController (IDogController dogController) {
		this.dogController = dogController;
	}

	public void startApplication() {;
		IView welcomeView = new WelcomeView(this);
		welcomeView.display();
	}

	public void wantCreateDog() {
		this.dogController.goToCreate();
		
	}

	@Override
	public void wantShowDogs() {
		this.dogController.goToShow();
		
	}
	
}
