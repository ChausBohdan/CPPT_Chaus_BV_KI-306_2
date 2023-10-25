package KI.Chaus.Lab2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents an inventory system for alpinist equipment.
 * It allows adding, removing, updating, and displaying items in the inventory.
 * It also keeps a log of all operations in a file named "log.txt".
 * 
 * @author Chaus Bohdan
 * @version 1.0
 */
public class AlpinistEquipment {
    private Map<String, Integer> quantities;
    private Map<String, Double> weights;
    public String[] itemNames;//зміна
    public int itemCount;//зміна
    public static String List1 = "";
    /**
     * Constructor to initialize the equipment inventory.
     */
    public AlpinistEquipment() {
        quantities = new HashMap<>();
        weights = new HashMap<>();
        itemNames = new String[10];//зміна
        itemCount = 0;//зміна
    }

    /**
     * Adds a specified quantity of an item with its weight to the inventory.
     * 
     * @param itemName The name of the item.
     * @param quantity The quantity of the item to be added.
     * @param weight The weight of a single item in kilograms.
     */
    private void resizeItemNamesArray() {
        String[] newArray = new String[itemNames.length * 2];
        System.arraycopy(itemNames, 0, newArray, 0, itemNames.length);
        itemNames = newArray;
    }
    public void addItem(String itemName, int quantity, double weight) {
    	quantities.put(itemName, quantities.getOrDefault(itemName, 0) + quantity);
        weights.put(itemName, weight);

        if (itemCount == itemNames.length) {//зміна
            resizeItemNamesArray();
        }
        List1 = List1 + itemName + ", ";
        
        itemNames[itemCount] = itemName;
        itemCount++;//зміна
        writeToLogFile("Added " + quantity + " " + itemName + "(s) with a total weight of " + (quantity * weight) + " kg.");
    }
    
    
    /**
     * Removes a specified quantity of an item from the inventory.
     * 
     * @param itemName The name of the item.
     * @param quantity The quantity of the item to be removed.
     */
    public void removeItem(String itemName, int quantity) {
        if (quantities.containsKey(itemName)) {
            int currentQuantity = quantities.get(itemName);
            if (currentQuantity >= quantity) {
                quantities.put(itemName, currentQuantity - quantity);
                writeToLogFile("Removed " + quantity + " " + itemName + "(s).");
            } else {
                System.out.println("Error: Not enough " + itemName + " in inventory.");
            }
        } else {
            System.out.println("Error: " + itemName + " not found in inventory.");
        }
    }

    /**
     * Calculates and returns the total weight of all items in the inventory.
     * 
     * @return The total weight of all items in kilograms.
     */
    public double getTotalWeight() {
        double totalWeight = 0;
        for (String itemName : quantities.keySet()) {
            totalWeight += quantities.get(itemName) * weights.get(itemName);
        }
        return totalWeight;
    }

    /**
     * Displays the current inventory, including item names, quantities, and weights.
     */
    public void displayInventory() {
        System.out.println("Inventory:");
        for (String itemName : quantities.keySet()) {
            System.out.println("Item Name: " + itemName);
            System.out.println("Quantity: " + quantities.get(itemName));
            System.out.println("Weight: " + weights.get(itemName) + " kg");
        }
    }
    public void displayAllInventoryNames() {//зміна
        for (int i = 0; i < itemCount; i++) {
            System.out.println(itemNames[i]);
        }
    }
    
    /**
     * Gets the quantity of a specified item in the inventory.
     * 
     * @param itemName The name of the item.
     * @return The quantity of the item, or 0 if not found.
     */
    public int getQuantity(String itemName) {
        return quantities.getOrDefault(itemName, 0);
    }

    /**
     * Updates the quantity and weight of a specified item in the inventory.
     * 
     * @param itemName The name of the item.
     * @param newQuantity The new quantity of the item.
     * @param newWeight The new weight of a single item in kilograms.
     */
    public void updateItem(String itemName, int newQuantity, double newWeight) {
        quantities.put(itemName, newQuantity);
        weights.put(itemName, newWeight);
        writeToLogFile("Updated " + itemName + " to " + newQuantity + " quantity with a weight of " + newWeight + " kg.");
    }

    /**
     * Removes all items from the inventory.
     */
    public void removeAllItems() {
        quantities.clear();
        weights.clear();
        writeToLogFile("All items removed from inventory.");
    }

    /**
     * Checks if a specified item is present in the inventory.
     * 
     * @param itemName The name of the item.
     * @return true if the item is present, false otherwise.
     */
    public boolean containsItem(String itemName) {
        return quantities.containsKey(itemName);
    }

    /**
     * Clears the contents of the log file.
     */
    public void clearLogFile() {
        File logFile = new File("log.txt");

        try {
            PrintWriter writer = new PrintWriter(logFile);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes a message to the log file.
     * 
     * @param message The message to be written to the log file.
     */
    private void writeToLogFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(new File("log.txt"), true))) {
            writer.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
