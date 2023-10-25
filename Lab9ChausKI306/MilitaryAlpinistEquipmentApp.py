from MilitaryAlpinistEquipment import MilitaryAlpinistEquipment

def main():
    military_equipment = MilitaryAlpinistEquipment()
    military_equipment.clear_log_file()
    
    military_equipment.add_item("Climbing Rope", 2, 3.5)
    military_equipment.add_item("Carabiner", 10, 0.15)
    
    military_equipment.update_item("Climbing Rope", 3, 4.0)
    
    military_equipment.display_inventory()
    print("Total Weight:", military_equipment.get_total_weight(), "kg")
    
    print("Quantity of Climbing Rope:", military_equipment.get_quantity("Climbing Rope"))
    
    if military_equipment.contains_item("Helmet"):
        print("Helmet is in inventory.")
    else:
        print("Helmet is not in inventory.")
    
    military_equipment.remove_item("Climbing Rope", 2)
    military_equipment.display_inventory()
    print("Total Weight:", military_equipment.get_total_weight(), "kg")
    military_equipment.remove_all_items()
    
    military_equipment.enable_night_vision()
    military_equipment.perform_military_action()

if __name__ == "__main__":
    main()
