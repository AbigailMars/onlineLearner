package de.unidue.inf.is.domain;

public final class User{

    private Integer nummer;
    private String email;
    private String name;
    
    public User() {
    }
 
    public User(Integer nummer,String email, String name) {
    	this.nummer = nummer;
    	this.email = email;
    	this.name = name;
    }
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNummer() {
		return nummer;
	}

	public void setNummer(Integer nummer) {
		this.nummer = nummer;
	}
    
}