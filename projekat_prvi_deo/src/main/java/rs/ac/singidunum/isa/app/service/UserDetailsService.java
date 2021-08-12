package rs.ac.singidunum.isa.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Korisnik;
import rs.ac.singidunum.isa.app.model.KorisnikPravoPristupa;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
	
	@Autowired
	KorisnikService korisnikService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Korisnik> korisnik = korisnikService.findByKorisnickoIme(username);
		if(korisnik.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			
			for(KorisnikPravoPristupa userPermission : korisnik.get().getKorisnikPravoPristupa()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(userPermission.getPravopristupa().getNaziv()));
			}
			
			return new org.springframework.security.core.userdetails.User(korisnik.get().getKorisnickoIme(), korisnik.get().getLozinka(), grantedAuthorities);
		}
		return null;
		
	}

}
