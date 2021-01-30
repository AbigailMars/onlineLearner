package de.unidue.inf.is.domain;

import java.util.Date;

public class Einschreiben {

	    private Integer bnummer;

	    private Integer kid;

	    private Date datum;

	    public Einschreiben() {
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

		public Date getDatum() {
			return datum;
		}

		public void setDatum(Date datum) {
			this.datum = datum;
		}

	

}
