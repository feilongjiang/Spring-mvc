package model;

public class Address {
	private String  streetName;
	private String streetNumber;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	
	public String getStreetName() { return this.streetName ;}
	public void setStreetName(String streetName) { this.streetName= streetName;}
	public String getStreetNumber() { return this.streetNumber; }
	public void setStreetNumber(String streetNumber) { this.streetNumber = streetNumber;}
	public String getCity() { return this.city; }
	public void setCity(String city) { this.city = city ; }
	public String getState() { return this.state; }
	public void setState(String state) { this.state = state; } 
	public String getZipCode() { return this.zipCode;}
	public void setZipCode(String zipCode) { this.zipCode = zipCode; }
	public String getCountry() { return this.country; }
	public void setCountry(String country) { this.country = country; }
}
