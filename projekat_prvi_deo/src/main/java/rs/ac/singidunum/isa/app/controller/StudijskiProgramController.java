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
import rs.ac.singidunum.isa.app.dto.StudijskiProgramDTO;
import rs.ac.singidunum.isa.app.model.StudijskiProgram;
import rs.ac.singidunum.isa.app.service.StudijskiProgramService;

@Controller
@RequestMapping(path = "/api/studijski_programi")
public class StudijskiProgramController {
	
	@Autowired
	StudijskiProgramService studijskiProgramService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Iterable<StudijskiProgramDTO>> getAllStudijskePrograme() {
		ArrayList<StudijskiProgramDTO> studijskiProgrami = new ArrayList<StudijskiProgramDTO>();
		for(StudijskiProgram studijskiProgram : studijskiProgramService.findAll()) {
			studijskiProgrami.add(new StudijskiProgramDTO(studijskiProgram.getId(), studijskiProgram.getNaziv()));
		}
		return new ResponseEntity<Iterable<StudijskiProgramDTO>>(studijskiProgrami, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/{studijskiProgramId}", method = RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudijskiProgramDTO> getStudijskiProgram(@PathVariable("studijskiProgramId") Long studijskiProgramId) {
		Optional<StudijskiProgram> studijskiProgram = studijskiProgramService.findOne(studijskiProgramId);

		StudijskiProgramDTO studijskiProgramDTO;

		if (studijskiProgram.isPresent()) {
			studijskiProgramDTO = new StudijskiProgramDTO(studijskiProgram.get().getId(), studijskiProgram.get().getNaziv());
			return new ResponseEntity<StudijskiProgramDTO>(studijskiProgramDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgramDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudijskiProgram> createStudijskiProgram(@RequestBody StudijskiProgram studijskiProgram) {
		try {
			studijskiProgramService.save(studijskiProgram);
			return new ResponseEntity<StudijskiProgram>(studijskiProgram, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{studijskiProgramId}", method = RequestMethod.PUT)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudijskiProgram> updateStudijskiProgram(@PathVariable("studijskiProgramId") Long studijskiProgramId,
			@RequestBody StudijskiProgram izmenjeniStudijskiProgram) {
		StudijskiProgram studijskiProgram = studijskiProgramService.findOne(studijskiProgramId).orElse(null);
		if (studijskiProgram != null) {
			izmenjeniStudijskiProgram.setId(studijskiProgramId);
			izmenjeniStudijskiProgram = studijskiProgramService.save(izmenjeniStudijskiProgram);
			return new ResponseEntity<StudijskiProgram>(izmenjeniStudijskiProgram, HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{studijskiProgramId}", method = RequestMethod.DELETE)
	@Secured("ROLE_ADMIN")
	public ResponseEntity<StudijskiProgram> deleteStudijskiProgram(@PathVariable("studijskiProgramId") Long studijskiProgramId) {
		if (studijskiProgramService.findOne(studijskiProgramId).isPresent()) {
			studijskiProgramService.delete(studijskiProgramId);
			return new ResponseEntity<StudijskiProgram>(HttpStatus.OK);
		}
		return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
	}
	
}
