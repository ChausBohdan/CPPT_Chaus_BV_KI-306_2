/**
 * 
 */
package KI.Chaus.Lab2;
// import KI.Chaus.Lab2.*;

/**
 * 
 */
class Main {
    public static void main(String[] args) {
    	AlpinistEquipment equipment = new AlpinistEquipment();
        equipment.clearLogFile();
        
        equipment.addItem("Climbing Rope", 2, 3.5);
        equipment.addItem("Carabiner", 10, 0.15);
        
        equipment.updateItem("Climbing Rope", 3, 4.0);
        
        equipment.displayInventory();
        System.out.println("Total Weight: " + equipment.getTotalWeight() + " kg");
        
        System.out.println("Quantity of Climbing Rope: " + equipment.getQuantity("Climbing Rope"));
        
        if (equipment.containsItem("Helmet")) {
            System.out.println("Helmet is in inventory.");
        } else {
            System.out.println("Helmet is not in inventory.");
        }
        
        equipment.removeItem("Climbing Rope", 2);
        equipment.displayInventory();
        System.out.println("Total Weight: " + equipment.getTotalWeight() + " kg");
        equipment.removeAllItems();
    }
}
