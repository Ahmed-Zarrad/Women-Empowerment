package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.Entity.Comment;
import tn.esprit.Entity.Subject;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findBySubject(Subject subjectt);
	
	
	@Query("SELECT count(*) FROM Comment s join s.subject c where c.titleSub=:title")
    public int countcomment(@Param("title") String title);
	
	/*
	@Modifying
    @Query("DELETE FROM Comment s join s.subject where c.titleSub=:title ")
    public void deleteAllComment(@Param("title") String title);
		*/
}
