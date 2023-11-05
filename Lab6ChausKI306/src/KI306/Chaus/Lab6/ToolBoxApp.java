package KI306.Chaus.Lab6;

public class ToolBoxApp {
    public static void main(String[] args) {
        // Create a ToolBox with tools that are of type Tool or its super type
        ToolBox<? super Tool> suitcase = new ToolBox<>();

        // Add Screwdrivers and Wrenches to the suitcase ToolBox
        suitcase.addTool(new Screwdriver("Phillips", "ExampleBrand", 25.99, 6));
        suitcase.addTool(new Screwdriver("Philp", "randI", 1.19, 11));
        suitcase.addTool(new Wrench("ExampleBrand", 500, 12));
        suitcase.addTool(new Wrench("LightTools", 300, 8));
        suitcase.addTool(new Wrench("BigTools", 700, 24));

        // Remove a tool from the suitcase ToolBox
        suitcase.removeTool(3);

        // Print the contents of the suitcase ToolBox
        System.out.print("\nContents of Tool Box: \n");
        suitcase.printContents();

        // Find and print the smallest tool in the suitcase ToolBox
        Tool minTool = suitcase.findMin();
        System.out.print("\nThe smallest tool in the Tool box is: ");
        minTool.print();

        // Create an instance of MyTool with String type and print a message
        MyTool<String> stringTool = new MyTool<>();
        stringTool.print_data("Hello, World!");

        // Create an instance of MyTool with Integer type and print a number
        MyTool<Integer> integerTool = new MyTool<>();
        integerTool.print_data(42);
    }
}
