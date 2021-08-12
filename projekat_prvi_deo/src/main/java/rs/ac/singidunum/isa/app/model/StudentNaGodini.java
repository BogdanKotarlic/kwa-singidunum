package rs.ac.singidunum.isa.app.model;

import java.util.Date;
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
public class StudentNaGodini {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "DATE", nullable = false)
	private Date datumUpisa;
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String brojIndeksa;
	
	@OneToMany(mappedBy = "studentnagodini")
	private Set<GodinaStudija> godinaStudija = new HashSet<GodinaStudija>();
	
	@ManyToOne(optional = false)
	private Student student;

	public StudentNaGodini() {
		super();
	}

	public StudentNaGodini(Long id, Date datumUpisa, String brojIndeksa, Student student) {
		super();
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.brojIndeksa = brojIndeksa;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<GodinaStudija> getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Set<GodinaStudija> godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
