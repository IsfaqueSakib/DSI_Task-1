package store_management;

import java.util.Scanner;

public class Store_Operations {

	public void open_store() {
		
		//following instructions of Assignment 
		System.out.println("Command line choice for store operations :");
		System.out.println("1 to Add a Product");
		System.out.println("2 to Delete a Product");
		System.out.println("3 to Buy a Product");
		System.out.println("4 to Sell a Product");
		System.out.println("5 to See List of Products");
		System.out.println("6 to See Available Balance");
		System.out.println("0 to Exit");
		
		//int choice = 1;
		
		//create an instance of product stock to store product info
		Product_stock stock = new Product_stock();
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Enter your choice of operation [0 to 6] :");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				//operation #1 : Add a Product
				
				//taking product name to search the product(to add)
				System.out.println("Enter product name :");
				int product_name = sc.nextInt();
				
				//taking buying price of product 
				System.out.println("Enter buy price");
				int buy_price = sc.nextInt();
				
				//taking selling price of product 
				System.out.println("Enter sell price");
				int sell_price = sc.nextInt();
				
				//taking number of products to add in stock 
				System.out.println("Enter availabe number in the inventory to sell");
				int inventory = sc.nextInt();
				
				//create an instance of product with given specifications
				Product product = new Product(product_name, buy_price, sell_price, inventory);
				
				//add product in the product list
				stock.addProduct(product, inventory);
				
			}
			
			else if(choice == 2) {
				//operation #2 : delete a product
				
				//taking product name to search the product(to delete)
				System.out.println("Enter product name to delete :");
				int product_name = sc.nextInt();
				
				//delete product by searching with product name
				stock.deleteProduct(product_name);
			}
			
			else if(choice == 3) {
				//operation #3 : buy a product
				
				//taking product name to search the product(to buy)
				System.out.println("Enter product name to buy :");
				int product_name = sc.nextInt();
				
				//taking quantity of product want to buy
				System.out.println("Enter product quantity to buy :");
				int quantity = sc.nextInt();
				
				//buy product by searching with product name and update product availability with quantity
				stock.buyProduct(product_name, quantity);
			}
			
			else if(choice == 4) {
				//operation #4 : sell a product
				
				//taking product name to search the product(to sell)
				System.out.println("Enter product name to sell :");
				int product_name = sc.nextInt();
				
				//taking quantity of product want to sell
				System.out.println("Enter product quantity to sell :");
				int quantity = sc.nextInt();
				
				//sell product by searching with product name and update product availability with quantity
				stock.sellProduct(product_name, quantity);
			}
			
			else if(choice == 5) {
				
				//operation #5 : show list of all products
				stock.showProductList();
			}
			
			else if(choice == 6) {
				
				//operation #6 : see total available balance
				stock.showAvailablebalance();
			}
			
			else if(choice == 0) {
				//exit command line
				System.out.println("============= Exit Command Line ===============");
				System.exit(0);
			}
			
			else {
				System.out.println("Please Enter a correct choice (from 0 to 6)");
			}
			
		}
		
	}
	
}
