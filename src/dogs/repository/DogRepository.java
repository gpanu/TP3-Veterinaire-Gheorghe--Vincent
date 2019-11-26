package dogs.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogs.model.Dog;

public class DogRepository implements IDogRepository{
	
	private Map<Integer, Dog> dogs = new HashMap<Integer, Dog>();

	@Override
	public void add(Dog dog) {
		dogs.put(dog.getId(), dog);
	}
	
	public Collection<Dog> getList(){
		return this.dogs.values();	
	}

//	public Dog searchById(int id) {
//		
//	}
}
