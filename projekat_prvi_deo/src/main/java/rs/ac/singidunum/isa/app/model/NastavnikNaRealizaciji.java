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
public class NastavnikNaRealizaciji {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private int brojCasova;
	
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	
	@OneToMany(mappedBy = "nastavniknarealizaciji")
	private Set<TipNastave> tipNastave = new HashSet<TipNastave>();

	public NastavnikNaRealizaciji() {
		super();
	}

	public NastavnikNaRealizaciji(Long id, int brojCasova, Nastavnik nastavnik) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.nastavnik = nastavnik;
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

	public Set<TipNastave> getTipNastave() {
		return tipNastave;
	}

	public void setTipNastave(Set<TipNastave> tipNastave) {
		this.tipNastave = tipNastave;
	}
	
}
