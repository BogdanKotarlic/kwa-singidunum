package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Nastavnik;
import rs.ac.singidunum.isa.app.repository.NastavnikRepository;

@Service
public class NastavnikService {
	
	@Autowired
	private NastavnikRepository nastavnikRepository;
	
	public Iterable<Nastavnik> findAll(){
		return nastavnikRepository.findAll();
	}
	
	public Optional<Nastavnik> findOne(Long id) {
		return nastavnikRepository.findById(id);
	}
	
	public Nastavnik save(Nastavnik nastavnik) {
		return nastavnikRepository.save(nastavnik);
	}
	
	public void delete(Long id) {
		nastavnikRepository.deleteById(id);
	}
	
	public void delete(Nastavnik nastavnik) {
		nastavnikRepository.delete(nastavnik);
	}
	
	
}

