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

import rs.ac.singidunum.isa.app.dto.StudentNaGodiniDTO;
import rs.ac.singidunum.isa.app.model.StudentNaGodini;
import rs.ac.singidunum.isa.app.service.StudentNaGodiniService;

@Controller
@RequestMapping(path = "/api/studentinagodini")
public class StudentNaGodiniController {
	
	@Autowired
	StudentNaGodiniService studentNaGodiniService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StudentNaGodiniDTO>> getAllStudentiNaGodini() {
		
		ArrayList<StudentNaGodiniDTO> studentiNaGodini = new ArrayList<StudentNaGodiniDTO>();
		for(StudentNaGodini studentNaGodini : studentNaGodiniService.findAll()) {
			studentiNaGodini.add(new StudentNaGodiniDTO(studentNaGodini.getId(), studentNaGodini.getDatumUpisa(), studentNaGodini.getBrojIndeksa()));
		}
		return new ResponseEntity<Iterable<StudentNaGodiniDTO>>(studentiNaGodini, HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/{studentnagodiniId}", method = RequestMethod.GET)
	public ResponseEntity<StudentNaGodiniDTO> getStudentNaGodini(@PathVariable("studentnagodiniId") Long studentnagodiniId) {
		Optional<StudentNaGodini> studentNaGodini = studentNaGodiniService.findOne(studentnagodiniId);

		StudentNaGodiniDTO studentNaGodiniDTO;

		if (studentNaGodini.isPresent()) {
			studentNaGodiniDTO = new StudentNaGodiniDTO(studentNaGodini.get().getId(), studentNaGodini.get().getDatumUpisa(), studentNaGodini.get().getBrojIndeksa());
			return new ResponseEntity<StudentNaGodiniDTO>(studentNaGodiniDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodiniDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StudentNaGodini> createStudentNaGodini(@RequestBody StudentNaGodini studentNaGodini) {
		try {
			studentNaGodiniService.save(studentNaGodini);
			return new ResponseEntity<StudentNaGodini>(studentNaGodini, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{studentnagodiniId}", method = RequestMethod.PUT)
	public ResponseEntity<StudentNaGodini> updateStudentNaGodini(@PathVariable("studentnagodiniId") Long studentnagodiniId,
			@RequestBody StudentNaGodini izmenjeniStudentNaGodini) {
		StudentNaGodini studentNaGodini = studentNaGodiniService.findOne(studentnagodiniId).orElse(null);
		if (studentNaGodini != null) {
			izmenjeniStudentNaGodini.setId(studentnagodiniId);
			izmenjeniStudentNaGodini = studentNaGodiniService.save(izmenjeniStudentNaGodini);
			return new ResponseEntity<StudentNaGodini>(izmenjeniStudentNaGodini, HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{studentnagodiniId}", method = RequestMethod.DELETE)
	public ResponseEntity<StudentNaGodini> deleteStudentNaGodini(@PathVariable("studentnagodiniId") Long studentnagodiniId) {
		if (studentNaGodiniService.findOne(studentnagodiniId).isPresent()) {
			studentNaGodiniService.delete(studentnagodiniId);
			return new ResponseEntity<StudentNaGodini>(HttpStatus.OK);
		}
		return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
	}
	
}
