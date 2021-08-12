package rs.ac.singidunum.isa.app.dto;

import java.util.ArrayList;

public class PredmetDTO {
	
	private Long id;
	private String naziv;
	private int espb;
	private boolean obavezan;
	private int brojPredavanja;
	private int brojVezbi;
	private int drugiObliciNastave;
	private int istrazivackiRad;
	private int ostaliCasovi;
	private GodinaStudijaDTO godinaStudija;
	private ArrayList<IshodDTO> ishod = new ArrayList<IshodDTO>();
	private ArrayList<NastavnikDTO> nastavnici = new ArrayList<NastavnikDTO>();
	
	public PredmetDTO() {
		super();
	}
	
	public PredmetDTO(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istrazivackiRad, int ostaliCasovi, GodinaStudijaDTO godinaStudija,
			ArrayList<IshodDTO> ishod, ArrayList<NastavnikDTO> nastavnici) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.ostaliCasovi = ostaliCasovi;
		this.godinaStudija = godinaStudija;
		this.ishod = ishod;
		this.nastavnici = nastavnici;
	}
	
	public PredmetDTO(Long id, String naziv, int espb, boolean obavezan, int brojPredavanja, int brojVezbi,
			int drugiObliciNastave, int istrazivackiRad, int ostaliCasovi) {
		this(id, naziv, espb, obavezan, brojPredavanja, brojVezbi, 
				drugiObliciNastave, istrazivackiRad, ostaliCasovi, null, null, null);
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

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public boolean isObavezan() {
		return obavezan;
	}

	public void setObavezan(boolean obavezan) {
		this.obavezan = obavezan;
	}

	public int getBrojPredavanja() {
		return brojPredavanja;
	}

	public void setBrojPredavanja(int brojPredavanja) {
		this.brojPredavanja = brojPredavanja;
	}

	public int getBrojVezbi() {
		return brojVezbi;
	}

	public void setBrojVezbi(int brojVezbi) {
		this.brojVezbi = brojVezbi;
	}

	public int getDrugiObliciNastave() {
		return drugiObliciNastave;
	}

	public void setDrugiObliciNastave(int drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}

	public int getIstrazivackiRad() {
		return istrazivackiRad;
	}

	public void setIstrazivackiRad(int istrazivackiRad) {
		this.istrazivackiRad = istrazivackiRad;
	}

	public int getOstaliCasovi() {
		return ostaliCasovi;
	}

	public void setOstaliCasovi(int ostaliCasovi) {
		this.ostaliCasovi = ostaliCasovi;
	}

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public ArrayList<IshodDTO> getIshod() {
		return ishod;
	}

	public void setIshod(ArrayList<IshodDTO> ishod) {
		this.ishod = ishod;
	}

	public ArrayList<NastavnikDTO> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(ArrayList<NastavnikDTO> nastavnici) {
		this.nastavnici = nastavnici;
	}
}
