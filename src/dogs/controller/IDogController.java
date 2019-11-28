package dogs.controller;

import dogs.dto.DogDTO;

public interface IDogController {

	void createDogView();

	void addDogToRepository(DogDTO dto);

	void goToShow();

}
