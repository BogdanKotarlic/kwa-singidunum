package rs.ac.singidunum.isa.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.singidunum.isa.app.model.StudijskiProgram;
import rs.ac.singidunum.isa.app.repository.StudijskiProgramRepository;

@Service
public class StudijskiProgramService {
	
	@Autowired
	private StudijskiProgramRepository studijskiProgramRepository;

	public StudijskiProgramService() {
		super();
	}

	public StudijskiProgramService(StudijskiProgramRepository studijskiProgramRepository) {
		super();
		this.studijskiProgramRepository = studijskiProgramRepository;
	}

	public StudijskiProgramRepository getStudijskiProgramRepository() {
		return studijskiProgramRepository;
	}

	public void setStudijskiProgramRepository(StudijskiProgramRepository studijskiProgramRepository) {
		this.studijskiProgramRepository = studijskiProgramRepository;
	}
	
	public Iterable<StudijskiProgram> findAll(){
		return studijskiProgramRepository.findAll();
	}
	
	public Optional<StudijskiProgram> findOne(Long id) {
		return studijskiProgramRepository.findById(id);
	}
	
	public StudijskiProgram save(StudijskiProgram studijskiProgram) {
		return studijskiProgramRepository.save(studijskiProgram);
	}
	
	public void delete(StudijskiProgram studijskiProgram) {
		studijskiProgramRepository.delete(studijskiProgram);
	}
	
	public void delete(Long id) {
		studijskiProgramRepository.deleteById(id);
	}
	
}
