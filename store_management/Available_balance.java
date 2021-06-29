package store_management;

public class Available_balance {

	static int available_balance = 0; /*available balance of the shop depends on all buying and selling. So available balance is kept static.
									  and initial available balance is 0. */
	
	static int getAvailableBalance() {
		return available_balance;
	}
	
	//update available balance after buying and selling products.
	static void updateAvailableBalance(int amount) {
		available_balance = available_balance + amount;
	}
	
	/*static void decreaseAvailableBalance(int amount) {
		available_balance = available_balance + amount;
	} */
}
