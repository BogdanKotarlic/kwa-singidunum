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

import rs.ac.singidunum.isa.app.dto.GodinaStudijaDTO;
import rs.ac.singidunum.isa.app.model.GodinaStudija;
import rs.ac.singidunum.isa.app.service.GodinaStudijaService;

@Controller
@RequestMapping(path = "/api/godinestudija")
public class GodinaStudijaController {
	
	@Autowired
	GodinaStudijaService godinaStudijaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<GodinaStudijaDTO>> getAllGodineStudija() {
		
		ArrayList<GodinaStudijaDTO> godineStudija = new ArrayList<GodinaStudijaDTO>();
		for(GodinaStudija godinaStudija : godinaStudijaService.findAll()) {
			godineStudija.add(new GodinaStudijaDTO(godinaStudija.getId(), godinaStudija.getGodina()));
		}
		return new ResponseEntity<Iterable<GodinaStudijaDTO>>(godineStudija, HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/{godinastudijaId}", method = RequestMethod.GET)
	public ResponseEntity<GodinaStudijaDTO> getGodinaStudija(@PathVariable("godinastudijaId") Long godinastudijaId) {
		Optional<GodinaStudija> godinaStudija = godinaStudijaService.findOne(godinastudijaId);

		GodinaStudijaDTO godinaStudijaDTO;

		if (godinaStudija.isPresent()) {
			godinaStudijaDTO = new GodinaStudijaDTO(godinaStudija.get().getId(), godinaStudija.get().getGodina());
			return new ResponseEntity<GodinaStudijaDTO>(godinaStudijaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<GodinaStudijaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<GodinaStudija> createGodinaStudija(@RequestBody GodinaStudija godinaStudija) {
		try {
			godinaStudijaService.save(godinaStudija);
			return new ResponseEntity<GodinaStudija>(godinaStudija, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<GodinaStudija>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{godinastudijaId}", method = RequestMethod.PUT)
	public ResponseEntity<GodinaStudija> updateGodinaStudija(@PathVariable("godinastudijaId") Long godinastudijaId,
			@RequestBody GodinaStudija izmenjenaGodinaStudija) {
		GodinaStudija godinaStudija = godinaStudijaService.findOne(godinastudijaId).orElse(null);
		if (godinaStudija != null) {
			izmenjenaGodinaStudija.setId(godinastudijaId);
			izmenjenaGodinaStudija = godinaStudijaService.save(izmenjenaGodinaStudija);
			return new ResponseEntity<GodinaStudija>(izmenjenaGodinaStudija, HttpStatus.OK);
		}
		return new ResponseEntity<GodinaStudija>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{godinastudijaId}", method = RequestMethod.DELETE)
	public ResponseEntity<GodinaStudija> deleteGodinaStudija(@PathVariable("godinastudijaId") Long godinastudijaId) {
		if (godinaStudijaService.findOne(godinastudijaId).isPresent()) {
			godinaStudijaService.delete(godinastudijaId);
			return new ResponseEntity<GodinaStudija>(HttpStatus.OK);
		}
		return new ResponseEntity<GodinaStudija>(HttpStatus.NOT_FOUND);
	}
	
}
