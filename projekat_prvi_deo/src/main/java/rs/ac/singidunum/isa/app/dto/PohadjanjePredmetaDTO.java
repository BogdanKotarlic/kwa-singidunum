package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class PohadjanjePredmetaDTO {
	
	private Long id;
	private int konacnaOcena;
	private StudentDTO student;
	private ArrayList<PredmetDTO> predmetDTO = new ArrayList<PredmetDTO>();
	
	public PohadjanjePredmetaDTO() {
		super();
	}

	public PohadjanjePredmetaDTO(Long id, int konacnaOcena, StudentDTO student, ArrayList<PredmetDTO> predmetDTO) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.student = student;
		this.predmetDTO = predmetDTO;
	}
	
	public PohadjanjePredmetaDTO(Long id, int konacnaOcena) {
		this(id, konacnaOcena, null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public ArrayList<PredmetDTO> getPredmetDTO() {
		return predmetDTO;
	}

	public void setPredmetDTO(ArrayList<PredmetDTO> predmetDTO) {
		this.predmetDTO = predmetDTO;
	}
	
}
