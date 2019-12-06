package dogs.controller;

import java.util.List;

import dogs.dto.ClientDTOWithId;

public interface IClientController {

	void createClientView();

	void showClient();

	List<ClientDTOWithId> getDTOList();

}
