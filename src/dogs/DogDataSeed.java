package dogs;

import dogs.model.Dog;
import dogs.model.IRepository;

public class DogDataSeed {

	private IRepository<Dog> repository;

	public DogDataSeed(IRepository<Dog> repository) {
		this.repository = repository;
		this.tableSeeder(repository);
	}
	
	public void tableSeeder (IRepository<Dog> repository) {
		this.repository.add(new Dog("bob","boxer", 1));
		this.repository.add(new Dog("rex","pitbull", 2));
		this.repository.add(new Dog("chup","golden", 3));
		this.repository.add(new Dog("le chien de robert","de dorval", 4));
	}
}
