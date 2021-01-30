package de.unidue.inf.is.domain;

public class Abgabe {
        private Integer aid;

	    private String abgabetext;

	    public Abgabe() {
	    }
	    
	    public Abgabe(Integer aid,String abgabetext) {
	    	this.aid = aid;
	    	this.abgabetext = abgabetext;
	    }
	    
		public Integer getAid() {
			return aid;
		}

		public void setAid(Integer aid) {
			this.aid = aid;
		}

		public String getAbgabetext() {
			return abgabetext;
		}

		public void setAbgabetext(String abgabetext) {
			this.abgabetext = abgabetext;
		}

	


}
