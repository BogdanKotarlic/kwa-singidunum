package rs.ac.singidunum.isa.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TipNastave {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	
	@ManyToOne
	private NastavnikNaRealizaciji nastavniknarealizaciji;

	public TipNastave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipNastave(Long id, String naziv, NastavnikNaRealizaciji nastavniknarealizaciji) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavniknarealizaciji = nastavniknarealizaciji;
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

	public NastavnikNaRealizaciji getNastavniknarealizaciji() {
		return nastavniknarealizaciji;
	}

	public void setNastavniknarealizaciji(NastavnikNaRealizaciji nastavniknarealizaciji) {
		this.nastavniknarealizaciji = nastavniknarealizaciji;
	}

}
