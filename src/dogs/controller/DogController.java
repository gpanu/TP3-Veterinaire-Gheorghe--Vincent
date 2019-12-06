package dogs.controller;

import dogs.view.IView;
import dogs.view.SearchView;
import dogs.view.ShowDogView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JDialog;
import dogs.dto.DogDTO;
import dogs.dto.DogDTOWithId;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.view.AddDogConfirmationView;
import dogs.view.AddDogView;
import dogs.view.DeleteDogConfirmationView;
import dogs.view.DeleteDogView;

public class DogController extends JDialog implements IDogController {
	
	private IRepository<Dog> repository;
	private IClientController clientController;
	
	public DogController(IRepository<Dog> repository, IClientController clientController) {
		this.repository = repository;
		this.clientController = clientController;
	}

	@Override
	public void createDogView() {
		IView addDogView = new AddDogView(this);
		addDogView.display();
	}

	@Override
	public void addDogToRepository(DogDTO dto) {
		Dog dog = new Dog(dto.name, dto.breed, dto.ownerId);
		//ICI EXCEPTION SI OWNER INEXISTANT
		this.repository.add(dog);
	}

	@Override
	public void goToShow() {
		Collection<Dog> list = repository.getList(); 
		List<DogDTOWithId> dogs = new ArrayList<DogDTOWithId>();
		for(Dog dog : list) {
			DogDTOWithId dto = new DogDTOWithId(dog.getName(),dog.getBreed(),dog.getId(), dog.getOwnerId());
			dogs.add(dto);
		}
		
		IView ShowDogView = new ShowDogView(this, dogs, clientController.getDTOList());
		ShowDogView.display();
	}

	public IRepository<Dog> getRepo() {
		// TODO Auto-generated method stub
		return this.repository;
	}

	@Override
	public void showConfirmationAsked() {
		// TODO Auto-generated method stub
		IView confirmation = new AddDogConfirmationView();
		confirmation.display();
		this.dispose();
	}

	public void showDeleteDogViewAsked(ShowDogView showDogView) {
		// TODO Auto-generated method stub
		IView deleteView = new DeleteDogView(this, showDogView);
		deleteView.display();
	}

	public void showDeleteDogConfirmation(String idToDelete, ShowDogView showDogView) {
		// TODO Auto-generated method stub
		IView deleteView = new DeleteDogConfirmationView(this, idToDelete, showDogView);
		deleteView.display();
	}

	public void deleteDogFromList(String id) {
		Collection<Integer> list = repository.getKeys(); 
		int idInInt = Integer.parseInt(id);
		list.remove(idInInt);
	}
	
	public void searchBreed(String breed) {
		Collection<Dog> list = this.repository.getList();
		List<DogDTOWithId> newListDogs = new ArrayList<DogDTOWithId>();
		list.forEach(dog -> {if(dog.getBreed() == breed) {
			DogDTOWithId dto = new DogDTOWithId(dog.getName(),dog.getBreed(),dog.getId(), dog.getOwnerId());
			newListDogs.add(dto);}
		});
		goToShow();
	}

	public void showSearchViewDogAsked() {
		IView searchView = new SearchView(this);
		//deleteView.display();
	}
	
}
