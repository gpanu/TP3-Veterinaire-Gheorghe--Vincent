package mock;

import java.util.List;

import dogs.controller.IDogController;
import dogs.dto.ClientDTOWithId;
import dogs.dto.DogDTOWithId;
import dogs.view.ShowDogView;

public class ShowDogViewMock extends ShowDogView{

	public ShowDogViewMock(IDogController dogController, List<DogDTOWithId> Dogslist,
			List<ClientDTOWithId> clientsList) {
		super(dogController, Dogslist, clientsList);
		// TODO Auto-generated constructor stub
	}

}
