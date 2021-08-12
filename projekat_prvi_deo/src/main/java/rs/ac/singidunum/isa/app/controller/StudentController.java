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

import rs.ac.singidunum.isa.app.dto.StudentDTO;
import rs.ac.singidunum.isa.app.model.Student;
import rs.ac.singidunum.isa.app.service.StudentService;

@Controller
@RequestMapping(path = "/api/studenti")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(path = "", method = RequestMethod.GET)
	@Secured({"ROLE_NASTAVNIK", "ROLE_ADMIN"})
	public ResponseEntity<Iterable<StudentDTO>> getAllStudenti() {
		
		ArrayList<StudentDTO> studenti = new ArrayList<StudentDTO>();
		for(Student student : studentService.findAll()) {
			studenti.add(new StudentDTO(student.getId(), student.getJmbg(), student.getIme()));
		}
		return new ResponseEntity<Iterable<StudentDTO>>(studenti, HttpStatus.OK);
		
	}
	
	@RequestMapping(path = "/{studentId}", method = RequestMethod.GET)
	@Secured({"ROLE_NASTAVNIK", "ROLE_ADMIN"})
	public ResponseEntity<StudentDTO> getStudent(@PathVariable("studentId") Long studentId) {
		Optional<Student> student = studentService.findOne(studentId);

		StudentDTO studentDTO;

		if (student.isPresent()) {
			studentDTO = new StudentDTO(student.get().getId(), student.get().getJmbg(), student.get().getIme());
			return new ResponseEntity<StudentDTO>(studentDTO, HttpStatus.OK);
		}
		return new ResponseEntity<StudentDTO>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
	@Secured({"ROLE_NASTAVNIK", "ROLE_ADMIN"})
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		try {
			studentService.save(student);
			return new ResponseEntity<Student>(student, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/{studentId}", method = RequestMethod.PUT)
	@Secured({"ROLE_NASTAVNIK", "ROLE_ADMIN"})
	public ResponseEntity<Student> updateStudent(@PathVariable("studentId") Long studentId,
			@RequestBody Student izmenjeniStudent) {
		Student student = studentService.findOne(studentId).orElse(null);
		if (student != null) {
			izmenjeniStudent.setId(studentId);
			izmenjeniStudent = studentService.save(izmenjeniStudent);
			return new ResponseEntity<Student>(izmenjeniStudent, HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/{studentId}", method = RequestMethod.DELETE)
	@Secured({"ROLE_NASTAVNIK", "ROLE_ADMIN"})
	public ResponseEntity<Student> deleteStudent(@PathVariable("studentId") Long studentId) {
		if (studentService.findOne(studentId).isPresent()) {
			studentService.delete(studentId);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
	
}
