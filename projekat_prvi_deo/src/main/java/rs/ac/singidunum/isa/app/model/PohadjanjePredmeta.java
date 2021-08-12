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
public class PohadjanjePredmeta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private int konacnaOcena;
	
	@ManyToOne(optional = false)
	private Student student;
	
	@OneToMany(mappedBy = "pohadjanjepredmeta")
	private Set<Predmet> predmet = new HashSet<Predmet>();

	public PohadjanjePredmeta() {
		super();
	}

	public PohadjanjePredmeta(Long id, int konacnaOcena, Student student) {
		super();
		this.id = id;
		this.konacnaOcena = konacnaOcena;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getKonacnaOcena() {
		return konacnaOcena;
	}

	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Set<Predmet> getPredmet() {
		return predmet;
	}

	public void setPredmet(Set<Predmet> predmet) {
		this.predmet = predmet;
	}
	
}
