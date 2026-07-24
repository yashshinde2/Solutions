import java.io.FileWriter;
import java.io.IOException;

class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("output.txt");
            
            fw.write("Hello!\n");
            fw.write("Hello I am Yash \n");
            
            fw.close();
            
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}