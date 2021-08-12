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

import rs.ac.singidunum.isa.app.dto.NaucnaOblastDTO;
import rs.ac.singidunum.isa.app.model.NaucnaOblast;
import rs.ac.singidunum.isa.app.service.NaucnaOblastService;


@Controller
@RequestMapping(path = "/api/naucneoblasti")
public class NaucnaOblastController {
	
	@Autowired
	NaucnaOblastService naucnaOblastService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<NaucnaOblastDTO>> getAllNaucneOblasti() {
		ArrayList<NaucnaOblastDTO> naucneOblasti = new ArrayList<NaucnaOblastDTO>();
		for(NaucnaOblast naucnaOblast : naucnaOblastService.findAll()) {
			naucneOblasti.add(new NaucnaOblastDTO(naucnaOblast.getId(), naucnaOblast.getNaziv()));
		}
		return new ResponseEntity<Iterable<NaucnaOblastDTO>>(naucneOblasti, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{oblastID}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NaucnaOblastDTO> getNaucnaOblast(@PathVariable("oblastID") Long oblastID) {
		Optional<NaucnaOblast> naucnaOblast = naucnaOblastService.findOne(oblastID);

		NaucnaOblastDTO naucnaOblastDTO;

		if (naucnaOblast.isPresent()) {
			naucnaOblastDTO = new NaucnaOblastDTO(naucnaOblast.get().getId(), naucnaOblast.get().getNaziv());
			return new ResponseEntity<NaucnaOblastDTO>(naucnaOblastDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NaucnaOblastDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NaucnaOblast> createNaucnaOblast(@RequestBody NaucnaOblast naucnaOblast) {
		try {
			naucnaOblastService.save(naucnaOblast);
			return new ResponseEntity<NaucnaOblast>(naucnaOblast, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<NaucnaOblast>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{oblastID}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NaucnaOblast> updateNaucnaOblast(@PathVariable("oblastID") Long oblastID,
			@RequestBody NaucnaOblast izmenjenaNaucnaOblast) {
		NaucnaOblast naucnaOblast = naucnaOblastService.findOne(oblastID).orElse(null);
		if (naucnaOblast != null) {
			izmenjenaNaucnaOblast.setId(oblastID);
			izmenjenaNaucnaOblast = naucnaOblastService.save(izmenjenaNaucnaOblast);
			return new ResponseEntity<NaucnaOblast>(izmenjenaNaucnaOblast, HttpStatus.OK);
		}
		return new ResponseEntity<NaucnaOblast>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{oblastID}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<NaucnaOblast> deleteNaucnaOblast(@PathVariable("oblastID") Long oblastID) {
		if (naucnaOblastService.findOne(oblastID).isPresent()) {
			naucnaOblastService.delete(oblastID);
			return new ResponseEntity<NaucnaOblast>(HttpStatus.OK);
		}
		return new ResponseEntity<NaucnaOblast>(HttpStatus.NOT_FOUND);
	}
	
}
