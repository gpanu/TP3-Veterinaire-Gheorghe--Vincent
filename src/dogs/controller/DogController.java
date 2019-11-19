package dogs.controller;

import dogs.view.IView;
import dogs.model.Dog;
import dogs.model.DogDTO;
import dogs.repository.IDogRepository;
import dogs.view.AddView;

public class DogController implements IDogController {
	
	private IDogRepository repository;
	
	public DogController(IDogRepository repository) {
		this.repository = repository;
	}

	@Override
	public void goToCreate() {
		IView addDogView = new AddView(this);
		addDogView.display();
	}

	@Override
	public void addDogToRepository(DogDTO dto) {
		Dog dog = new Dog(dto.name, dto.breed);
		this.repository.add(dog);
	}

	@Override
	public void goToShow() {
		
		
	}
	

}
