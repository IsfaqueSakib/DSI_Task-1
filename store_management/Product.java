package store_management;

public class Product {
	
	private int product_name, buy_price, sell_price, profit, available_in_stock;
	
	public Product(int name, int buy_price, int sell_price, int available_in_stock) {
		
		//Product specifications
		this.product_name = name;
		this.buy_price = buy_price;
		this.sell_price = sell_price;
		this.available_in_stock = available_in_stock;
		this.profit = 0; //initial profit is 0, before selling the product
		
	}
	
	//for passing product's data
	
	//get product name
	public int getPoductName() {
		return product_name;
	}
	
	//get product buy price
	public int getBuyPrice() {
		return buy_price;
	}
	
	//get product sell price
	public int getSellPrice() {
		return sell_price;
	}
	
	//get profit made from a product
	public int getProfit() {
		return profit;
	}
	
	//get quantity of a product available in stock
	public int getAvailableInStorck() {
		return available_in_stock;
	}
	
	//update number of products available in stock after buying and selling some quantity of a product
	public void updateAvailableStock(int quantity) {
		available_in_stock = available_in_stock + quantity;
	}
	
	/*update number of products available in stock after buying some quantity of a product
	public void decreaseAvailableStock(int quantity) {
			available_in_stock = available_in_stock - quantity;
	} */
	
	//update profit made from a from a product after selling some quantity of it.
	public void updateProfit(int amount) {
		profit = profit + amount;
	}
}
