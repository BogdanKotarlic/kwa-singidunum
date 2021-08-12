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
public class PravoPristupa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String naziv;
	
	@OneToMany(mappedBy = "pravopristupa")
	private Set<KorisnikPravoPristupa> korisnikPravoPristupa = new HashSet<KorisnikPravoPristupa>();

	public PravoPristupa() {
		super();
	}

	public PravoPristupa(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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

	public Set<KorisnikPravoPristupa> getKorisnikPravoPristupa() {
		return korisnikPravoPristupa;
	}

	public void setKorisnikPravoPristupa(Set<KorisnikPravoPristupa> korisnikPravoPristupa) {
		this.korisnikPravoPristupa = korisnikPravoPristupa;
	}
	
}
