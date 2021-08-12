package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;
import java.util.Date;

public class StudentNaGodiniDTO {
	
	private Long id;
	private Date datumUpisa;
	private String brojIndeksa;
	private StudentDTO student;
	private ArrayList<GodinaStudijaDTO> godinaStudija;
	
	public StudentNaGodiniDTO() {
		super();
	}

	public StudentNaGodiniDTO(Long id, Date datumUpisa, String brojIndeksa, StudentDTO student,
			ArrayList<GodinaStudijaDTO> godinaStudija) {
		super();
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.brojIndeksa = brojIndeksa;
		this.student = student;
		this.godinaStudija = godinaStudija;
	}

	public StudentNaGodiniDTO(Long id, Date datumUpisa, String brojIndeksa) {
		this(id, datumUpisa, brojIndeksa, null, null);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public ArrayList<GodinaStudijaDTO> getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(ArrayList<GodinaStudijaDTO> godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	
}
