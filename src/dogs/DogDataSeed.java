package dogs;

import dogs.model.Client;
import dogs.model.Dog;
import dogs.model.IRepository;

public class DogDataSeed {

	private IRepository<Dog> repository;
	private IRepository<Client> clientRepository;

	public DogDataSeed(IRepository<Dog> repository, IRepository<Client> clientRepository) {
		this.repository = repository;
		this.clientRepository = clientRepository;
		this.tableSeeder(repository, clientRepository);
	}
	
	public void tableSeeder (IRepository<Dog> repository, IRepository<Client> clientRepository) {
		this.repository.add(new Dog("bob","boxer", 1));
		this.repository.add(new Dog("rex","pitbull", 2));
		this.repository.add(new Dog("chup","golden", 3));
		this.repository.add(new Dog("le chien de robert","de dorval", 4));
	}
}
