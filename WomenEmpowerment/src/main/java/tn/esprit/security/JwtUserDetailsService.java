package tn.esprit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.AppUser;
import tn.esprit.Service.IUserService;

import javax.transaction.Transactional;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	IUserService iuserservice;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AppUser appUser = new AppUser();
		try {
			appUser = iuserservice.getByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return UserDetailsImpl.build(appUser);
	}

}
