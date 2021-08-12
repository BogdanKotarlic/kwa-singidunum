package rs.ac.singidunum.isa.app.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Univerzitet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String naziv;
	@Column(columnDefinition = "DATE", nullable = false)
	private Date datumOsnivanja;
	
	@OneToMany(mappedBy = "univerzitet")
	private Set<Adresa> adrese = new HashSet<Adresa>();
	
	@OneToMany(mappedBy = "univerzitet")
	private Set<Fakultet> fakultet = new HashSet<Fakultet>();

	public Univerzitet() {
		super();
	}

	public Univerzitet(Long id, String naziv, Date datumOsnivanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public Set<Adresa> getAdrese() {
		return adrese;
	}

	public void setAdrese(Set<Adresa> adrese) {
		this.adrese = adrese;
	}

	public Set<Fakultet> getFakultet() {
		return fakultet;
	}

	public void setFakultet(Set<Fakultet> fakultet) {
		this.fakultet = fakultet;
	}
	
}
