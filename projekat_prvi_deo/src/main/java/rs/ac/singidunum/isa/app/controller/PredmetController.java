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


import rs.ac.singidunum.isa.app.dto.PredmetDTO;
import rs.ac.singidunum.isa.app.model.Predmet;
import rs.ac.singidunum.isa.app.service.PredmetService;

@Controller
@RequestMapping(path = "/api/predmeti")
public class PredmetController {
	
	@Autowired
	PredmetService predmetService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured({"ROLE_STUDENT", "ROLE_NASTAVNIK"})
	public ResponseEntity<Iterable<PredmetDTO>> getAllPredmeti() {
		ArrayList<PredmetDTO> predmeti = new ArrayList<PredmetDTO>();
		for(Predmet predmet : predmetService.findAll()) {
			predmeti.add(new PredmetDTO(predmet.getId(), predmet.getNaziv(), 
					predmet.getEspb(), predmet.isObavezan(), 
					predmet.getBrojPredavanja(), predmet.getBrojVezbi(), 
					predmet.getDrugiObliciNastave(),
					predmet.getIstrazivackiRad(), predmet.getOstaliCasovi()
					));
			
			
		}
		return new ResponseEntity<Iterable<PredmetDTO>> (predmeti, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{predmetId}", method = RequestMethod.GET)
	@Secured({"ROLE_STUDENT", "ROLE_NASTAVNIK"})
	public ResponseEntity<PredmetDTO> getPredmet(@PathVariable("predmetId") Long predmetId){
		Optional<Predmet> predmet = predmetService.findOne(predmetId);
		
		PredmetDTO predmetDTO;
		
		if (predmet.isPresent()) {
			predmetDTO = new PredmetDTO(predmet.get().getId(), predmet.get().getNaziv(), 
					predmet.get().getEspb(), predmet.get().isObavezan(), 
					predmet.get().getBrojPredavanja(), predmet.get().getBrojVezbi(), 
					predmet.get().getDrugiObliciNastave(),
					predmet.get().getIstrazivackiRad(), predmet.get().getOstaliCasovi()
					);
			return new ResponseEntity<PredmetDTO>(predmetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<PredmetDTO> (HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Predmet> createPredmet(@RequestBody Predmet predmet) {
		try {
			predmetService.save(predmet);
			return new ResponseEntity<Predmet>(predmet, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Predmet>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{predmetId}", method = RequestMethod.PUT)
	public ResponseEntity<Predmet> updatePredmet(@PathVariable("predmetId") Long predmetId,
			@RequestBody Predmet izmenjenPredmet) {
		Predmet predmet = predmetService.findOne(predmetId).orElse(null);
		if (predmet != null) {
			izmenjenPredmet.setId(predmetId);
			izmenjenPredmet = predmetService.save(izmenjenPredmet);
			return new ResponseEntity<Predmet>(izmenjenPredmet, HttpStatus.OK);
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{predmetId}", method = RequestMethod.DELETE)
	public ResponseEntity<Predmet> deletePredmet(@PathVariable("predmetId") Long predmetId) {
		if (predmetService.findOne(predmetId).isPresent()) {
			predmetService.delete(predmetId);
			return new ResponseEntity<Predmet>(HttpStatus.OK);
		}
		return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
	}
}
