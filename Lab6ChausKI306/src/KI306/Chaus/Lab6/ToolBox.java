package KI306.Chaus.Lab6;
import java.util.ArrayList;

// Define a class named ToolBox that can hold objects of type Tool or its subtypes
class ToolBox<T extends Tool> {
    private ArrayList<T> tools; // ArrayList to store tools

    // Constructor for ToolBox
    public ToolBox() {
        tools = new ArrayList<>(); // Initialize the ArrayList of tools
    }

    // Find and return the smallest tool based on comparison
    public T findMin() {
        if (!tools.isEmpty()) {
            T min = tools.get(0);
            for (int i = 1; i < tools.size(); i++) {
                if (tools.get(i).compareTo(min) < 0)
                    min = tools.get(i);
            }
            return min;
        }
        return null;
    }

    // Add a tool to the toolbox
    public void addTool(T tool) {
        tools.add(tool);
        System.out.print("tool added: ");
        tool.print(); // Print information about the added tool
    }

    // Remove a tool at a specified index
    public void removeTool(int i) {
        if (i >= 0 && i < tools.size()) {
            tools.remove(i);
            System.out.println("Tool removed at index " + i);
        } else {
            System.out.println("Invalid index. Cannot remove tool.");
        }
    }

    // Print information about the tools in the toolbox
    public void printContents() {
        if (!tools.isEmpty()) {
            for (T tool : tools) {
                tool.print(); // Print information about each tool
            }
        } else {
            System.out.println("Tool box is empty. No tools available.");
        }
    }
}

// Define a class named Screwdriver that implements the Tool interface
class Screwdriver implements Tool {
    private String screwdriverType;
    private String screwdriverBrand;
    private double screwdriverCost;
    private int screwdriverSize;

    // Constructor for Screwdriver
    public Screwdriver(String sType, String sBrand, double sCost, int sSize) {
        screwdriverType = sType;
        screwdriverBrand = sBrand;
        screwdriverCost = sCost;
        screwdriverSize = sSize;
    }

    // Getter and setter methods for screwdriver properties

    public String getScrewdriverType() {
        return screwdriverType;
    }

    public void setScrewdriverType(String type) {
        screwdriverType = type;
    }

    public String getScrewdriverBrand() {
        return screwdriverBrand;
    }

    public void setScrewdriverBrand(String brand) {
        screwdriverBrand = brand;
    }

    public double getScrewdriverCost() {
        return screwdriverCost;
    }

    public void setScrewdriverCost(double cost) {
        screwdriverCost = cost;
    }

    public void setScrewdriverSize(int size) {
        screwdriverSize = size;
    }

    // Implement the getSize method from the Tool interface
    public int getSize() {
        return screwdriverSize;
    }

    // Implement the compareTo method from the Comparable interface
    public int compareTo(Tool tool) {
        Integer s = screwdriverSize;
        return s.compareTo(tool.getSize());
    }

    // Print information about the screwdriver
    public void print() {
        System.out.println("[Screwdriver]");
        System.out.println("  Type: " + screwdriverType);
        System.out.println("  Brand: " + screwdriverBrand);
        System.out.println("  Cost: " + screwdriverCost + " $");
        System.out.println("  Size: " + screwdriverSize);
        System.out.println();
    }
}

// Define a class named Wrench that implements the Tool interface
class Wrench implements Tool {
    private String wrenchBrand;
    private int wrenchWeight;
    private int wrenchSize;

    // Constructor for Wrench
    public Wrench(String wBrand, int wWeight, int wSize) {
        wrenchBrand = wBrand;
        wrenchWeight = wWeight;
        wrenchSize = wSize;
    }

    // Getter and setter methods for wrench properties

    public String getWrenchBrand() {
        return wrenchBrand;
    }

    public void setWrenchBrand(String brand) {
        wrenchBrand = brand;
    }

    public int getWrenchWeight() {
        return wrenchWeight;
    }

    public void setWrenchWeight(int weight) {
        wrenchWeight = weight;
    }

    public void setWrenchSize(int size) {
        wrenchSize = size;
    }

    // Implement the getSize method from the Tool interface
    public int getSize() {
        return wrenchSize;
    }

    // Implement the compareTo method from the Comparable interface
    public int compareTo(Tool tool) {
        Integer s = wrenchSize;
        return s.compareTo(tool.getSize());
    }

    // Print information about the wrench
    public void print() {
        System.out.println("[Wrench]");
        System.out.println("  Brand: " + wrenchBrand);
        System.out.println("  Weight: " + wrenchWeight);
        System.out.println("  Size: " + wrenchSize);
        System.out.println();
    }
}

