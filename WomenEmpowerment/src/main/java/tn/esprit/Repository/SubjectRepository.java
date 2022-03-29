package tn.esprit.Repository;




import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import tn.esprit.Entity.Subject;
import tn.esprit.Entity.Userx;



@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
	
	
	Subject findBytitleSub(String titleSub);
	

	List<Subject> findByUserx(Userx Userxx);
	
	
	
	@Query("SELECT s FROM Subject s join s.userx c where c.Id=:Iduser")
	public List<Subject> getAllSubjectbyId(@Param("Iduser") int Iduser);
	
	
	
	@Query("SELECT s FROM Subject s join s.userx c where c.FirstName=:name")
	public List<Subject> getAllSubjectByName(@Param("name") String name);
	
	
	
	
	@Query("SELECT s FROM Subject s WHERE s.Datesub between:d1 and :d2")
	public List<Subject> retrieveallSubjectByDate(@Param("d1") Date d1, @Param("d2") Date d2);
	
	
	@Query("SELECT titleSub FROM Subject")
    public List<String> subjecttitle();
	
	
	
	List<Subject> findByStarsNumberSubjectGreaterThan(int starsNumberSubject);
	
	
	List<Subject> findByStarsNumberSubjectLessThan(int starsNumberSubject);
	
	
	
	@Query("SELECT s FROM Subject s ORDER BY s.starsNumberSubject DESC")
	List<Subject> retrievesuborderbystars();
	
	

	
	@Query("SELECT MAX(b.starsNumberSubject) FROM Subject b")
	public int getmaxstarsNumberSubject();
	
	
	
	
	
	
	
}
