package dogs.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository<T extends Entity> implements IRepository<T>{
	
	private Map<Integer, T> entities = new HashMap<Integer, T>();
	
	public Collection<T> getList(){
		return this.entities.values();	
	}

	public void add(T objectToAdd) {
		entities.put(objectToAdd.getId(), objectToAdd);
	}

	public Collection<Integer> getKeys() {
		return this.entities.keySet();	}

//	public Dog searchById(int id) {
//	
//}
}
