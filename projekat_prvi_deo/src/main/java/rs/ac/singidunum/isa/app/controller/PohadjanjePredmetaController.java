package rs.ac.singidunum.isa.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.isa.app.dto.PohadjanjePredmetaDTO;
import rs.ac.singidunum.isa.app.model.PohadjanjePredmeta;
import rs.ac.singidunum.isa.app.service.PohadjanjePredmetaService;

@Controller
@RequestMapping(path = "/api/pohadjanjepredmeta")
public class PohadjanjePredmetaController {
	
	@Autowired
	PohadjanjePredmetaService pohadjanjePredmetaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<PohadjanjePredmetaDTO>> getAllPohadjanjePredmeta() {
		ArrayList<PohadjanjePredmetaDTO> predmeti = new ArrayList<PohadjanjePredmetaDTO>();
		for(PohadjanjePredmeta predmet : pohadjanjePredmetaService.findAll()) {
			predmeti.add(new PohadjanjePredmetaDTO(predmet.getId(), predmet.getKonacnaOcena()));
			
		}
		return new ResponseEntity<Iterable<PohadjanjePredmetaDTO>> (predmeti, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{pohadjanjeId}", method = RequestMethod.GET)
	public ResponseEntity<PohadjanjePredmetaDTO> getPohadjanjePredmeta(@PathVariable("pohadjanjeId") Long pohadjanjeId){
		Optional<PohadjanjePredmeta> predmet = pohadjanjePredmetaService.findOne(pohadjanjeId);
		
		PohadjanjePredmetaDTO predmetDTO;
		
		if (predmet.isPresent()) {
			predmetDTO = new PohadjanjePredmetaDTO(predmet.get().getId(), predmet.get().getKonacnaOcena());
			return new ResponseEntity<PohadjanjePredmetaDTO>(predmetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<PohadjanjePredmetaDTO> (HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<PohadjanjePredmeta> createPohadjanjePredmeta(@RequestBody PohadjanjePredmeta predmet) {
		try {
			pohadjanjePredmetaService.save(predmet);
			return new ResponseEntity<PohadjanjePredmeta>(predmet, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{pohadjanjeId}", method = RequestMethod.PUT)
	public ResponseEntity<PohadjanjePredmeta> updatePohadjanjePredmeta(@PathVariable("pohadjanjeId") Long pohadjanjeId,
			@RequestBody PohadjanjePredmeta izmenjenPohadjanjePredmeta) {
		PohadjanjePredmeta predmet = pohadjanjePredmetaService.findOne(pohadjanjeId).orElse(null);
		if (predmet != null) {
			izmenjenPohadjanjePredmeta.setId(pohadjanjeId);
			izmenjenPohadjanjePredmeta = pohadjanjePredmetaService.save(izmenjenPohadjanjePredmeta);
			return new ResponseEntity<PohadjanjePredmeta>(izmenjenPohadjanjePredmeta, HttpStatus.OK);
		}
		return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "/{pohadjanjeId}", method = RequestMethod.DELETE)
	public ResponseEntity<PohadjanjePredmeta> deletePohadjanjePredmeta(@PathVariable("pohadjanjeId") Long pohadjanjeId) {
		if (pohadjanjePredmetaService.findOne(pohadjanjeId).isPresent()) {
			pohadjanjePredmetaService.delete(pohadjanjeId);
			return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.OK);
		}
		return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NOT_FOUND);
	}
}
