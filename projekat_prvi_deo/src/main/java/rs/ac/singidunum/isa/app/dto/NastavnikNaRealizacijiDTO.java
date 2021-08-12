package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

import rs.ac.singidunum.isa.app.model.Nastavnik;

public class NastavnikNaRealizacijiDTO {
	
	private Long id;
	private int brojCasova;
	private Nastavnik nastavnik;
	private ArrayList<TipNastaveDTO> tipNastave = new ArrayList<TipNastaveDTO>();
	
	public NastavnikNaRealizacijiDTO() {
		super();
	}
	
	public NastavnikNaRealizacijiDTO(Long id, int brojCasova, Nastavnik nastavnik,
			ArrayList<TipNastaveDTO> tipNastave) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.nastavnik = nastavnik;
		this.tipNastave = tipNastave;
	}
	public NastavnikNaRealizacijiDTO(Long id, int brojCasova) {
		this(id, brojCasova, null, null);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBrojCasova() {
		return brojCasova;
	}
	public void setBrojCasova(int brojCasova) {
		this.brojCasova = brojCasova;
	}
	public Nastavnik getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	public ArrayList<TipNastaveDTO> getTipNastave() {
		return tipNastave;
	}
	public void setTipNastave(ArrayList<TipNastaveDTO> tipNastave) {
		this.tipNastave = tipNastave;
	}
	
}
