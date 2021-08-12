package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.PohadjanjePredmeta;
import rs.ac.singidunum.isa.app.repository.PohadjanjePredmetaRepository;

@Service
public class PohadjanjePredmetaService {

	@Autowired
	private PohadjanjePredmetaRepository pohadjanjePredmetaRepository;
	
	public Iterable<PohadjanjePredmeta> findAll(){
		return pohadjanjePredmetaRepository.findAll();
	}
	
	public Optional<PohadjanjePredmeta> findOne(Long id) {
		return pohadjanjePredmetaRepository.findById(id);
	}
	
	public PohadjanjePredmeta save(PohadjanjePredmeta pohadjanjePredmeta) {
		return pohadjanjePredmetaRepository.save(pohadjanjePredmeta);
	}
	
	public void delete(Long id) {
		pohadjanjePredmetaRepository.deleteById(id);
	}
	
	public void delete(PohadjanjePredmeta pohadjanjePredmeta) {
		pohadjanjePredmetaRepository.delete(pohadjanjePredmeta);
	}
}
