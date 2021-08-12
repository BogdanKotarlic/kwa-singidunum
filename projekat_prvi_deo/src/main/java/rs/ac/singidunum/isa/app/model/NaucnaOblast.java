package rs.ac.singidunum.isa.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NaucnaOblast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "TINYTEXT", nullable = false)
	private String naziv;
	
	@ManyToOne(optional = false)
	private Zvanje zvanje;

	public NaucnaOblast() {
		super();
	}

	public NaucnaOblast(Long id, String naziv, Zvanje zvanje) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zvanje = zvanje;
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

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

}
