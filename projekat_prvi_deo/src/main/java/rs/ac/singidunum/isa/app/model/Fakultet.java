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
public class Fakultet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String naziv;
	
	@ManyToOne(optional = false)
	private Univerzitet univerzitet;
	
	@OneToMany(mappedBy = "fakultet")
	private Set<Adresa> adresa = new HashSet<Adresa>();
	
	@OneToMany(mappedBy = "fakultet")
	private Set<StudijskiProgram> studijskiProgram = new HashSet<StudijskiProgram>();
	
	@OneToMany(mappedBy = "fakultet")
	private Set<Nastavnik> nastavnici = new HashSet<Nastavnik>();

	public Fakultet() {
		super();
	}

	public Fakultet(Long id, String naziv, Univerzitet univerzitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.univerzitet = univerzitet;
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

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Set<Adresa> getAdresa() {
		return adresa;
	}

	public void setAdresa(Set<Adresa> adresa) {
		this.adresa = adresa;
	}

	public Set<StudijskiProgram> getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(Set<StudijskiProgram> studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}
	
}
	
