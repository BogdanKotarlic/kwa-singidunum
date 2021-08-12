package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;


public class StudijskiProgramDTO {
	
	private Long id;
	private String naziv;
	private FakultetDTO fakultet;
	private ArrayList<GodinaStudijaDTO> godinaStudija = new ArrayList<GodinaStudijaDTO>();
	private ArrayList<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();
	
	public StudijskiProgramDTO() {
		super();
	}

	public StudijskiProgramDTO(Long id, String naziv, FakultetDTO fakultet, ArrayList<GodinaStudijaDTO> godinaStudija, ArrayList<NastavnikDTO> nastavnici) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
		this.godinaStudija = godinaStudija;
		this.nastavnici = nastavnici;
	}

	public StudijskiProgramDTO(Long id, String naziv) {
		this(id, naziv, null, null, null);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public ArrayList<GodinaStudijaDTO> getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(ArrayList<GodinaStudijaDTO> godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public ArrayList<NastavnikDTO> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(ArrayList<NastavnikDTO> nastavnici) {
		this.nastavnici = nastavnici;
	}
	
}
