import java.util.Scanner;

class calculatorException
{ 
    public static int num1, num2, result;
    
    public void sum() 
    {
        result = num1 + num2; 
        System.out.println("Result of addition: " + result);
    }
    
    public void sub() 
    {
        result = num1 - num2; 
        System.out.println("Result of subtraction: " + result);
    } 
    
    public void div() {
    try{

        {     
            result = num1 / num2; 
            System.out.println("Result of division: " + result);
            
        }

    }
    catch(ArithmeticException e)
    {
        System.out.println("Division by zero is not allowed.");
    }
}

    
    public void mul() 
    {        
        result = num1 * num2; 
        System.out.println("Result of multiplication: " + result);
    }

    public static void main(String[] args) 
    {
        Scanner ob = new Scanner(System.in); 
        try{
    	
        System.out.println("Enter num1:");
        num1 = ob.nextInt(); 
        System.out.println("Enter num2:");
        num2 = ob.nextInt(); 
        }
        catch(Exception e)
        {
            System.out.println("Please enter valid numbers.");
            return;
        }
        
        try{
        calculatorException cal = new calculatorException();
        int operation;
        System.out.println("1. Sum\n2. Sub\n3. Div\n4. Mul");
        
        operation = ob.nextInt();
        switch(operation)
        {
            case 1:
                cal.sum();
                break;

            case 2:
                cal.sub();
                break;

            case 3:
                cal.div();
                break;

            case 4:
                cal.mul();
                break;

            default:
                System.out.println("Enter correct operation:");
        }
    }
        catch(Exception e)
        {
            System.out.println("Please enter valid operation.");
        }
        finally
        {
            ob.close();
        }
    }
}

