package rs.ac.singidunum.isa.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.isa.app.dto.NastavnikDTO;
import rs.ac.singidunum.isa.app.model.Nastavnik;
import rs.ac.singidunum.isa.app.service.NastavnikService;

@Controller
@RequestMapping(path = "/api/nastavnici")
public class NastavnikController {
	
	@Autowired
	NastavnikService nastavnikService;

	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<NastavnikDTO>> getAllNastavnik() {
		ArrayList<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();
		for(Nastavnik nastavnik : nastavnikService.findAll()) {
			nastavnici.add(new NastavnikDTO(nastavnik.getId(), nastavnik.getIme(), nastavnik.getBiografija(), nastavnik.getJmbg()));
			
		}
		return new ResponseEntity<Iterable<NastavnikDTO>> (nastavnici, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{nastavnikId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NastavnikDTO> getNastavnik(@PathVariable("nastavnikId") Long nastavnikId){
		Optional<Nastavnik> nastavnik = nastavnikService.findOne(nastavnikId);
		
		NastavnikDTO nastavnikDTO;
		
		if (nastavnik.isPresent()) {
			nastavnikDTO = new NastavnikDTO(nastavnik.get().getId(), nastavnik.get().getIme(), nastavnik.get().getBiografija(), nastavnik.get().getJmbg());
			return new ResponseEntity<NastavnikDTO>(nastavnikDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikDTO> (HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Nastavnik> createNastavnik(@RequestBody Nastavnik nastavnik) {
		try {
			nastavnikService.save(nastavnik);
			return new ResponseEntity<Nastavnik>(nastavnik, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{nastavnikId}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Nastavnik> updateNastavnik(@PathVariable("nastavnikId") Long nastavnikId,
			@RequestBody Nastavnik izmenjenNastavnik) {
		Nastavnik nastavnik = nastavnikService.findOne(nastavnikId).orElse(null);
		if (nastavnik != null) {
			izmenjenNastavnik.setId(nastavnikId);
			izmenjenNastavnik = nastavnikService.save(izmenjenNastavnik);
			return new ResponseEntity<Nastavnik>(izmenjenNastavnik, HttpStatus.OK);
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{nastavnikId}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Nastavnik> deleteNastavnik(@PathVariable("nastavnikId") Long nastavnikId) {
		if (nastavnikService.findOne(nastavnikId).isPresent()) {
			nastavnikService.delete(nastavnikId);
			return new ResponseEntity<Nastavnik>(HttpStatus.OK);
		}
		return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
	}
}