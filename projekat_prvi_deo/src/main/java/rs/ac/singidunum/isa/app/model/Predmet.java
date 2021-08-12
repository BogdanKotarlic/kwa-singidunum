package rs.ac.singidunum.isa.app.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Predmet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;

	@Column(nullable = false)
	private int espb;
	
	@Column(nullable = false)
	private Boolean obavezan;
	
	@Column(nullable = false)
	private int brojPredavanja;
	
	@Column(nullable = false)
	private int brojVezbi;
	
	@Column(nullable = false)
	private int drugiObliciNastave;
	
	@Column(nullable = false)
	private int istrazivackiRad;
	
	@Column(nullable = false)
	private int ostaliCasovi;
	
	
	@ManyToOne(optional = false)
	private GodinaStudija godinastudija;
	
	@OneToMany(mappedBy = "predmet")
	private Set<Ishod> ishod = new HashSet<Ishod>();
	
	@OneToMany(mappedBy = "predmet")
	private Set<Nastavnik> nastavnici = new HashSet<Nastavnik>();
	
	@ManyToOne(optional = false)
	private PohadjanjePredmeta pohadjanjepredmeta;
	
	public Predmet() {
		super();
	}

	

	public Predmet(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istrazivackiRad, int ostaliCasovi, GodinaStudija godinaStudija, PohadjanjePredmeta pohadjanjePredmeta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.ostaliCasovi = ostaliCasovi;
		this.godinastudija = godinaStudija;
		this.pohadjanjepredmeta = pohadjanjePredmeta;
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



	public int getEspb() {
		return espb;
	}



	public void setEspb(int espb) {
		this.espb = espb;
	}



	public boolean isObavezan() {
		return obavezan;
	}



	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}



	public int getBrojPredavanja() {
		return brojPredavanja;
	}



	public void setBrojPredavanja(int brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}



	public int getBrojVezbi() {
		return brojVezbi;
	}



	public void setBrojVezbi(int brojVezbi) {
		this.brojVezbi = brojVezbi;
	}



	public int getDrugiObliciNastave() {
		return drugiObliciNastave;
	}



	public void setDrugiObliciNastave(int drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}



	public int getIstrazivackiRad() {
		return istrazivackiRad;
	}



	public void setIstrazivackiRad(int istrazivackiRad) {
		this.istrazivackiRad = istrazivackiRad;
	}



	public int getOstaliCasovi() {
		return ostaliCasovi;
	}



	public void setOstaliCasovi(int ostaliCasovi) {
		this.ostaliCasovi = ostaliCasovi;
	}



	public GodinaStudija getGodinaStudija() {
		return godinastudija;
	}



	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinastudija = godinaStudija;
	}



	public Set<Ishod> getIshod() {
		return ishod;
	}



	public void setIshod(Set<Ishod> ishod) {
		this.ishod = ishod;
	}



	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}



	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}



	public PohadjanjePredmeta getPohadjanjePredmeta() {
		return pohadjanjepredmeta;
	}



	public void setPohadjanjePredmeta(PohadjanjePredmeta pohadjanjePredmeta) {
		this.pohadjanjepredmeta = pohadjanjePredmeta;
	}
	
	
}
