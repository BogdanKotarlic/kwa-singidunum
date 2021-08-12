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
import rs.ac.singidunum.isa.app.dto.FakultetDTO;
import rs.ac.singidunum.isa.app.dto.StudijskiProgramDTO;
import rs.ac.singidunum.isa.app.model.Fakultet;
import rs.ac.singidunum.isa.app.model.StudijskiProgram;
import rs.ac.singidunum.isa.app.service.FakultetService;

@Controller
@RequestMapping(path = "/api/fakulteti")
public class FakultetController {
	
	@Autowired
	FakultetService fakultetService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<FakultetDTO>> getAllFakulteti() {
		
		ArrayList<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
		for(Fakultet fakultet : fakultetService.findAll()) {
			
			ArrayList<StudijskiProgramDTO> studijskiProgrami = new ArrayList<StudijskiProgramDTO>();
			for(StudijskiProgram studijskiProgram : fakultet.getStudijskiProgram()) {
				studijskiProgrami.add(new StudijskiProgramDTO(studijskiProgram.getId(), studijskiProgram.getNaziv()));
			}
			
			fakulteti.add(new FakultetDTO(fakultet.getId(), fakultet.getNaziv(), null, null, studijskiProgrami,null));
		}
		return new ResponseEntity<Iterable<FakultetDTO>>(fakulteti, HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/{fakultetId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<FakultetDTO> getFakultet(@PathVariable("fakultetId") Long fakultetId) {
		Optional<Fakultet> fakultet = fakultetService.findOne(fakultetId);

		FakultetDTO fakultetDTO;

		if (fakultet.isPresent()) {
			fakultetDTO = new FakultetDTO(fakultet.get().getId(), fakultet.get().getNaziv());
			return new ResponseEntity<FakultetDTO>(fakultetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<FakultetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Fakultet> createFakultet(@RequestBody Fakultet fakultet) {
		try {
			fakultetService.save(fakultet);
			return new ResponseEntity<Fakultet>(fakultet, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Fakultet>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{fakultetId}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Fakultet> updateFakultet(@PathVariable("fakultetId") Long fakultetId,
			@RequestBody Fakultet izmenjeniFakultet) {
		Fakultet fakultet = fakultetService.findOne(fakultetId).orElse(null);
		if (fakultet != null) {
			izmenjeniFakultet.setId(fakultetId);
			izmenjeniFakultet = fakultetService.save(izmenjeniFakultet);
			return new ResponseEntity<Fakultet>(izmenjeniFakultet, HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{fakultetId}", method = RequestMethod.DELETE)
	public ResponseEntity<Fakultet> deleteFakultet(@PathVariable("fakultetId") Long fakultetId) {
		if (fakultetService.findOne(fakultetId).isPresent()) {
			fakultetService.delete(fakultetId);
			return new ResponseEntity<Fakultet>(HttpStatus.OK);
		}
		return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
	}
	
}
