package dogs.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dogs.model.Client;
import dogs.model.Dog;

public class Repository<T extends Entity> implements IRepository<T>{
	
	private Map<Integer, T> entities = new HashMap<Integer, T>();
	
	public Collection<T> getList(){
		return this.entities.values();	
	}


	public void add(Entity t) {
		entities.put(t.getId(), (T) t);
	}


//	public Dog searchById(int id) {
//	
//}
}
