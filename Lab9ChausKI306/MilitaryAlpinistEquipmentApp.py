from MilitaryAlpinistEquipment import MilitaryAlpinistEquipment

def main():
    # Create an instance of MilitaryAlpinistEquipment
    military_equipment = MilitaryAlpinistEquipment()
    
    # Clear the log file
    military_equipment.clear_log_file()
    
    # Add items to the inventory
    military_equipment.add_item("Climbing Rope", 2, 3.5)
    military_equipment.add_item("Carabiner", 10, 0.15)
    
    # Update the quantity and weight of an item
    military_equipment.update_item("Climbing Rope", 3, 4.0)
    
    # Display the inventory and total weight
    military_equipment.display_inventory()
    print("Total Weight:", military_equipment.get_total_weight(), "kg")
    
    # Get the quantity of a specific item
    print("Quantity of Climbing Rope:", military_equipment.get_quantity("Climbing Rope"))
    
    # Check if an item is in the inventory
    if military_equipment.contains_item("Helmet"):
        print("Helmet is in inventory.")
    else:
        print("Helmet is not in inventory.")
    
    # Remove a specified quantity of an item
    military_equipment.remove_item("Climbing Rope", 2)
    military_equipment.display_inventory()
    print("Total Weight:", military_equipment.get_total_weight(), "kg")
    
    # Remove all items from the inventory
    military_equipment.remove_all_items()
    
    # Enable night vision and perform a military action
    military_equipment.enable_night_vision()
    military_equipment.perform_military_action()

if __name__ == "__main__":
    main()
