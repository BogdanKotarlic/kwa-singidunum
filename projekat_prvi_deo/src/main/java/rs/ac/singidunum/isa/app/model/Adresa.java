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
public class Adresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String ulica;
	@Column(columnDefinition = "TINYTEXT")
	private String broj;
	
	@ManyToOne(optional = false)
	private Univerzitet univerzitet;
	
	@ManyToOne(optional = false)
	private Fakultet fakultet;
	
	@ManyToOne(optional = false)
	private Student student;
	
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	
	@OneToMany(mappedBy = "adresa")
	private Set<Mesto> mesta = new HashSet<Mesto>();

	public Adresa() {
		super();
	}

	public Adresa(Long id, String ulica, String broj, Univerzitet univerzitet, Fakultet fakultet, Student student, Nastavnik nastavnik) {
		super();
		this.id = id;
		this.ulica = ulica;
		this.broj = broj;
		this.univerzitet = univerzitet;
		this.fakultet = fakultet;
		this.student = student;
		this.nastavnik = nastavnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Set<Mesto> getMesta() {
		return mesta;
	}

	public void setMesta(Set<Mesto> mesta) {
		this.mesta = mesta;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
	
}
