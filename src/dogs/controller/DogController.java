package dogs.controller;

import dogs.view.IView;
import dogs.view.ModifyArgumentsOfDogView;
import dogs.view.ModifyDogRequestView;
import dogs.view.SearchBreedView;
import dogs.view.SearchDogIdView;
import dogs.view.ShowDogView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

	public void showDeleteDogViewAsked(IView showDogView) {
		// TODO Auto-generated method stub
		IView deleteView = new DeleteDogView(this, showDogView);
		deleteView.display();
	}

	public void showDeleteDogConfirmation(String idToDelete, IView showDogView) {
		// TODO Auto-generated method stub
		IView deleteView = new DeleteDogConfirmationView(this, idToDelete, showDogView);
		deleteView.display();
	}

	public void deleteDogFromList(String id) {
		this.repository.remove(id);
	}
	
	public void showModifyDogViewAsked(IView showDogView) {
		// TODO Auto-generated method stub
		IView deleteView = new ModifyDogRequestView(this, showDogView);
		deleteView.display();
	}

	public void modifyDog(IView showDogView, DogDTOWithId dto) {
		dto.ownerId = this.getOwnerId(dto.id);
		Dog dog = new Dog(dto.name, dto.breed, dto.ownerId);
		dog.setId(dto.id);
		this.repository.modify(dto.id, dog);
		showDogView.dispose();
		goToShow();
	}

	private int getOwnerId(int dogId) {
		Map<Integer, Dog> list = repository.getMap();
		Dog dog = list.get(dogId);
		return dog.getOwnerId();
	}

	public void showModifyElementsOfDog(IView showDogView, String id) {
		IView modifyView = new ModifyArgumentsOfDogView(this, showDogView, id);
		modifyView.display();
	}
		
	public void searchBreed(String breed) {
		Collection<Dog> list = this.repository.getList();
		List<DogDTOWithId> newListDogs = new ArrayList<DogDTOWithId>();
		for(Dog dog : list) {
			DogDTOWithId dto = new DogDTOWithId(dog.getName(),dog.getBreed(),dog.getId(), dog.getOwnerId());
			if(dto.breed.equals(breed)) {newListDogs.add(dto);}	
		}
		IView ShowDogView = new ShowDogView(this, newListDogs, clientController.getDTOList());
		ShowDogView.display();
	}
	
	public void searchId(int id) {
		Collection<Dog> list = this.repository.getList();
		List<DogDTOWithId> newListDogs = new ArrayList<DogDTOWithId>();
		for(Dog dog : list) {
			DogDTOWithId dto = new DogDTOWithId(dog.getName(),dog.getBreed(),dog.getId(), dog.getOwnerId());
			if(dto.id == id) {newListDogs.add(dto);}	
		}
		IView ShowDogView = new ShowDogView(this, newListDogs, clientController.getDTOList());
		ShowDogView.display();
	}

	public void showSearchBreedViewDogAsked(IView showDogView) {
		IView searchView = new SearchBreedView(this, showDogView);
		searchView.display();
	}

	public void showSearchIdViewDogAsked(IView showDogView) {
		IView searchView = new SearchDogIdView(this, showDogView);
		searchView.display();	
	}
	
	public void showSearchedBreedDog(String breed, IView showDogView) {
		searchBreed(breed);
		showDogView.dispose();
	}
	
	public void showSearchedIdDog(int id, IView showDogView) {
		searchId(id);
		showDogView.dispose();
	}

	@Override
	public List<DogDTOWithId> getDTOList() {
		List<DogDTOWithId> dogs = new ArrayList<DogDTOWithId>();
		for(Dog dog : this.repository.getList()) {
			DogDTOWithId dto = new DogDTOWithId(dog.getName(),dog.getBreed(), dog.getOwnerId(), dog.getId());
			dogs.add(dto);
		}
		return dogs;
	}
}
