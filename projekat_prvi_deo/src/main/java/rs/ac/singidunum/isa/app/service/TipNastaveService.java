package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.TipNastave;
import rs.ac.singidunum.isa.app.repository.TipNastaveRepository;

@Service
public class TipNastaveService {
	
	@Autowired
	private TipNastaveRepository tipNastaveRepository;
	
	public Iterable<TipNastave> findAll(){
		return tipNastaveRepository.findAll();
	}
	
	public Optional<TipNastave> findOne(Long id) {
		return tipNastaveRepository.findById(id);
	}
	
	public TipNastave save(TipNastave tipNastave) {
		return tipNastaveRepository.save(tipNastave);
	}
	
	public void delete(Long id) {
		tipNastaveRepository.deleteById(id);
	}
	
	public void delete(TipNastave tipNastave) {
		tipNastaveRepository.delete(tipNastave);
	}
	
	
}
