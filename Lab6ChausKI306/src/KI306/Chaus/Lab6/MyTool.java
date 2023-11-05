package KI306.Chaus.Lab6; // Specifies the package name

import java.util.ArrayList; // Imports the ArrayList class from the java.util package

public class MyTool<T> implements Tool1<T> {
    // Defines a generic class MyTool that implements the Tool1 interface

    @Override
    public void print_data(T data) {
        // Overrides the method defined in the Tool1 interface to print generic data
        System.out.println(data); // Prints the value of 'data'
    }

    public void print_data(int prefix) {
        // Defines a method to print an integer value (prefix)
        System.out.println(prefix); // Prints the value of 'prefix'
    }

    public void print_data(char suffix) {
        // Defines a method to print a character value (suffix)
        System.out.println(suffix); // Prints the value of 'suffix'
    }
}
