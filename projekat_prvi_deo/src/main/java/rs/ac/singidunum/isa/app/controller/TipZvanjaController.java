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

import rs.ac.singidunum.isa.app.dto.TipZvanjaDTO;
import rs.ac.singidunum.isa.app.model.TipZvanja;
import rs.ac.singidunum.isa.app.service.TipZvanjaService;

@Controller
@RequestMapping(path = "/api/tipovizvanja")
public class TipZvanjaController {
	
	@Autowired
	TipZvanjaService tipZvanjaService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TipZvanjaDTO>> getAllTipZvanja() {
		ArrayList<TipZvanjaDTO> tipovi = new ArrayList<TipZvanjaDTO>();
		for(TipZvanja tipZvanja: tipZvanjaService.findAll()) {
			tipovi.add(new TipZvanjaDTO(tipZvanja.getId(), tipZvanja.getNaziv()));
		}
		return new ResponseEntity<Iterable<TipZvanjaDTO>>(tipovi, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{tipZvanjaId}", method = RequestMethod.GET)
	public ResponseEntity<TipZvanjaDTO> getTipZvanja(@PathVariable("tipZvanjaId") Long TipZvanjaId){
		Optional<TipZvanja> tipZvanja = tipZvanjaService.findOne(TipZvanjaId);
			
		TipZvanjaDTO tipZvanjaDTO;
			
		if (tipZvanja.isPresent()) {
			tipZvanjaDTO = new TipZvanjaDTO(tipZvanja.get().getId(), tipZvanja.get().getNaziv());
			return new ResponseEntity<TipZvanjaDTO>(tipZvanjaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<TipZvanjaDTO> (HttpStatus.NOT_FOUND);
	}
		
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<TipZvanja> createTipZvanja(@RequestBody TipZvanja tipZvanja) {
		try {
			tipZvanjaService.save(tipZvanja);
			return new ResponseEntity<TipZvanja>(tipZvanja, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<TipZvanja>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{tipZvanjaId}", method = RequestMethod.PUT)
	public ResponseEntity<TipZvanja> updateTipZvanja(@PathVariable("tipZvanjaId") Long tipZvanjaId,
			@RequestBody TipZvanja izmenjenTipZvanja) {
		TipZvanja tipZvanja = tipZvanjaService.findOne(tipZvanjaId).orElse(null);
		if (tipZvanja != null) {
			izmenjenTipZvanja.setId(tipZvanjaId);
			izmenjenTipZvanja = tipZvanjaService.save(izmenjenTipZvanja);
			return new ResponseEntity<TipZvanja>(izmenjenTipZvanja, HttpStatus.OK);
		}
		return new ResponseEntity<TipZvanja>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{tipZvanjaId}", method = RequestMethod.DELETE)
	public ResponseEntity<TipZvanja> deleteTipZvanja(@PathVariable("tipZvanjaId") Long tipZvanjaId) {
		if (tipZvanjaService.findOne(tipZvanjaId).isPresent()) {
			tipZvanjaService.delete(tipZvanjaId);
			return new ResponseEntity<TipZvanja>(HttpStatus.OK);
		}
		return new ResponseEntity<TipZvanja>(HttpStatus.NOT_FOUND);
	}
}
