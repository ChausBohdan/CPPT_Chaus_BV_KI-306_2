package KI306.Chaus.Lab4;

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner; // Added import statement

/**
 * This class demonstrates the usage of the Equations class by taking user input for 'x',
 * calculating the result, and saving it to a file named Result.txt.
 */
public class EquationsApp {
    public static void main(String[] args) {
        String fName = "Result.txt";

        PrintWriter fout = null; // PrintWriter for writing to the file

        try {
            fout = new PrintWriter(new File(fName)); // Initialize PrintWriter

            Equations eq = new Equations(); // Create an instance of the Equations class

            Scanner in = new Scanner(System.in); // Scanner for user input

            out.print("Enter X: ");
            int x = in.nextInt(); // Read user input for 'x'

            try {
                double result = eq.calculate(x); // Calculate the result
                out.println("Result: " + result); // Print the result to console
                fout.print(result); // Write the result to the file
                fout.flush(); // Flush the PrintWriter to ensure data is written
            } catch (NegativeNumberException ex) {
                out.print(ex.getMessage()); // Handle NegativeNumberException
            } catch (CalcException ex) {
                out.print(ex.getMessage()); // Handle CalcException
            }
            in.close(); // Close the Scanner
        } catch (FileNotFoundException ex) {
            out.print("Exception reason: File not found"); // Handle FileNotFoundException
        } finally {
            if (fout != null) {
                fout.close(); // Close the PrintWriter if it's not null
            }
        }
    }
}
