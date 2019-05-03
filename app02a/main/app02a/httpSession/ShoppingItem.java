package app02a.httpSession;

public class ShoppingItem {
private Product product;
private int quantity;
public ShoppingItem(Product product, int quantity) {
this.product = product;
this.quantity = quantity;
}

public Product getProduct() {
	return this.product;
}
public int getQuantity() {
	return this.quantity;
}
// get and set methods not shown to save space
}

