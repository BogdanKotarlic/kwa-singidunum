package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class FakultetDTO {
	
	private Long id;
	private String naziv;
	private UniverzitetDTO univerzitet;
	
	private ArrayList<AdresaDTO> adresa = new ArrayList<AdresaDTO>();
	private ArrayList<StudijskiProgramDTO> studijskiProgram = new ArrayList<StudijskiProgramDTO>();
	private ArrayList<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();
	
	public FakultetDTO() {
		super();
	}

	public FakultetDTO(Long id, String naziv, UniverzitetDTO univerzitet, ArrayList<AdresaDTO> adresa,
			ArrayList<StudijskiProgramDTO> studijskiProgram , ArrayList<NastavnikDTO> nastavnici) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.univerzitet = univerzitet;
		this.adresa = adresa;
		this.studijskiProgram = studijskiProgram;
		this.nastavnici = nastavnici;
	}
	
	public FakultetDTO(Long id, String naziv) {
		this(id, naziv, null, null, null, null);
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

	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}

	public ArrayList<AdresaDTO> getAdresa() {
		return adresa;
	}

	public void setAdresa(ArrayList<AdresaDTO> adresa) {
		this.adresa = adresa;
	}

	public ArrayList<StudijskiProgramDTO> getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(ArrayList<StudijskiProgramDTO> studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public ArrayList<NastavnikDTO> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(ArrayList<NastavnikDTO> nastavnici) {
		this.nastavnici = nastavnici;
	}
	
}
