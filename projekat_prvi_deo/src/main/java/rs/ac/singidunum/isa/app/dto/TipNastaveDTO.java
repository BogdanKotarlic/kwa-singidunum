package rs.ac.singidunum.isa.app.dto;

import rs.ac.singidunum.isa.app.model.NastavnikNaRealizaciji;

public class TipNastaveDTO {
	
	private Long id;
	private String naziv;
	private NastavnikNaRealizaciji naRealizaciji;
	public TipNastaveDTO() {
		super();
	}
	public TipNastaveDTO(Long id, String naziv, NastavnikNaRealizaciji naRealizaciji) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.naRealizaciji = naRealizaciji;
	}
	public TipNastaveDTO(Long id, String naziv) {
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
	public NastavnikNaRealizaciji getNaRealizaciji() {
		return naRealizaciji;
	}
	public void setNaRealizaciji(NastavnikNaRealizaciji naRealizaciji) {
		this.naRealizaciji = naRealizaciji;
	}
	
	
	
}
