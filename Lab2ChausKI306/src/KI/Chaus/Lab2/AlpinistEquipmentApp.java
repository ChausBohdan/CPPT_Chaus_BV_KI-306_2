/**
 * 
 */
package KI.Chaus.Lab2;

/**
 * 
 */
class Main {
    public static void main(String[] args) {
    	AlpinistEquipment equipment1 = new AlpinistEquipment();
    	equipment1.addItem("Climbing Rope1", 2, 3.5);
    	AlpinistEquipment equipment2 = new AlpinistEquipment();
    	equipment2.addItem("Climbing Rope2", 2, 3.5); 
    	AlpinistEquipment equipment3 = new AlpinistEquipment();
    	equipment3.addItem("Climbing Rope3", 2, 3.5); 
    	f1();
    	System.out.println(AlpinistEquipment.List1); //Climbing Rope1,Climbing Rope2,Climbing Rope3,Climbing Rope4
//    	equipment1.displayAllInventoryNames();
        /*equipment.clearLogFile();
        
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
        equipment.removeAllItems();*/
    }
    public static void f1()
    {
    	AlpinistEquipment equipment4 = new AlpinistEquipment();
    	equipment4.addItem("Climbing Rope4", 2, 3.5); 
    }
}
