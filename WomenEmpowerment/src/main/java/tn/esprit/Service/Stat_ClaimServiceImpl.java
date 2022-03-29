package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Stat_Claim;
import tn.esprit.Repository.Stat_ClaimRepository;

import java.util.List;

@Service
public class Stat_ClaimServiceImpl implements Stat_ClaimService{

	@Autowired
	Stat_ClaimRepository stat_claimrepository ;
	
	@Override
	public List<Stat_Claim> statistique() {
		return stat_claimrepository.statistique();
	}

}
