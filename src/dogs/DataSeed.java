package dogs;

import dogs.model.Dog;
import dogs.repository.IDogRepository;

public class DataSeed {

	private IDogRepository repository;

	public DataSeed(IDogRepository repository) {
		this.repository = repository;
	}
	
	public void tableSeeder (IDogRepository repository) {
		this.repository.add(new Dog("bob","boxer"));
		this.repository.add(new Dog("rex","pitbull"));
		this.repository.add(new Dog("chup","golden"));
	}
}
