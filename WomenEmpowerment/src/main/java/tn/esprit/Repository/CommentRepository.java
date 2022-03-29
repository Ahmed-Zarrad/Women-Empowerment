package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Comment;
import tn.esprit.Entity.Subject;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findBySubject(Subject subjectt);
	
	
	@Query("SELECT count(s) FROM Comment s join s.subject c where c.titleSub=:title")
    public int countcomment(@Param("title") String title);
	
	@Query("SELECT count(s) FROM Comment s")
    public int countcommentt();
	
	
	
	

}
