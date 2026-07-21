import java.util.Scanner;

class bank {

  int accountNumber;
  String holderName;
  int balance;

  
  public bank() {
    accountNumber = 1234;
    holderName = "Yash";
    balance = 1000;
  }

  
  public void display() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Account Holder: " + holderName);
    System.out.println("Balance: " + balance);
  }


  public void deposit(int amount) {
    if (amount > 0) {
      balance += amount;
      System.out.println("Deposited: " + amount);
    } else {
      System.out.println("Wrong amount");
    }
  }


  public void withdraw(int amount) {
    if (amount > 0 && amount <= balance) {
      balance -= amount;
      System.out.println("Withdraw: " + amount);
      }
   else {
      System.out.println("Wrong amount");
    }
  }

 
  public static void main(String args[]) {
    Scanner bn = new Scanner(System.in);

   
    bank bankAccount = new bank();

  
    bankAccount.display();

   
    while (true) {
      System.out.println("\n Choose an option:");
      System.out.println("1. Deposit");
      System.out.println("2. Withdraw");
      System.out.println("3. Display");
      System.out.println("4. Exit");

      int choice = bn.nextInt();

      switch (choice) {
        case 1:
         
          System.out.print("Enter amount for deposit: ");
          int depositAmount = bn.nextInt();
          bankAccount.deposit(depositAmount);
          break;

        case 2:
        
          System.out.print("Enter amount for withdraw: ");
          int withdrawAmount = bn.nextInt();
          bankAccount.withdraw(withdrawAmount);
          break;

        case 3:
          
          bankAccount.display();
          break;

        case 4:
         
          bn.close();
          return;

        default:
          
          System.out.println("Invalid choice,try again...");
      }
    }
  }
}

