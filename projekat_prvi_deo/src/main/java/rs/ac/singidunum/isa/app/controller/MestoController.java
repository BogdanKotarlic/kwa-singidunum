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

import rs.ac.singidunum.isa.app.dto.MestoDTO;
import rs.ac.singidunum.isa.app.model.Mesto;
import rs.ac.singidunum.isa.app.service.MestoService;

@Controller
@RequestMapping(path = "/api/mesta")
public class MestoController {
	
	@Autowired
	MestoService mestoService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<MestoDTO>> getAllMesta() {
		ArrayList<MestoDTO> mesta = new ArrayList<MestoDTO>();
		for(Mesto mesto : mestoService.findAll()) {
			mesta.add(new MestoDTO(mesto.getId(), mesto.getNaziv(), mesto.getDrzava()));
		}
		return new ResponseEntity<Iterable<MestoDTO>>(mesta, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{mestoId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<MestoDTO> getMesto(@PathVariable("mestoId") Long mestoId) {
		Optional<Mesto> mesto = mestoService.findOne(mestoId);

		MestoDTO mestoDTO;

		if (mesto.isPresent()) {
			mestoDTO = new MestoDTO(mesto.get().getId(), mesto.get().getNaziv(), mesto.get().getDrzava());
			return new ResponseEntity<MestoDTO>(mestoDTO, HttpStatus.OK);
		}
		return new ResponseEntity<MestoDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Mesto> createMesto(@RequestBody Mesto mesto) {
		try {
			mestoService.save(mesto);
			return new ResponseEntity<Mesto>(mesto, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Mesto>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{mestoId}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Mesto> updateMesto(@PathVariable("mestoId") Long mestoId,
			@RequestBody Mesto izmenjenoMesto) {
		Mesto mesto = mestoService.findOne(mestoId).orElse(null);
		if (mesto != null) {
			izmenjenoMesto.setId(mestoId);
			izmenjenoMesto = mestoService.save(izmenjenoMesto);
			return new ResponseEntity<Mesto>(izmenjenoMesto, HttpStatus.OK);
		}
		return new ResponseEntity<Mesto>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{mestoId}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Mesto> deleteMesto(@PathVariable("mestoId") Long mestoId) {
		if (mestoService.findOne(mestoId).isPresent()) {
			mestoService.delete(mestoId);
			return new ResponseEntity<Mesto>(HttpStatus.OK);
		}
		return new ResponseEntity<Mesto>(HttpStatus.NOT_FOUND);
	}
	
}
