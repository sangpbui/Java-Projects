import java.util.Scanner;

public class Bank {
	private BankAccount[] accounts;
	private int numberCustomers;

	public Bank(int bankSize) {
		accounts = new BankAccount[bankSize];
		numberCustomers = 0;
	}

	private BankAccount[] getAccounts() {
		return accounts.clone();
	}

	private BankAccount getAccount(int accountNumber) {
		for(int i = 0; i < numberCustomers; i++) {
			if(accounts[i].getAccountNumber() == accountNumber) {
				return accounts[i];
			}
		}
		return null;
	}

	private int getNumberCustomers() {
		return numberCustomers;
	}

	private static boolean elementExistsInArray(int[] array, int element) {
		for(int i : array) {
			if(i == element) {
				return true;
			}
		}
		return false;
	}

	private int addAccount(String name, String address, double balance) {
		if(accounts.length > numberCustomers) {
			int[] accountNumbers = new int[numberCustomers];
			for(int i = 0; i < numberCustomers; i++) {
				accountNumbers[i] = accounts[i].getAccountNumber();
			}

			int number;
			do {
				number = (int)(Math.random() * 1000000);
			} while(elementExistsInArray(accountNumbers, number));

			accounts[numberCustomers] = new BankAccount(name, address, number, balance);
			numberCustomers++;
			return number;
		}
		return -1;
	}

	private String showAccount(int accountNumber) {
		BankAccount account = getAccount(accountNumber);
		return "- Name:    " + account.getAccountName() + " -\n- Address: " + account.getAddress() + " -\n- Balance: $" + String.format("%.2f", account.getBalance()) + " -";
	}

	private boolean makeDeposit(int accountNumber, double amt) {
		BankAccount account = getAccount(accountNumber);
		account.deposit(amt);
		System.out.println("- Your new balance is $" + String.format("%.2f", account.getBalance()) + " -");
		return true;
	}

	private boolean makeWithdrawal(int accountNumber, double amt) {
		BankAccount account = getAccount(accountNumber);
		if(!account.withdraw(amt)) {
			System.out.println("- Unable to withdraw $" + String.format("%.2f", amt) + " -\n- Your current balance is $" + String.format("%.2f", account.getBalance()) + " -");
			return false;
		}

		System.out.println("- Your new balance is $" + String.format("%.2f", account.getBalance()) + " -");
		return true;
	}

	public void manageCustomers() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Bank! Type any of the following commands to start.");
		System.out.println("\tAdd - Add an account to the bank");
		System.out.println("\tInfo - View the information for an account");
		System.out.println("\tDeposit - Deposit money into an account");
		System.out.println("\tWithdraw - Withdraw money from an account");
		System.out.println("\tExit - Exit the bank");

		while(true) {
			System.out.print("> ");
			String input = scanner.next().toLowerCase();

			if(input.equals("exit")) {
				System.out.println("Goodbye!");
				break;
			}

			if(input.equals("add")) {
				if(accounts.length > numberCustomers) {
					System.out.print("Please enter your name: ");
					String name = scanner.next();
					System.out.print("Please enter your address: ");
					String address = scanner.next();
					System.out.println("Your account number is: " + addAccount(name, address, 0));
				}
				else {
					System.out.println("Sorry, the bank is at max capacity.");
				}
			}
			else if(input.equals("deposit") || input.equals("withdraw") || input.equals("info")) {
				System.out.print("Please enter your account number: ");
				int accountNumber = scanner.nextInt();

				int[] accountNumbers = new int[numberCustomers];
				for(int i = 0; i < numberCustomers; i++) {
					accountNumbers[i] = accounts[i].getAccountNumber();
				}
				while(!elementExistsInArray(accountNumbers, accountNumber)) {
					System.out.print("- Account not found. -\nPlease enter your account number: ");
					accountNumber = scanner.nextInt();
				}

				if(input.equals("deposit")) {
					System.out.print("Please enter the deposit amount: ");
					double deposit = scanner.nextDouble();
					makeDeposit(accountNumber, deposit);
				}
				else if(input.equals("withdraw")) {
					System.out.print("Please enter the withdrawal amount: ");
					double withdrawal = scanner.nextDouble();
					makeWithdrawal(accountNumber, withdrawal);
				}
				else if(input.equals("info")) {
					System.out.println(showAccount(accountNumber));
				}
			}
		}
	}

	public String toString() {
		String output = "";
		for(int i = 0; i < numberCustomers; i++) {
			output += "- Account Number: " + accounts[i].getAccountNumber() + " -\n\tName:    " + accounts[i].getAccountName() + "\n\tAddress: " + accounts[i].getAddress() + "\n\tBalance: $" + String.format("%.2f", accounts[i].getBalance()) + "\n";
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter bank capacity: ");
		Bank bank = new Bank(scanner.nextInt());
		bank.manageCustomers();
	}
}
