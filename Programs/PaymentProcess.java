abstract class Payment{

    private float amount;

    public Payment(float amount){

        this.amount = amount;
    }

    public abstract void process();

    public void displayAmount(){

        System.out.println("Amount is : " + amount);
    }
}

class CreditCardPayment extends Payment{

    public CreditCardPayment(float amount){

        super(amount);
    }

    public void process(){

        System.out.println("Processing via credit card...");
    }
}

class DebitCardPayment extends Payment{

    public DebitCardPayment(float amount){

        super(amount);
    }

    public void process(){

        System.out.println("Processing via debit card...");
    }

}



class PaymentProcess{

    public static void main(String[] args) {
        
            Payment[] payments = new Payment[2];

            payments[0] = new CreditCardPayment(1000F);
            payments[1] = new DebitCardPayment(2000F);

            for (Payment p : payments){

                p.displayAmount();
                p.process();
                System.out.println();
            }


    }
}