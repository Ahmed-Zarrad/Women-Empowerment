package tn.esprit.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Category_KEY;
@Repository
public interface Category_KeyRepository extends CrudRepository<Category_KEY, Integer>{


}
