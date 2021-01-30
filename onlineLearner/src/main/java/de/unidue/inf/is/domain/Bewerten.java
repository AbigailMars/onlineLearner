package de.unidue.inf.is.domain;



public class Bewerten {

    private Integer bnummer;

    private Integer aid;

    private Integer note;

    private String kommentar;

    public Bewerten() {
    }

	public String getKommentar() {
		return kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getBnummer() {
		return bnummer;
	}

	public void setBnummer(Integer bnummer) {
		this.bnummer = bnummer;
	}

	@Override
	public String toString() {
		return "Bewerten [bnummer=" + bnummer + ", aid=" + aid + ", note=" + note + ", kommentar=" + kommentar + "]";
	}

}
