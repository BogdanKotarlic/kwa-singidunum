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
public class GodinaStudija {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "DATE", nullable = false)
	private Date godina;
	
	@ManyToOne(optional = false)
	private StudentNaGodini studentnagodini;
	
	@ManyToOne(optional = false)
	private StudijskiProgram studijskiprogram;
	
	@OneToMany(mappedBy = "godinastudija")
	private Set<Predmet> predmeti = new HashSet<Predmet>();

	public GodinaStudija() {
		super();
	}

	public GodinaStudija(Long id, Date godina, StudentNaGodini studentnagodini, StudijskiProgram studijskiprogram) {
		super();
		this.id = id;
		this.godina = godina;
		this.studentnagodini = studentnagodini;
		this.studijskiprogram = studijskiprogram;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getGodina() {
		return godina;
	}

	public void setGodina(Date godina) {
		this.godina = godina;
	}

	public StudentNaGodini getStudentnagodini() {
		return studentnagodini;
	}

	public void setStudentnagodini(StudentNaGodini studentnagodini) {
		this.studentnagodini = studentnagodini;
	}

	public StudijskiProgram getStudijskiprogram() {
		return studijskiprogram;
	}

	public void setStudijskiprogram(StudijskiProgram studijskiprogram) {
		this.studijskiprogram = studijskiprogram;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

}
