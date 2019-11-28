package dogs.controller;

import dogs.view.IView;
import dogs.view.ShowDogView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JDialog;
import dogs.dto.DogDTO;
import dogs.dto.DogDTOWithId;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.view.AddDogView;

public class DogController extends JDialog implements IDogController {
	
	private IRepository<Dog> repository;
	
	public DogController(IRepository<Dog> repository) {
		this.repository = repository;
	}

	@Override
	public void createDogView() {
		IView addDogView = new AddDogView(this);
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
		
		IView ShowDogView = new ShowDogView(this, dogs);
		ShowDogView.display();
	}

	public IRepository<Dog> getRepo() {
		// TODO Auto-generated method stub
		return this.repository;
	}
	

}
