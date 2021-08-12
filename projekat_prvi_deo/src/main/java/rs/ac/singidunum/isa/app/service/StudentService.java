package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.Student;
import rs.ac.singidunum.isa.app.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Iterable<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Optional<Student> findOne(Long id) {
		return studentRepository.findById(id);
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public void delete(Student student) {
		studentRepository.delete(student);
	}
	
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
	
}
