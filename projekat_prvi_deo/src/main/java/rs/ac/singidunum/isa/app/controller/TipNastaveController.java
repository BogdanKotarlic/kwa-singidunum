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

import rs.ac.singidunum.isa.app.dto.TipNastaveDTO;
import rs.ac.singidunum.isa.app.model.TipNastave;
import rs.ac.singidunum.isa.app.service.TipNastaveService;

@Controller
@RequestMapping(path = "/api/tipovinastave")
public class TipNastaveController {

	@Autowired
	TipNastaveService tipNastaveService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<TipNastaveDTO>> getAllTipoviNastave() {
		ArrayList<TipNastaveDTO> tipoviNastave = new ArrayList<TipNastaveDTO>();
		for(TipNastave tipNastave : tipNastaveService.findAll()) {
			tipoviNastave.add(new TipNastaveDTO(tipNastave.getId(), tipNastave.getNaziv()));
		}
		return new ResponseEntity<Iterable<TipNastaveDTO>>(tipoviNastave, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{tipId}", method = RequestMethod.GET)
	public ResponseEntity<TipNastaveDTO> GetTipNastave(@PathVariable("tipId") Long tipId) {
		Optional<TipNastave> tipNastave = tipNastaveService.findOne(tipId);

		TipNastaveDTO tipNastaveDTO;

		if (tipNastave.isPresent()) {
			tipNastaveDTO = new TipNastaveDTO(tipNastave.get().getId(), tipNastave.get().getNaziv());
			return new ResponseEntity<TipNastaveDTO>(tipNastaveDTO, HttpStatus.OK);
		}
		return new ResponseEntity<TipNastaveDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<TipNastave> createTipNastave(@RequestBody TipNastave tipNastave) {
		try {
			tipNastaveService.save(tipNastave);
			return new ResponseEntity<TipNastave>(tipNastave, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<TipNastave>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{tipId}", method = RequestMethod.PUT)
	public ResponseEntity<TipNastave> updateTipNastave(@PathVariable("tipId") Long tipId,
			@RequestBody TipNastave izmenjenTipNastave) {
		TipNastave tipNastave = tipNastaveService.findOne(tipId).orElse(null);
		if (tipNastave != null) {
			izmenjenTipNastave.setId(tipId);
			izmenjenTipNastave = tipNastaveService.save(izmenjenTipNastave);
			return new ResponseEntity<TipNastave>(izmenjenTipNastave, HttpStatus.OK);
		}
		return new ResponseEntity<TipNastave>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{tipId}", method = RequestMethod.DELETE)
	public ResponseEntity<TipNastave> deleteTipNastave(@PathVariable("tipId") Long tipId) {
		if (tipNastaveService.findOne(tipId).isPresent()) {
			tipNastaveService.delete(tipId);
			return new ResponseEntity<TipNastave>(HttpStatus.OK);
		}
		return new ResponseEntity<TipNastave>(HttpStatus.NOT_FOUND);
	}
}
