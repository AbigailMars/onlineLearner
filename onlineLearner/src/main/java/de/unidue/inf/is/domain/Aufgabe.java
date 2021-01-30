package de.unidue.inf.is.domain;

public final class Aufgabe {
	
	    private Integer kid;

	    private Integer anummer;

	    private String name;

	    private String beschreibung;

	    public Aufgabe() {
	    }

	    public Aufgabe(Integer kid,Integer anummer, String name,String beschreibung) {
	    	this.kid = kid;
	    	this.anummer = anummer;
	    	this.name = name;
	    	this.beschreibung = beschreibung;
	    }
	    
		public Integer getKid() {
			return kid;
		}

		public void setKid(Integer kid) {
			this.kid = kid;
		}

		public Integer getAnummer() {
			return anummer;
		}

		public void setAnummer(Integer anummer) {
			this.anummer = anummer;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBeschreibung() {
			return beschreibung;
		}

		public void setBeschreibung(String beschreibung) {
			this.beschreibung = beschreibung;
		}

		@Override
		public String toString() {
			return "Aufgabe [kid=" + kid + ", anummer=" + anummer + ", name=" + name + ", beschreibung=" + beschreibung
					+ "]";
		}

	
}


