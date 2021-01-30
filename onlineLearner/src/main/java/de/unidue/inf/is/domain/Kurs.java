package de.unidue.inf.is.domain;


public final class Kurs  {

    private Integer kid;

    private String name;

    private String beschreibungstext;

    private String einschreibeschluessel;

    private Integer freieplaetze;

    private String ersteller;
    
    public Kurs() {
    }
    public Kurs(String name,Integer freieplaetze,String ersteller ) {
    	this.name = name;
    	this.freieplaetze = freieplaetze;
    	this.ersteller = ersteller;
    }
    
    public Kurs(Integer kid,String name, String beschreibungstext,String einschreibeschluessel,Integer freieplaetze,String ersteller) {
    	this.setKid(kid);
    	this.setName(name);
    	this.setBeschreibungstext(beschreibungstext);
    	this.setEinschreibeschluessel(einschreibeschluessel);
    	this.setFreieplaetze(freieplaetze);
    	this.setErsteller(ersteller);
    }

	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibungstext() {
		return beschreibungstext;
	}

	public void setBeschreibungstext(String beschreibungstext) {
		this.beschreibungstext = beschreibungstext;
	}

	public String getEinschreibeschluessel() {
		return einschreibeschluessel;
	}

	public void setEinschreibeschluessel(String einschreibeschluessel) {
		this.einschreibeschluessel = einschreibeschluessel;
	}

	public Integer getFreieplaetze() {
		return freieplaetze;
	}

	public void setFreieplaetze(Integer freieplaetze) {
		this.freieplaetze = freieplaetze;
	}

	public String getErsteller() {
		return ersteller;
	}

	public void setErsteller(String ersteller) {
		this.ersteller = ersteller;
	}

    
}