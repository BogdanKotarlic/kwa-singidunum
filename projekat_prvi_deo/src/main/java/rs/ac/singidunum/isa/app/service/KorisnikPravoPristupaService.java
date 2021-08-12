package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.KorisnikPravoPristupa;
import rs.ac.singidunum.isa.app.repository.KorisnikPravoPristupaRepository;

@Service
public class KorisnikPravoPristupaService {
	
	@Autowired
	private KorisnikPravoPristupaRepository korisnikPravoPristupaRepository;
	
	public Iterable<KorisnikPravoPristupa> findAll(){
		return korisnikPravoPristupaRepository.findAll();
	}
	
	public Optional<KorisnikPravoPristupa> findOne(Long id) {
		return korisnikPravoPristupaRepository.findById(id);
	}
	
	public KorisnikPravoPristupa save(KorisnikPravoPristupa korisnikPravoPristupa) {
		return korisnikPravoPristupaRepository.save(korisnikPravoPristupa);
	}
	
	public void delete(Long id) {
		korisnikPravoPristupaRepository.deleteById(id);
	}
	
	public void delete(KorisnikPravoPristupa korisnikPravoPristupa) {
		korisnikPravoPristupaRepository.delete(korisnikPravoPristupa);
	}
	
}
