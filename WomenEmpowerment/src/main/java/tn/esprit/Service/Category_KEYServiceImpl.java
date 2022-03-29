package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Category_KEY;
import tn.esprit.Repository.Category_KeyRepository;

import java.util.List;
@Service
public class Category_KEYServiceImpl implements Category_KEYService {

	@Autowired
	Category_KeyRepository category_keyRepository;
	
	@Override
	public Category_KEY addCategory_KEY(Category_KEY ck) {
		return category_keyRepository.save(ck);
	}

	@Override
	public void deleteCategory_KEY(int id) {
		category_keyRepository.deleteById(id);		
	}

	@Override
	public Category_KEY updateCategory_KEY(Category_KEY ck) {
			return category_keyRepository.save(ck);

	}

	@Override
	public Category_KEY retrieveCCategory_KEY(int id) {
		return category_keyRepository.findById(id).orElse(null);

	}

	@Override
	public List<Category_KEY> retrieveAllCategory_KEYs() {
		return (List<Category_KEY>) category_keyRepository.findAll();
	}
	 

}
