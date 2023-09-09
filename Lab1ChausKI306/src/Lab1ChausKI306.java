import java.io.*;
import java.util.*;

/**
 * The Lab1ChausKI306 class implements an example program for laboratory work #1.
 * 
 * @author Chaus Bohdan
 * @version 1.0
 * @since version 1.0
 */
public class Lab1ChausKI306 {
    /**
     * Generates a jagged array with a specified size and symbol.
     * 
     * @param size   The size of the square matrix.
     * @param symbol The character used to fill the matrix.
     * @return The jagged array.
     */
    public static char[][] generateJaggedArr(int size, char symbol) {
        char[][] jaggedArr = new char[size][];

        for (int i = 0; i < size; i++) {
            jaggedArr[i] = new char[i + 1];
            Arrays.fill(jaggedArr[i], ' ');
        }

        for (int i = size / 2; i < size; i++) {
            int spaces = Math.abs(i - size + 1);
            for (int j = spaces; j < (size - spaces); j++) {
                jaggedArr[i][j] = symbol;
            }
        }

        return jaggedArr;
    }

    /**
     * The entry point of the program.
     * 
     * @param args The command-line arguments (not used).
     * @throws FileNotFoundException Exception thrown if the file is not found.
     */
    public static void main(String[] args) throws FileNotFoundException {
        int nRows;        // Number of rows in the matrix
        char[][] arr;     // Jagged array
        char filler = ' '; // Character for filling the matrix
        Scanner in = new Scanner(System.in); // Object for reading input

        // Prompt the user for the size of the square matrix
        System.out.print("Enter size of square matrix: ");
        nRows = in.nextInt();
        in.nextLine(); // Clear the buffer

        // Prompt the user for the character to fill the matrix
        System.out.print("Enter character to fill matrix: ");
        filler = in.next().charAt(0);

        if (filler != ' ') { // If a character is specified
            arr = generateJaggedArr(nRows, filler); // Generate the matrix
            printArray(arr); // Print the matrix to the screen
            writeToTextFile(arr); // Write the matrix to a file
        }
        else if (filler == ' ') {
        	System.out.println("\nNo character entered placeholder");
        }
        else {
            System.out.println("\nToo many characters fillers");
        }
    }

    /**
     * Prints the jagged array to the screen.
     * 
     * @param arr The jagged array.
     */
    public static void printArray(char[][] arr) {
        for (char[] row : arr) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /**
     * Writes the jagged array to a text file.
     * 
     * @param arr The jagged array.
     */
    public static void writeToTextFile(char[][] arr) {
        try (PrintWriter fout = new PrintWriter("MyFile.txt")) {
            for (char[] row : arr) {
                for (char c : row) {
                    fout.print(c + " ");
                }
                fout.println();
            }
            System.out.println("\nData written to MyFile.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
    }
}