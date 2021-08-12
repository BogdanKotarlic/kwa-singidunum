package rs.ac.singidunum.isa.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String naziv;
	
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String drzava;
	
	@ManyToOne(optional = false)
	private Adresa adresa;

	public Mesto() {
		super();
	}

	public Mesto(Long id, String naziv, String drzava ,Adresa adresa) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.drzava = drzava;
		this.adresa = adresa;
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

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	
}
