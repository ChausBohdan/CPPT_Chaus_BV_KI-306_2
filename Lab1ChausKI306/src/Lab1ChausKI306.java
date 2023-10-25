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
        char symbol2 = '+';

        for (int i = size/2; i < size; i++) {
            jaggedArr[i] = new char[i+1];
        }
        for (int i = size / 2; i < size; i++) {
        	
        		int spaces = Math.abs(i - size + 1);
                for (int j = spaces; j < (size - spaces); j++) {
                	if(j == size/2 && size % 2 == 1) {
                		
                    jaggedArr[i][j] = symbol2;
                }
                	else if(j== size/2 && size % 2 == 0) {
                		jaggedArr[i][j] = symbol2;
                		jaggedArr[i][j-1] = symbol2;
                		}
                	else {
                		jaggedArr[i][j] = symbol;
                	}
                	
                	}
            }
        return jaggedArr;
        }

        

    /**
     * The entry point of the program.
     * 
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
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
        } else {
            System.out.println("\nNo character entered. Placeholder");
        }
        in.close();
    }

    /**
     * Prints the jagged array to the screen.
     * 
     * @param arr The jagged array.
     */
    public static void printArray(char[][] arr) {
        for (char[] row : arr) {
            if (row == null || row.length == 0) {
                System.out.println();
            } else {
                for (char c : row) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
        }
    }


    /**
     * Writes the jagged array to a text file.
     * 
     * @param arr The jagged array.
     */

 public static void writeToTextFile(char[][] arr) {
     try (RandomAccessFile file = new RandomAccessFile("MyFile.txt", "rw")) {
         for (char[] row : arr) {
             if (row == null || row.length == 0) {
                 file.writeBytes("\n");
             } else {
                 for (char c : row) {
                     char toWrite = (c == '+') ? ' ' : c; // Replace '+' with ' '
                     file.writeBytes(toWrite + " ");
                 }
                 file.writeBytes("\n");
             }
         }
         System.out.println("\nData written to MyFile.txt");
     } catch (IOException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }


}