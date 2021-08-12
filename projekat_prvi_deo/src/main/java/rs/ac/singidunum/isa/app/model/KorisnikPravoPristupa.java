package rs.ac.singidunum.isa.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KorisnikPravoPristupa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Korisnik user;
	@ManyToOne
	private PravoPristupa pravopristupa;
	
	public KorisnikPravoPristupa() {
		super();
	}
	
	public KorisnikPravoPristupa(Long id, Korisnik user, PravoPristupa pravopristupa) {
		super();
		this.id = id;
		this.user = user;
		this.pravopristupa = pravopristupa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getUser() {
		return user;
	}

	public void setUser(Korisnik user) {
		this.user = user;
	}

	public PravoPristupa getPravopristupa() {
		return pravopristupa;
	}

	public void setPravopristupa(PravoPristupa pravopristupa) {
		this.pravopristupa = pravopristupa;
	}
	
}
