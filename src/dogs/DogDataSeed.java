package dogs;
import java.util.Map;
import dogs.model.Client;
import dogs.model.Dog;
import dogs.model.IRepository;

public class DogDataSeed {

	private static final int FIRST_KEY_CLIENT = 1;
	private static final int SECOND_KEY_CLIENT = 2;
	private static final int THIRD_KEY_CLIENT = 3;
	private static final int FOURTH_KEY_CLIENT = 4;
	private IRepository<Dog> repository;
	@SuppressWarnings("unused")
	private IRepository<Client> clientRepository; //utilisé mais toujours souligné en jaune...
	private Map<Integer, Client> clients;
	
	public DogDataSeed(IRepository<Dog> repository, IRepository<Client> clientRepository) {
		this.repository = repository;
		this.clientRepository = clientRepository;
		this.clients = clientRepository.getMap(); //utilisé ici
		this.tableSeeder(repository, clientRepository);
	}
	
	public void tableSeeder (IRepository<Dog> repository, IRepository<Client> clientRepository) {
		final Client FIRST_CLIENT = clients.get(FIRST_KEY_CLIENT);
		final Client SECOND_CLIENT = clients.get(SECOND_KEY_CLIENT); 
		final Client THIRD_CLIENT = clients.get(THIRD_KEY_CLIENT); 
		final Client FOURTH_CLIENT = clients.get(FOURTH_KEY_CLIENT); 
		this.repository.add(new Dog("bob","boxer", FIRST_CLIENT.getId()));
		this.repository.add(new Dog("rex","pitbull", SECOND_CLIENT.getId()));
		this.repository.add(new Dog("chup","golden", THIRD_CLIENT.getId()));
		this.repository.add(new Dog("le chien de robert","de dorval", FOURTH_CLIENT.getId()));
	}
}
