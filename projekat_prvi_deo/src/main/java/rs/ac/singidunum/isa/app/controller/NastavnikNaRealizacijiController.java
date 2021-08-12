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

import rs.ac.singidunum.isa.app.dto.NastavnikNaRealizacijiDTO;
import rs.ac.singidunum.isa.app.model.NastavnikNaRealizaciji;
import rs.ac.singidunum.isa.app.service.NastavnikNaRealizacijiService;

@Controller
@RequestMapping(path = "/api/nastavnicinarealizaciji")
public class NastavnikNaRealizacijiController {
	
	@Autowired
	NastavnikNaRealizacijiService nastavnikNaRealizacijiService;
	
	
	public ResponseEntity<Iterable<NastavnikNaRealizacijiDTO>> getAllNastavnikNaRealizaciji() {
		ArrayList<NastavnikNaRealizacijiDTO> nastavnici = new ArrayList<NastavnikNaRealizacijiDTO>();
		for(NastavnikNaRealizaciji nastavnik : nastavnikNaRealizacijiService.findAll()) {
			nastavnici.add(new NastavnikNaRealizacijiDTO(nastavnik.getId(), nastavnik.getBrojCasova())); 
			
		}
		return new ResponseEntity<Iterable<NastavnikNaRealizacijiDTO>> (nastavnici, HttpStatus.OK);
	}
	
	// Get zvanje
	@RequestMapping(path = "/{nastavnikNaRealizacijiId}", method = RequestMethod.GET)
	public ResponseEntity<NastavnikNaRealizacijiDTO> getNastavnik(@PathVariable("nastavnikNaRealizacijiId") Long nastavnikNaRealizacijiId){
		Optional<NastavnikNaRealizaciji> nastavnikNaRealizaciji = nastavnikNaRealizacijiService.findOne(nastavnikNaRealizacijiId);
		
		NastavnikNaRealizacijiDTO nastavnikNaRealizacijiDTO;
		
		if (nastavnikNaRealizaciji.isPresent()) {
			nastavnikNaRealizacijiDTO = new NastavnikNaRealizacijiDTO();
			return new ResponseEntity<NastavnikNaRealizacijiDTO>(nastavnikNaRealizacijiDTO, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikNaRealizacijiDTO> (HttpStatus.NOT_FOUND);
	}
	
	// Create zvanje
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<NastavnikNaRealizaciji> createNastavnikNaRealizaciji(@RequestBody NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		try {
			nastavnikNaRealizacijiService.save(nastavnikNaRealizaciji);
			return new ResponseEntity<NastavnikNaRealizaciji>(nastavnikNaRealizaciji, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.BAD_REQUEST);
	}
	
	// Update zvanje
	@RequestMapping(path = "/{nastavnikNaRealizacijiId}", method = RequestMethod.PUT)
	public ResponseEntity<NastavnikNaRealizaciji> updateNastavnikNaRealizaciji(@PathVariable("nastavnikNaRealizacijiId") Long nastavnikNaRealizacijiId,
			@RequestBody NastavnikNaRealizaciji izmenjenNastavnikNaRealizaciji) {
		NastavnikNaRealizaciji nastavnikNaRealizaciji = nastavnikNaRealizacijiService.findOne(nastavnikNaRealizacijiId).orElse(null);
		if (nastavnikNaRealizaciji  != null) {
			izmenjenNastavnikNaRealizaciji.setId(nastavnikNaRealizacijiId);
			izmenjenNastavnikNaRealizaciji = nastavnikNaRealizacijiService.save(izmenjenNastavnikNaRealizaciji);
			return new ResponseEntity<NastavnikNaRealizaciji>(izmenjenNastavnikNaRealizaciji, HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NOT_FOUND);
	}
	
	// Delete zvanje
	
	@RequestMapping(path = "/{nastavnikNaRealizacijiId}", method = RequestMethod.DELETE)
	public ResponseEntity<NastavnikNaRealizaciji> deleteZvanje(@PathVariable("nastavnikNaRealizacijiId") Long nastavnikNaRealizacijiId) {
		if (nastavnikNaRealizacijiService.findOne(nastavnikNaRealizacijiId).isPresent()) {
			nastavnikNaRealizacijiService.delete(nastavnikNaRealizacijiId);
			return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.OK);
		}
		return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NOT_FOUND);
	}
}
