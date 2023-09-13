package KI.Chaus.Lab3;

public class MilitaryAlpinistEquipmentApp {
    public static void main(String[] args) {
        MilitaryAlpinistEquipment militaryEquipment = new MilitaryAlpinistEquipment();
        militaryEquipment.clearLogFile();
        
        militaryEquipment.addItem("Climbing Rope", 2, 3.5);
        militaryEquipment.addItem("Carabiner", 10, 0.15);
        
        militaryEquipment.updateItem("Climbing Rope", 3, 4.0);
        
        militaryEquipment.displayInventory();
        System.out.println("Total Weight: " + militaryEquipment.getTotalWeight() + " kg");
        
        System.out.println("Quantity of Climbing Rope: " + militaryEquipment.getQuantity("Climbing Rope"));
        
        if (militaryEquipment.containsItem("Helmet")) {
            System.out.println("Helmet is in inventory.");
        } else {
            System.out.println("Helmet is not in inventory.");
        }
        
        militaryEquipment.removeItem("Climbing Rope", 2);
        militaryEquipment.displayInventory();
        System.out.println("Total Weight: " + militaryEquipment.getTotalWeight() + " kg");
        militaryEquipment.removeAllItems();
        
        militaryEquipment.enableNightVision();
        militaryEquipment.performMilitaryAction();
    }
}
