package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.NaucnaOblast;
import rs.ac.singidunum.isa.app.repository.NaucnaOblastRepository;

@Service
public class NaucnaOblastService {
	
	@Autowired
	private NaucnaOblastRepository naucnaOblastRepository;
	
	public Iterable<NaucnaOblast> findAll(){
		return naucnaOblastRepository.findAll();
	}
	
	public Optional<NaucnaOblast> findOne(Long id) {
		return naucnaOblastRepository.findById(id);
	}
	
	public NaucnaOblast save(NaucnaOblast naucnaOblast) {
		return naucnaOblastRepository.save(naucnaOblast);
	}
	
	public void delete(Long id) {
		naucnaOblastRepository.deleteById(id);
	}
	
	public void delete(NaucnaOblast naucnaOblast) {
		naucnaOblastRepository.delete(naucnaOblast);
	}
	
}
