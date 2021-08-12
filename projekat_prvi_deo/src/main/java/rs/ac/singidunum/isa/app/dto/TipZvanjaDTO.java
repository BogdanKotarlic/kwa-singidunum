package rs.ac.singidunum.isa.app.dto;

public class TipZvanjaDTO {
	
	private Long id;
	private String naziv;
	private ZvanjeDTO zvanje;
	
	public TipZvanjaDTO() {
		super();
	}
	
	public TipZvanjaDTO(Long id, String naziv, ZvanjeDTO zvanje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zvanje = zvanje;
	}

	public TipZvanjaDTO(Long id, String naziv) {
		this(id, naziv, null);
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

	public ZvanjeDTO getZvanje() {
		return zvanje;
	}

	public void setZvanje(ZvanjeDTO zvanje) {
		this.zvanje = zvanje;
	}

}
