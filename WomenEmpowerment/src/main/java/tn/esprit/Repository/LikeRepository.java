package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Liking;


@Repository
public interface LikeRepository extends JpaRepository<Liking, Integer > {
	
	
	
	@Query("SELECT COUNT(l) from Liking l WHERE l.user.idUser =:idUser and l.subject.idSub =:idSubject")
	public int isLikeExists(@Param("idUser") int idUser,@Param("idSubject") int idSubject);

	
	@Query("SELECT count(s) FROM Liking s  where s.subject.idSub=:idd")
    public int countlike(@Param("idd") int idd);
}
