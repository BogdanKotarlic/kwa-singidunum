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

import rs.ac.singidunum.isa.app.dto.AdresaDTO;
import rs.ac.singidunum.isa.app.dto.FakultetDTO;
import rs.ac.singidunum.isa.app.dto.MestoDTO;
import rs.ac.singidunum.isa.app.dto.UniverzitetDTO;
import rs.ac.singidunum.isa.app.model.Univerzitet;
import rs.ac.singidunum.isa.app.model.Adresa;
import rs.ac.singidunum.isa.app.model.Fakultet;
import rs.ac.singidunum.isa.app.model.Mesto;
import rs.ac.singidunum.isa.app.service.UniverzitetService;

@Controller
@RequestMapping(path = "/api/univerziteti")
public class UniverzitetController {
	
	@Autowired
	UniverzitetService univerzitetService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<UniverzitetDTO>> getAllUniverziteti() {
		
		ArrayList<UniverzitetDTO> univerziteti = new ArrayList<UniverzitetDTO>();
		for(Univerzitet univerzitet : univerzitetService.findAll()) {
			ArrayList<AdresaDTO> adrese = new ArrayList<AdresaDTO>();
			
			for(Adresa adresa : univerzitet.getAdrese()) {
				ArrayList<MestoDTO> mesta = new ArrayList<MestoDTO>();
				for(Mesto mesto : adresa.getMesta()) {
					mesta.add(new MestoDTO(mesto.getId(), mesto.getNaziv(), mesto.getDrzava()));
				}

				adrese.add(new AdresaDTO(adresa.getId(), adresa.getUlica(), adresa.getBroj(),null, null, null, null, mesta));
			}
			
			ArrayList<FakultetDTO> fakulteti = new ArrayList<FakultetDTO>();
			for(Fakultet fakultet : univerzitet.getFakultet()) {
				fakulteti.add(new FakultetDTO(fakultet.getId(), fakultet.getNaziv()));
				
			}
			
			univerziteti.add(new UniverzitetDTO(univerzitet.getId(), univerzitet.getNaziv(), univerzitet.getDatumOsnivanja(), adrese, fakulteti));
		}
		return new ResponseEntity<Iterable<UniverzitetDTO>>(univerziteti, HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/{univerzitetId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<UniverzitetDTO> getUniverzitet(@PathVariable("univerzitetId") Long univerzitetId) {
		Optional<Univerzitet> univerzitet = univerzitetService.findOne(univerzitetId);

		UniverzitetDTO univerzitetDTO;

		if (univerzitet.isPresent()) {
			univerzitetDTO = new UniverzitetDTO(univerzitet.get().getId(), univerzitet.get().getNaziv(), univerzitet.get().getDatumOsnivanja());
			return new ResponseEntity<UniverzitetDTO>(univerzitetDTO, HttpStatus.OK);
		}
		return new ResponseEntity<UniverzitetDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Univerzitet> createUniverzitet(@RequestBody Univerzitet univerzitet) {
		try {
			univerzitetService.save(univerzitet);
			return new ResponseEntity<Univerzitet>(univerzitet, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{univerzitetId}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Univerzitet> updateUniverzitet(@PathVariable("univerzitetId") Long univerzitetId,
			@RequestBody Univerzitet izmenjeniUniverzitet) {
		Univerzitet univerzitet = univerzitetService.findOne(univerzitetId).orElse(null);
		if (univerzitet != null) {
			izmenjeniUniverzitet.setId(univerzitetId);
			izmenjeniUniverzitet = univerzitetService.save(izmenjeniUniverzitet);
			return new ResponseEntity<Univerzitet>(izmenjeniUniverzitet, HttpStatus.OK);
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{univerzitetId}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Univerzitet> deleteUniverzitet(@PathVariable("univerzitetId") Long univerzitetId) {
		if (univerzitetService.findOne(univerzitetId).isPresent()) {
			univerzitetService.delete(univerzitetId);
			return new ResponseEntity<Univerzitet>(HttpStatus.OK);
		}
		return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
	}
	
}
