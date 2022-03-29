package tn.esprit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.Entity.Cagnotte;

public interface CagnotteRepository extends JpaRepository <Cagnotte , Integer >{

}
