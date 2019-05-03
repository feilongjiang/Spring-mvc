package bean;

public class Address {
	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zipCode;
	private String country;

	public Address(String line1, String line2, String city, String state, String zipCode, String country) {
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

// getters and setters omitted
	@Override
	public String toString() {
		return line1 + "\n" + line2 + "\n" + city + "\n" + state + " " + zipCode + "\n" + country;
	}
}
