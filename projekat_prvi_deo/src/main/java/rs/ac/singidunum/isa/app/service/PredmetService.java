package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Predmet;
import rs.ac.singidunum.isa.app.repository.PredmetRepository;

@Service
public class PredmetService {
	
	@Autowired
	private PredmetRepository predmetRepository;
	
	public Iterable<Predmet> findAll(){
		return predmetRepository.findAll();
	}
	
	public Optional<Predmet> findOne(Long id) {
		return predmetRepository.findById(id);
	}
	
	public Predmet save(Predmet predmet) {
		return predmetRepository.save(predmet);
	}
	
	public void delete(Long id) {
		predmetRepository.deleteById(id);
	}
	
	public void delete(Predmet predmet) {
		predmetRepository.delete(predmet);
	}
}
