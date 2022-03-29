package tn.esprit.Service;

import tn.esprit.Entity.Category_KEY;

import java.util.List;

public interface Category_KEYService {
	
	public Category_KEY addCategory_KEY(Category_KEY ck );
	
	void deleteCategory_KEY(int id);
	
	Category_KEY updateCategory_KEY(Category_KEY ck);

	Category_KEY retrieveCCategory_KEY(int id);

	List<Category_KEY> retrieveAllCategory_KEYs();
}
