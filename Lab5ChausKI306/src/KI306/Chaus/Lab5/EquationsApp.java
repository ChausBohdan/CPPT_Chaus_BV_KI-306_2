package KI306.Chaus.Lab5;

import java.io.*;
import static java.lang.System.out;
import java.util.Scanner; // Added import statement
import java.io.BufferedReader;
import java.io.DataInputStream;

/**
 * This class demonstrates the usage of the Equations class by taking user input for 'x',
 * calculating the result, and saving it to a file named Result.txt.
 */
public class EquationsApp {
    public static void main(String[] args) throws IOException {
        String fName = "Result.txt";
        String out_file_bin = "Out_binary.dat";
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
                DataOutputStream fout_bin = new DataOutputStream(new FileOutputStream(out_file_bin));
                fout_bin.writeChars("Result " + result + "\n");
                fout_bin.close();
            }  catch (CalcException ex) {
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

        // Reading from files
        BufferedReader fin = null;
        DataInputStream fin_bin = null;

        try {
            fin = new BufferedReader(new FileReader(fName));
            fin_bin = new DataInputStream(new FileInputStream(out_file_bin));

            String resultText = fin.readLine();
            String binaryResult = fin_bin.readLine();

            System.out.println("Result from Result.txt: " + resultText);
            System.out.println("Result from Out_binary.dat: " + binaryResult);
        } catch (FileNotFoundException ex) {
            System.out.println("Exception reason: File not found");
        } catch (IOException ex) {
            System.out.println("Exception while reading the file");
        } finally {
            try {
                if (fin != null) fin.close();
                if (fin_bin != null) fin_bin.close();
            } catch (IOException e) {
                System.out.println("Exception while closing the file");
            }
        }
    }
}
