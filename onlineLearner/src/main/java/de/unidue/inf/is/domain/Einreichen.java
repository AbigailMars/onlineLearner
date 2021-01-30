package de.unidue.inf.is.domain;


	public class Einreichen {

	    private Integer bnummer;

	    private Integer kid;

	    private Integer anummer;

	    private Integer aid;

	    public Einreichen() {
	    }
	    public Einreichen(Integer bnummer,Integer kid,Integer anummer,Integer aid) {
	    	this.bnummer = bnummer;
	    	this.kid = kid;
	    	this.anummer = anummer;
	    	this.aid = aid;
	    }
	    
		public Integer getBnummer() {
			return bnummer;
		}

		public void setBnummer(Integer bnummer) {
			this.bnummer = bnummer;
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

		public Integer getAid() {
			return aid;
		}

		public void setAid(Integer aid) {
			this.aid = aid;
		}
		@Override
		public String toString() {
			return "Einreichen [bnummer=" + bnummer + ", kid=" + kid + ", anummer=" + anummer + ", aid=" + aid + "]";
		}

}
