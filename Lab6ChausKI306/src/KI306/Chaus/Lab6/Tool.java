package KI306.Chaus.Lab6; 
// Specifies the package name

interface Tool extends Comparable<Tool> {
    // Defines an interface named Tool that extends Comparable for comparison

    int getSize();
    // Declares a method 'getSize' that returns an integer

    void print();
    // Declares a method 'print' with no return value
}

interface Tool1<T> {
    // Defines a generic interface Tool1

    public void print_data(T data);
    // Declares a method 'print_data' that takes a generic parameter 'data'
}
