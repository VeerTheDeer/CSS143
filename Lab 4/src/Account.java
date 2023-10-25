/**
 * Account.java
 *
 * This Account class represents bank accounts that store money for an owner.
 *
 * Author: Veer Saini
 */
class Account {
	// Instance variables
	private double balance; // Invariant: balance >= 0 (should never be negative)
	private String owner;

	// Constructor
	public Account(String name) {
		balance = 0;
		owner = name;
	}

	// Instance methods

	/**
	 * Deposits 'amount' into the account.
	 *
	 * @param amount The amount to deposit. Must be a positive value.
	 */
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		} else {
			System.out.println("Invalid deposit amount. Amount must be positive.");
		}
	}

	/**
	 * Withdraws 'amount' from the account.
	 * This only makes sense if amount <= balance.
	 *
	 * @param amount The amount to withdraw. Must be a positive value.
	 */
	public void withdraw(double amount) {
		if (amount > 0) {
			if (amount <= balance) {
				balance -= amount;
			} else {
				System.out.println("Insufficient funds. Withdrawal amount exceeds balance.");
			}
		} else {
			System.out.println("Invalid withdrawal amount. Amount must be positive.");
		}
	}

	/* Returns the balance of the Account
	 */
	public double getBalance() {
		return balance;
	}

	/* Returns the owner of the Account
	 */
	public String getOwner() {
		return owner;
	}
}
