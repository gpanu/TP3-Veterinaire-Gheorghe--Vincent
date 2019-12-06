package dogs.controller;

import dogs.dto.DogDTO;
import dogs.dto.DogDTOWithId;
import dogs.view.ShowDogView;

public interface IDogController {

	void createDogView();

	void addDogToRepository(DogDTO dto);

	void goToShow();

	void showConfirmationAsked();

	void modifyDog(ShowDogView showDogView, DogDTOWithId dto);

}
