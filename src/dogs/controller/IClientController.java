package dogs.controller;

import java.util.List;

import dogs.dto.ClientDTO;
import dogs.dto.ClientDTOWithId;
import dogs.model.Client;
import dogs.model.IRepository;
import dogs.view.IView;

public interface IClientController {

	void createClientView();

	void showClient();

	List<ClientDTOWithId> getDTOList();

	void showDeleteClienViewAsked(IView showClientView);

	void showModifyClienViewAsked(IView showClientView);

	void showSearchIdViewClienAsked(IView showClientView);

	void showSearchNameViewClienAsked(IView showClientView);

	void showSearchedNameClient(String text, IView showClientView);

	void showSearchedIdClient(int parseInt, IView showClientView);

	void showModifyElementsOfClient(IView showClientView, int parseInt);

	void showConfirmationAsked();

	void modifyClient(IView showClientView, ClientDTOWithId dto);

	void showDeleteDogConfirmation(String text, IView showClientView);

	void deleteClientFromList(String id);

	void goToShow();

	void showAddConfirmation();

	void addClientToRepository(ClientDTO dto);

	IRepository<Client> getRepo();

}
