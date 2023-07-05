package model;

public interface Repository {
	
	public void create(Object T);
	public void findById(String id);
	public void update(Object T);
	public void delete(Object T);
	
}
