package tn.esprit.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import tn.esprit.Entity.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Component
public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	AppUser appuser;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(AppUser appuser,
			Collection<? extends GrantedAuthority> authorities) {
		this.appuser = appuser;
		this.authorities = authorities;
	}
	
	public UserDetailsImpl() {
	}

	public static UserDetailsImpl build(AppUser appuser) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(appuser.getRole().toString()));

		return new UserDetailsImpl(appuser,
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	public AppUser getAppUser () throws Exception {
		return appuser;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		try {
			return appuser.isStateUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user1 = (UserDetailsImpl) o;
		return Objects.equals(appuser, user1);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return appuser.getPassword();
	}
	
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return appuser.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
}
