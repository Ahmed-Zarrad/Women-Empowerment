package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Membership;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository <Membership, Long>{
   // List<Membership> findByIdIn(List<Long> idMem);
   // List<Membership> findMembershipByappUser_Id(Long idUser);


}
