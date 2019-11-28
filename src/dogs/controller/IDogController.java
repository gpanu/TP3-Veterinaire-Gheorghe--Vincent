package dogs.controller;

import dogs.model.DogDTO;

public interface IDogController {

	void createDogView();

	void addDogToRepository(DogDTO dto);

	void goToShow();

}
