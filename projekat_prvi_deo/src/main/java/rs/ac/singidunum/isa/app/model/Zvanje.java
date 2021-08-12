package rs.ac.singidunum.isa.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Zvanje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumIzbora;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datumPrestanka;
	
	@ManyToOne(optional = false)
	private Nastavnik nastavnik;
	
	@OneToMany(mappedBy = "zvanje")
	private Set<TipZvanja> tipZvanja = new HashSet<TipZvanja>();
	
	@OneToMany(mappedBy = "zvanje")
	private Set<NaucnaOblast> naucnaOblast = new HashSet<NaucnaOblast>();

	public Zvanje() {
		super();
	}

	public Zvanje(Long id, Date datumIzbora, Date datumPrestanka, Nastavnik nastavnik) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.nastavnik = nastavnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(Date datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public Date getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(Date datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Set<TipZvanja> getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(Set<TipZvanja> tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public Set<NaucnaOblast> getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(Set<NaucnaOblast> naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}
	
}
