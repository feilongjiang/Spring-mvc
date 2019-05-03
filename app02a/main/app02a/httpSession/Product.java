package app02a.httpSession;

public class Product {
private int id;
private String name;
private String description;
private float price;
public Product(int id, String name, String description, float price) {
this.id = id;
this.name = name;
this.description = description;
this.price = price;
}
public int getId() {
	return this.id;
}
public String  getName() {
	return this.name;
}
public String getDescription() {
	return this.description;
}

public float getPrice() {
	return this.price;
}
// get and set methods not shown to save space
}
