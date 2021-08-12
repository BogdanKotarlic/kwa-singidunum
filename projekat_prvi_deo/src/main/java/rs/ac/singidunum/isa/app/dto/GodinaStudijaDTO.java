package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;
import java.util.Date;

public class GodinaStudijaDTO {
	
	private Long id;
	private Date godina;
	private StudijskiProgramDTO studijskiProgram;
	private StudentNaGodiniDTO studentNaGodini;
	
	private ArrayList<PredmetDTO> predmet = new ArrayList<PredmetDTO>();
	
	public GodinaStudijaDTO() {
		super();
	}

	public GodinaStudijaDTO(Long id, Date godina, StudijskiProgramDTO studijskiProgram,
			StudentNaGodiniDTO studentNaGodini, ArrayList<PredmetDTO> predmet) {
		super();
		this.id = id;
		this.godina = godina;
		this.studijskiProgram = studijskiProgram;
		this.studentNaGodini = studentNaGodini;
		this.predmet = predmet;
	}
	
	public GodinaStudijaDTO(Long id, Date godina) {
		this(id, godina, null, null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGodina() {
		return godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public StudentNaGodiniDTO getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(StudentNaGodiniDTO studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	public ArrayList<PredmetDTO> getPredmet() {
		return predmet;
	}

	public void setPredmet(ArrayList<PredmetDTO> predmet) {
		this.predmet = predmet;
	}
	
}
