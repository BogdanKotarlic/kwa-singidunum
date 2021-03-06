package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.NastavnikNaRealizaciji;
import rs.ac.singidunum.isa.app.repository.NastavnikNaRealizacijiRepository;

@Service
public class NastavnikNaRealizacijiService {
	
	@Autowired
	private NastavnikNaRealizacijiRepository nastavnikNaRealizacijiRepository;
	
	public Iterable<NastavnikNaRealizaciji> findAll(){
		return nastavnikNaRealizacijiRepository.findAll();
	}
	
	public Optional<NastavnikNaRealizaciji> findOne(Long id) {
		return nastavnikNaRealizacijiRepository.findById(id);
	}
	
	public NastavnikNaRealizaciji save(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		return nastavnikNaRealizacijiRepository.save(nastavnikNaRealizaciji);
	}
	
	public void delete(Long id) {
		nastavnikNaRealizacijiRepository.deleteById(id);
	}
	
	public void delete(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		nastavnikNaRealizacijiRepository.delete(nastavnikNaRealizaciji);
	}
	
	
}