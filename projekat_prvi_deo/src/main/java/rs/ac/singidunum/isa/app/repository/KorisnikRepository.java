package rs.ac.singidunum.isa.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.isa.app.model.Korisnik;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Long>{

	Optional<Korisnik> findByKorisnickoIme(String korisnickoIme);
	
}
