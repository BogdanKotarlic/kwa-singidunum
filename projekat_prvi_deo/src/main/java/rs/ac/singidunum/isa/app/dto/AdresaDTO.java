package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class AdresaDTO {
	private Long id;
	private String ulica;
	private String broj;
	private FakultetDTO fakultet;
	private UniverzitetDTO univerzitet;
	private StudentDTO student;
	private NastavnikDTO nastavnik;
	
	private ArrayList<MestoDTO> mesto = new ArrayList<MestoDTO>();
	
	public AdresaDTO() {
		super();
	}

	public AdresaDTO(Long id, String ulica, String broj, UniverzitetDTO univerzitet, FakultetDTO fakultet, StudentDTO student, NastavnikDTO nastavnik, ArrayList<MestoDTO> mesto) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.univerzitet = univerzitet;
		this.fakultet = fakultet;
		this.student = student;
		this.nastavnik = nastavnik;
		this.mesto = mesto;
	}
	
	public AdresaDTO(Long id, String ulica, String broj) {
		this(id, ulica, broj, null, null, null, null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public ArrayList<MestoDTO> getMesto() {
		return mesto;
	}

	public void setMesto(ArrayList<MestoDTO> mesto) {
		this.mesto = mesto;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

}
