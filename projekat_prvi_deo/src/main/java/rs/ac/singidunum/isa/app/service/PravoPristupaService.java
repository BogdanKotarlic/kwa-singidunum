package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.PravoPristupa;
import rs.ac.singidunum.isa.app.repository.PravoPristupaRepository;

@Service
public class PravoPristupaService {
	
	@Autowired
	private PravoPristupaRepository pravoPristupaRepository;
	
	public Iterable<PravoPristupa> findAll(){
		return pravoPristupaRepository.findAll();
	}
	
	public Optional<PravoPristupa> findOne(Long id) {
		return pravoPristupaRepository.findById(id);
	}
	
	public PravoPristupa save(PravoPristupa pravoPristupa) {
		return pravoPristupaRepository.save(pravoPristupa);
	}
	
	public void delete(Long id) {
		pravoPristupaRepository.deleteById(id);
	}
	
	public void delete(PravoPristupa pravoPristupa) {
		pravoPristupaRepository.delete(pravoPristupa);
	}
	
}
