package dogs.repository;

import java.util.Collection;

import dogs.model.Dog;

public interface IDogRepository {

	void add(Dog dog);

	Collection<Dog> getList();

}
