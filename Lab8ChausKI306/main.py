from AlpinistEquipment import AlpinistEquipment

def main():
    equipment1 = AlpinistEquipment()
    equipment1.add_item("Climbing Rope1", 2, 3.5)

    equipment2 = AlpinistEquipment()
    equipment2.add_item("Carabiner", 3, 3.5)

    equipment1.display_inventory()  # Display the inventory of equipment1

    equipment1.clear_log_file()

    equipment1.add_item("Climbing Rope", 2, 3.5)
    equipment1.add_item("Carabiner", 10, 0.15)
    
    equipment1.update_item("Climbing Rope", 3, 4.0)

    equipment1.display_inventory()
    print("Total Weight:", equipment1.get_total_weight(), "kg")

    print("Quantity of Climbing Rope:", equipment1.get_quantity("Climbing Rope"))

    if equipment1.contains_item("Helmet"):
        print("Helmet is in inventory.")
    else:
        print("Helmet is not in inventory.")

    equipment1.remove_item("Climbing Rope", 2)
    equipment1.display_inventory()
    print("Total Weight:", equipment1.get_total_weight(), "kg")

    equipment1.remove_all_items()


if __name__ == "__main__":
    main()
