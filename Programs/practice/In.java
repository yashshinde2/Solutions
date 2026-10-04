
import java.io.*;

class In{

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a string :");
        String text = reader.readLine();

        System.out.print("Enter a number: ");
        int number = Integer.parseInt(reader.readLine());

        System.out.println("You entered: " + text);
        System.out.println("You entered: " + number);

    }
}