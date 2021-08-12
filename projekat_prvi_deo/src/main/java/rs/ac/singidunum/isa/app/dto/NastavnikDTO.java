package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class NastavnikDTO {
	
	private Long id;
	private String ime;
	private String biografija;
	private String jmbg;
	private PredmetDTO predmet;
	private FakultetDTO fakultet;
	private StudijskiProgramDTO studijskiProgram;
	private ArrayList<AdresaDTO> adresa = new ArrayList<AdresaDTO>();
	private ArrayList<NastavnikNaRealizacijiDTO> naRealizaciji = new ArrayList<NastavnikNaRealizacijiDTO>();
	private ArrayList<ZvanjeDTO> zvanje = new ArrayList<ZvanjeDTO>();

	public NastavnikDTO() {
		super();
	}

	public NastavnikDTO(Long id, String ime, String biografija, String jmbg, PredmetDTO predmet, FakultetDTO fakultet,
			StudijskiProgramDTO studijskiProgram, ArrayList<AdresaDTO> adresa,
			ArrayList<NastavnikNaRealizacijiDTO> naRealizaciji, ArrayList<ZvanjeDTO> zvanje) {
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.predmet = predmet;
		this.fakultet = fakultet;
		this.studijskiProgram = studijskiProgram;
		this.adresa = adresa;
		this.naRealizaciji = naRealizaciji;
		this.zvanje = zvanje;
	}
	
	public NastavnikDTO(Long id, String ime, String biografija, String jmbg) {
		this(id, ime, biografija, jmbg, null,null,null,null,null, null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public ArrayList<AdresaDTO> getAdresa() {
		return adresa;
	}

	public void setAdresa(ArrayList<AdresaDTO> adresa) {
		this.adresa = adresa;
	}

	public ArrayList<NastavnikNaRealizacijiDTO> getNaRealizaciji() {
		return naRealizaciji;
	}

	public void setNaRealizaciji(ArrayList<NastavnikNaRealizacijiDTO> naRealizaciji) {
		this.naRealizaciji = naRealizaciji;
	}

	public ArrayList<ZvanjeDTO> getZvanje() {
		return zvanje;
	}

	public void setZvanje(ArrayList<ZvanjeDTO> zvanje) {
		this.zvanje = zvanje;
	}
	
}
