package dogs.controller;

import java.util.List;

import dogs.dto.DogDTO;
import dogs.dto.DogDTOWithId;
import dogs.model.Dog;
import dogs.model.IRepository;
import dogs.view.IView;

public interface IDogController {

	void createDogView();

	void addDogToRepository(DogDTO dto);

	void goToShow();

	void showConfirmationAsked();

	void modifyDog(IView showDogView, DogDTOWithId dto);

	void deleteDogFromList(String id);

	IRepository<Dog> getRepo();

	void showDeleteDogViewAsked(IView showDogView);

	void showModifyDogViewAsked(IView showDogView);

	void showSearchBreedViewDogAsked(IView showDogView);

	void showSearchIdViewDogAsked(IView showDogView);

	void showSearchedIdDog(int parseInt, IView showDogView);

	void showSearchedBreedDog(String text, IView showDogView);

	void showModifyElementsOfDog(IView showDogView, String text);

	void showDeleteDogConfirmation(String text, IView showDogView);

	List<DogDTOWithId> getDTOList();

}
