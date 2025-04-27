package practice;
import java.util.Scanner;
class InsufficientBalanceException extends Exception {
		   public InsufficientBalanceException(String message) {
		       super(message);
		   }
		}
		class BankAccount {
		   private double balance;
		   public BankAccount(double initialBalance) {
		       this.balance = initialBalance;
		   }
		   public void withdraw(double amount) throws InsufficientBalanceException {
		       if (amount < 0) {
		           throw new IllegalArgumentException("Invalid amount!");
		       } else if (amount > balance) {
		           throw new InsufficientBalanceException("Insufficient balance!");
		       } else {
		           balance -= amount;
		           System.out.println("Withdrawal successful, new balance: " + balance);
		       }
		   }
		}
public class BankAccountSystem {
	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       System.out.print("Enter initial balance: ");
	       double initialBalance = sc.nextDouble();
	       BankAccount account = new BankAccount(initialBalance);
	       System.out.print("Enter withdrawal amount: ");
	       double amount = sc.nextDouble();
	       try {
	           account.withdraw(amount);
	       } catch (InsufficientBalanceException e) {
	           System.out.println(e.getMessage());
	       } catch (IllegalArgumentException e) {
	           System.out.println(e.getMessage());
	       }
	   }
}
