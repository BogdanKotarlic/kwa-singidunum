package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;


public class StudentDTO {
	
	private Long id;
	private String jmbg;
	private String ime;
	private ArrayList<AdresaDTO> adresa = new ArrayList<AdresaDTO>();
	private ArrayList<StudentNaGodiniDTO> studentNaGodini = new ArrayList<StudentNaGodiniDTO>();
	private ArrayList<PohadjanjePredmetaDTO> pohadjanjePredmeta = new ArrayList<PohadjanjePredmetaDTO>();
	
	public StudentDTO() {
		super();
	}

	public StudentDTO(Long id, String jmbg, String ime, ArrayList<AdresaDTO> adresa,
			ArrayList<StudentNaGodiniDTO> studentNaGodini, ArrayList<PohadjanjePredmetaDTO> pohadjanjePredmeta) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
		this.adresa = adresa;
		this.studentNaGodini = studentNaGodini;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
	
	public StudentDTO(Long id, String jmbg, String ime) {
		this(id, jmbg, ime, null, null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public ArrayList<AdresaDTO> getAdresa() {
		return adresa;
	}

	public void setAdresa(ArrayList<AdresaDTO> adresa) {
		this.adresa = adresa;
	}

	public ArrayList<StudentNaGodiniDTO> getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(ArrayList<StudentNaGodiniDTO> studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	public ArrayList<PohadjanjePredmetaDTO> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(ArrayList<PohadjanjePredmetaDTO> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
	
}
