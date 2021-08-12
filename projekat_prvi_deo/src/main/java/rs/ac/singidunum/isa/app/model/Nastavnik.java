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
public class Nastavnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String ime;
	
	@Column(nullable = false)
	private String biografija;
	
	@Column(nullable = false)
	private String jmbg;
	
	@ManyToOne(optional = false)
	private Predmet predmet;
	
	@ManyToOne(optional = false)
	private Fakultet fakultet;
	
	@ManyToOne(optional = false)
	private StudijskiProgram studijskiprogram;
	
	@OneToMany(mappedBy = "nastavnik")
	private Set<Adresa> adresa = new HashSet<Adresa>();
	
	@OneToMany(mappedBy = "nastavnik")
	private Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji = new HashSet<NastavnikNaRealizaciji>();
	
	@OneToMany(mappedBy = "nastavnik")
	private Set<Zvanje> zvanje = new HashSet<Zvanje>();

	public Nastavnik() {
		super();
	}

	public Nastavnik(Long id, String ime, String biografija, String jmbg, Predmet predmet, Fakultet fakultet,
			StudijskiProgram studijskiprogram) {
		super();
		this.id = id;
		this.ime = ime;
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.predmet = predmet;
		this.fakultet = fakultet;
		this.studijskiprogram = studijskiprogram;
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

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public StudijskiProgram getStudijskiprogram() {
		return studijskiprogram;
	}

	public void setStudijskiprogram(StudijskiProgram studijskiprogram) {
		this.studijskiprogram = studijskiprogram;
	}

	public Set<Adresa> getAdresa() {
		return adresa;
	}

	public void setAdresa(Set<Adresa> adresa) {
		this.adresa = adresa;
	}

	public Set<NastavnikNaRealizaciji> getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}

	public Set<Zvanje> getZvanje() {
		return zvanje;
	}

	public void setZvanje(Set<Zvanje> zvanje) {
		this.zvanje = zvanje;
	}
	
}
