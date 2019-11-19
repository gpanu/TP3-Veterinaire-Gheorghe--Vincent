package dogs.controller;

import dogs.model.DogDTO;

public interface IDogController {

	void goToCreate();

	void addDogToRepository(DogDTO dto);

	void goToShow();

}
