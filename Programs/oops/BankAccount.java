class BankAccount{

    private long accountNumber;
    private float accountBalance;
    private String accountHolderName;

    public BankAccount(long accountNumber, float accountBalance, String accountHolderName){

        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountHolderName = accountHolderName;

    }

    public void displayAccountInfo(){

        System.out.println(accountHolderName + " " + accountNumber + " " + accountBalance);
    }

    public static void main(String[] args) {
        
        BankAccount b1 = new BankAccount(12345678, 50000.0F, "Yash");

        b1.displayAccountInfo();


    }

}