import java.io.*;

public class StudentFileProcessor {

    public static void main(String[] args) {
        try {
            processStudentFile("students.txt", "results.txt");
            System.out.println("Processing completed. Check 'results.txt' for output.");
        } catch (IOException e) {
            System.err.println("An error occurred during file processing: " + e.getMessage());
        }
    }

    public static void processStudentFile(String inputFile, String outputFile) throws IOException {
        
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");

                    if (parts.length != 3) {
                        throw new IllegalArgumentException("Invalid data format");
                    }

                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int marks;

                    try {
                        marks = Integer.parseInt(parts[2].trim());
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Invalid marks format");
                    }

                    String grade = calculateGrade(marks);
                    writer.write(id + "," + name + "," + marks + "," + grade);
                    writer.newLine();

                } catch (Exception e) {
                    writer.write("Error in record: " + line);
                    writer.newLine();
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Input file not found: " + inputFile);
        } catch (IOException e) {
            throw new IOException("Error reading or writing file");
        }
    }

    // Grade calculation
    public static String calculateGrade(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks out of range: " + marks);
        }

        if (marks >= 90) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }
}
