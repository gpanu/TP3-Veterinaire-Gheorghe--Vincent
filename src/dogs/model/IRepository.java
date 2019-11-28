package dogs.model;

import java.util.Collection;

public interface IRepository<T> {

	Collection<T> getList();
	void add(T t);

}
