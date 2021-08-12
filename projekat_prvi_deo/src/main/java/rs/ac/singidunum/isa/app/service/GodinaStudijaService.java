package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.GodinaStudija;
import rs.ac.singidunum.isa.app.repository.GodinaStudijaRepository;

@Service
public class GodinaStudijaService {
	
	@Autowired
	private GodinaStudijaRepository godinaStudijaRepository;
	
	public Iterable<GodinaStudija> findAll(){
		return godinaStudijaRepository.findAll();
	}
	
	public Optional<GodinaStudija> findOne(Long id) {
		return godinaStudijaRepository.findById(id);
	}
	
	public GodinaStudija save(GodinaStudija godinaStudija) {
		return godinaStudijaRepository.save(godinaStudija);
	}
	
	public void delete(GodinaStudija godinaStudija) {
		godinaStudijaRepository.delete(godinaStudija);
	}
	
	public void delete(Long id) {
		godinaStudijaRepository.deleteById(id);
	}
	
}
