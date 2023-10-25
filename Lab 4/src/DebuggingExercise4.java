// This class demonstrates a debugging exercise with an Account class.
public class DebuggingExercise4 {
    public static void main(String[] args) {
        // Create an Account object with an owner name
        Account a = new Account("John Doe");

        // Deposit $100 into the account
        a.deposit(100);
        System.out.println(a.getOwner() + " has $" + a.getBalance());

        // Try to withdraw $200 from the account
        a.withdraw(200);
        System.out.println("After trying to withdraw $200, " + a.getOwner() + " has $" + a.getBalance());
    }
}
