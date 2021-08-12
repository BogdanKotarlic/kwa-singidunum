package rs.ac.singidunum.isa.app.dto;


public class MestoDTO {
	
	private Long id;
	private String naziv;
	private String drzava;
	private AdresaDTO adresa;
	
	public MestoDTO() {
		super();
	}

	public MestoDTO(Long id, String naziv, String drzava, AdresaDTO adresa) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
	}
	
	public MestoDTO(Long id, String naziv, String drzava) {
		this(id, naziv, drzava, null);
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

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}
	
}
