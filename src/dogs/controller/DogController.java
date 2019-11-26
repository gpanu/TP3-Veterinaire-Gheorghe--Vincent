package dogs.controller;

import dogs.view.IView;
import dogs.view.ShowView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JDialog;

import dogs.model.Dog;
import dogs.model.DogDTO;
import dogs.model.DogDTOWithId;
import dogs.repository.IDogRepository;
import dogs.view.AddView;

public class DogController extends JDialog implements IDogController {
	
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
		Collection<Dog> list = repository.getList(); 
		List<DogDTOWithId> dogs = new ArrayList<DogDTOWithId>();
		for(Dog dog : list) {
			DogDTOWithId dto = new DogDTOWithId(dog.getName(),dog.getBreed(),dog.getId());
			dogs.add(dto);
		}
		
		IView ShowDogView = new ShowView(this, dogs);
		ShowDogView.display();
		
		
	}
	
	public void showDogs() {
		
	}

	public IDogRepository getRepo() {
		// TODO Auto-generated method stub
		return this.repository;
	}
	

}
