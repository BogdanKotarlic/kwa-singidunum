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
public class StudijskiProgram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String naziv;
	
	@ManyToOne(optional = false)
	private Fakultet fakultet;
	
	@OneToMany(mappedBy = "studijskiprogram")
	private Set<GodinaStudija> godinaStudija = new HashSet<GodinaStudija>();
	
	@OneToMany(mappedBy = "studijskiprogram")
	private Set<Nastavnik> nastavnici = new HashSet<Nastavnik>();

	public StudijskiProgram() {
		super();
	}

	public StudijskiProgram(Long id, String naziv, Fakultet fakultet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.fakultet = fakultet;
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

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Set<GodinaStudija> getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Set<GodinaStudija> godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}
	
}
