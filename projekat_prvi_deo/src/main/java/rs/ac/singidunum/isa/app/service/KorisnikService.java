package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Korisnik;
import rs.ac.singidunum.isa.app.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;

	public Iterable<Korisnik> findAll(){
		return korisnikRepository.findAll();
	}
	
	public Optional<Korisnik> findOne(Long id) {
		return korisnikRepository.findById(id);
	}
	
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}
	
	public void delete(Long id) {
		korisnikRepository.deleteById(id);
	}
	
	public void delete(Korisnik korisnik) {
		korisnikRepository.delete(korisnik);
	}
	
	public Optional<Korisnik> findByKorisnickoIme(String korisnickoIme) {
		return korisnikRepository.findByKorisnickoIme(korisnickoIme);
	}
	
}
