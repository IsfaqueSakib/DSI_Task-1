package store_management;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Product_stock {
	//Store products as key-value pair in map. product name as key and product copy(object) as value.
	private HashMap <Integer, Product> product_list = new HashMap <Integer, Product > ();
	
	//find a product by name in product list. It is needed to check a product with a name is exist or not in the list.
	public boolean findProduct(Product product) {
		
		if(product_list.containsKey(product.getPoductName())) {
			return true;
		}
		 
		return false;
		
	}
	
	//1. add product in the product list (map) as (key,value) ==> (product name, product copy) pair.
	public void addProduct(Product product, int quantity) {
	
		product_list.put(product.getPoductName(), product);
		
		//confirmation of adding a product successfully.
		System.out.println(quantity +" pieces of product " + product.getPoductName() + " is successfully added to Store");
		
	}
	
	//2. delete a product from product list by finding it using product name.
	public void deleteProduct(int name) {
		
		Product product = product_list.get(name);
		boolean is_product_exist = findProduct(product);
		
		if(is_product_exist) {
			//delete product
			product_list.remove(name);
			//confirmation of deleting a product successfully
			System.out.println("Product " + name + " is deleted successfully.");
		}
		else System.out.println("Product " + name + " is not in the list.");
		
	}
	
	//3. buy a product
	public void buyProduct(int name, int quantity) {
		
		Product product = product_list.get(name);
		
		product.updateAvailableStock(quantity);
		
		//store the updated product info (dropping the previous record) in the product list
		product_list.remove(name);
		product_list.put(name, product);
		
		//calculate the total cost of buying the specific product.
		int cost = product.getBuyPrice() * quantity;
		Available_balance.updateAvailableBalance((-1)*cost); //cost is set negative because available balance will decrease after buying product.
		
		//confirmation of buying the product successfully
		System.out.println(quantity + " pieces of " + name + "is bought successfully");
	}
	
	//4. sell a product
	public void sellProduct(int name, int quantity) {
		
		Product product = product_list.get(name);
		
		//check if requested quantity of the product is available in the stock
		if(quantity > product.getAvailableInStorck()) {
			
			//showing available quantity in the stock. If consumer wants to buy reduced quantity from the requested quantity.
			System.out.println("Sorry, " + product.getAvailableInStorck() + " pieces are available in the stock.");
			
			return;
		}
		
		//calculate the total profit made by selling the specific product.
		int profit_amount = ( product.getSellPrice() - product.getBuyPrice() ) * quantity;
		
		product.updateAvailableStock((-1)*quantity); //quantity is set negative because available stock will decrease after selling product.
		product.updateProfit(profit_amount);
		
		//increase available balance
		int increase_amount = product.getSellPrice() * quantity;
		Available_balance.updateAvailableBalance(increase_amount);
		
		//store the updated product info (dropping the previous record) in the product list
		product_list.remove(name);
		product_list.put(name, product);
		
		//confirmation of buying the product successfully
		System.out.println(quantity + " pieces of product " + name + " is sold successfully");
		
	}
	
	//5. See the list of products
	public void showProductList() {
		
		Iterator iterator = product_list.entrySet().iterator();
		
		// Print the list objects in tabular format.
	    System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%10s %30s %20s", "PRODUCT NAME", "AVAILABLE IN STOCK", "PROFIT");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
	    
	    while(iterator.hasNext())
		{
			Map.Entry mapElement = (Map.Entry) iterator.next();
			//int product_name = (int) mapElement.getKey();
			
			Product product = (Product) mapElement.getValue();
			
			//print product info
			//System.out.println("Product Name : " + product.getPoductName());
			//System.out.println("Available in stock : " + product.getAvailableInStorck());
			//System.out.println("Profit : " + product.getProfit());
			System.out.format("%10s %30s %20s", product.getPoductName(), product.getAvailableInStorck(), product.getProfit());
			System.out.println();
		}
	    
	    System.out.println("-----------------------------------------------------------------------------");
	
	}
	
	//6. See available balance
	public void showAvailablebalance() {
		System.out.println("Total available balance : " + Available_balance.getAvailableBalance());
	}
	
}
