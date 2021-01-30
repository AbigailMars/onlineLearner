package de.unidue.inf.is.domain;

public class ViewCourse {
	 private Integer kid;
	 private Integer anummer;
	 private Integer aid;
	 private String name;
	 private String abgabetext;
	 private String note;
	  
	public ViewCourse(){
		
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbgabetext() {
		return abgabetext;
	}
	public void setAbgabetext(String abgabetext) {
		this.abgabetext = abgabetext;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "ViewCourse [kid=" + kid + ", anummer=" + anummer + ", aid=" + aid + ", name=" + name + ", abgabetext="
				+ abgabetext + ", note=" + note + "]";
	}
	 
}
