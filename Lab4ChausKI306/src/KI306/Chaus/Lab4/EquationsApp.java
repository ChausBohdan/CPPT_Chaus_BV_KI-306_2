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

        PrintWriter fout = null;

        try {
            fout = new PrintWriter(new File(fName));

            Equations eq = new Equations();

            Scanner in = new Scanner(System.in);

            out.print("Enter X: ");
            int x = in.nextInt();

            try {
                double result = eq.calculate(x);
                out.println("Result: " + result);
                fout.print(result);
                fout.flush();
            } catch (NegativeNumberException ex) {
                out.print(ex.getMessage());
            } catch (CalcException ex) {
                out.print(ex.getMessage());
            }
            in.close();
        } catch (FileNotFoundException ex) {
            out.print("Exception reason: File not found");
        } finally {
            if (fout != null) {
                fout.close();
            }
        }
    }
}

