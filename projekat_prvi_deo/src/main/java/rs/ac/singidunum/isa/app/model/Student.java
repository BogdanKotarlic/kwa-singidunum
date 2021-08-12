package rs.ac.singidunum.isa.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String jmbg;
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String ime;
	
	@OneToMany(mappedBy = "student")
	private Set<Adresa> adrese = new HashSet<Adresa>();
	
	@OneToMany(mappedBy = "student")
	private Set<StudentNaGodini> studentNaGodini = new HashSet<StudentNaGodini>();
	
	@OneToMany(mappedBy = "student")
	private Set<PohadjanjePredmeta> pohadjanjePredmeta = new HashSet<PohadjanjePredmeta>();

	public Student() {
		super();
	}

	public Student(Long id, String jmbg, String ime) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Set<Adresa> getAdrese() {
		return adrese;
	}

	public void setAdrese(Set<Adresa> adrese) {
		this.adrese = adrese;
	}

	public Set<StudentNaGodini> getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(Set<StudentNaGodini> studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	public Set<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(Set<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
	
}
