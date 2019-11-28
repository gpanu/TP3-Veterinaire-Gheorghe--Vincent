package dogs.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repository<T extends Entity> implements IRepository<T>{
	
	private Map<Integer, T> entities = new HashMap<Integer, T>();
	
	public Collection<T> getList(){
		return this.entities.values();	
	}


	public void add(T t) {
		entities.put(t.getId(), t);
	}


//	public Dog searchById(int id) {
//	
//}
}
