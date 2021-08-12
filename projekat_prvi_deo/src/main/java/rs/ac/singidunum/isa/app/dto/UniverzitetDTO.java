package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;
import java.util.Date;

public class UniverzitetDTO {
	
	private Long id;
	private String naziv;
	private Date datumOsnivanja;
	private ArrayList<AdresaDTO> adrese = new ArrayList<AdresaDTO>();
	private ArrayList<FakultetDTO> fakultet = new ArrayList<FakultetDTO>();
	
	public UniverzitetDTO() {
		super();
	}

	public UniverzitetDTO(Long id, String naziv, Date datumOsnivanja, ArrayList<AdresaDTO> adrese, ArrayList<FakultetDTO> fakultet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.adrese = adrese;
		this.fakultet = fakultet;
	}

	public UniverzitetDTO(Long id, String naziv, Date datumOsnivanja) {
		this(id, naziv, datumOsnivanja, null, null);
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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public ArrayList<AdresaDTO> getAdrese() {
		return adrese;
	}

	public void setAdrese(ArrayList<AdresaDTO> adrese) {
		this.adrese = adrese;
	}

	public ArrayList<FakultetDTO> getFakultet() {
		return fakultet;
	}

	public void setFakultet(ArrayList<FakultetDTO> fakultet) {
		this.fakultet = fakultet;
	}
	
}
