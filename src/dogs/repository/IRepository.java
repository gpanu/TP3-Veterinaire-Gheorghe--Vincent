package dogs.repository;

import java.util.Collection;

public interface IRepository<T> {

	Collection<T> getList();
	void add(Entity t);

}
