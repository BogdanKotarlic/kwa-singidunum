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
import rs.ac.singidunum.isa.app.dto.MestoDTO;
import rs.ac.singidunum.isa.app.model.Adresa;
import rs.ac.singidunum.isa.app.model.Mesto;
import rs.ac.singidunum.isa.app.service.AdresaService;

@Controller
@RequestMapping(path = "/api/adrese")
public class AdresaController {
	
	@Autowired
	AdresaService adresaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<AdresaDTO>> getAllAdrese() {
		ArrayList<AdresaDTO> adrese = new ArrayList<AdresaDTO>();
		for(Adresa adresa : adresaService.findAll()) {
			ArrayList<MestoDTO> mesta = new ArrayList<MestoDTO>();
			for(Mesto mesto : adresa.getMesta()) {
				mesta.add(new MestoDTO(mesto.getId(), mesto.getNaziv(), mesto.getDrzava()));
			}
			
			
			adrese.add(new AdresaDTO(adresa.getId(), adresa.getUlica(), adresa.getBroj(), null, null, null, null, mesta));
		}
		return new ResponseEntity<Iterable<AdresaDTO>>(adrese, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{adresaId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<AdresaDTO> getAdresa(@PathVariable("adresaId") Long adresaId) {
		Optional<Adresa> adresa = adresaService.findOne(adresaId);

		AdresaDTO adresaDTO;

		if (adresa.isPresent()) {
			adresaDTO = new AdresaDTO(adresa.get().getId(), adresa.get().getUlica(), adresa.get().getBroj());
			return new ResponseEntity<AdresaDTO>(adresaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<AdresaDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Adresa> createAdresa(@RequestBody Adresa adresa) {
		try {
			adresaService.save(adresa);
			return new ResponseEntity<Adresa>(adresa, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Adresa>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{adresaId}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Adresa> updateAdresa(@PathVariable("adresaId") Long adresaId,
			@RequestBody Adresa izmenjenaAdresa) {
		Adresa adresa = adresaService.findOne(adresaId).orElse(null);
		if (adresa != null) {
			izmenjenaAdresa.setId(adresaId);
			izmenjenaAdresa = adresaService.save(izmenjenaAdresa);
			return new ResponseEntity<Adresa>(izmenjenaAdresa, HttpStatus.OK);
		}
		return new ResponseEntity<Adresa>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{adresaId}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Adresa> deleteAdresa(@PathVariable("adresaId") Long adresaId) {
		if (adresaService.findOne(adresaId).isPresent()) {
			adresaService.delete(adresaId);
			return new ResponseEntity<Adresa>(HttpStatus.OK);
		}
		return new ResponseEntity<Adresa>(HttpStatus.NOT_FOUND);
	}
	
}
