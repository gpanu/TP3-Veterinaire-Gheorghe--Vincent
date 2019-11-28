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
		this.repository.add(new Dog("bob","boxer"));
		this.repository.add(new Dog("rex","pitbull"));
		this.repository.add(new Dog("chup","golden"));
	}
}
