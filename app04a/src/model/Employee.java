package model;

public class Employee  {
	private int id;
	private String name;
	private Address address;
	public int getId() { return this.id; }
	public void setId(int id) { this.id = id ;}
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public Address getAddress() { return this.address; }
	public void setAddress(Address address) { this.address = address; }
}
