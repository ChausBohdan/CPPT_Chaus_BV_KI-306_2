class AlpinistEquipment:
    def __init__(self):
        # Initialize dictionaries to keep track of quantities and weights for items
        self.quantities = {}
        self.weights = {}

        # Initialize an array to store item names, with initial size of 10
        self.item_names = [None] * 10

        # Initialize item count to keep track of how many items are in the inventory
        self.item_count = 0

    def resize_item_names_array(self):
        # Resize the item names array by doubling its size and copying existing items
        new_array = [None] * (len(self.item_names) * 2)
        new_array[:len(self.item_names)] = self.item_names
        self.item_names = new_array

    def add_item(self, item_name, quantity, weight):
        # Add or update item quantity and weight in the respective dictionaries
        if item_name in self.quantities:
            self.quantities[item_name] += quantity
        else:
            self.quantities[item_name] = quantity

        self.weights[item_name] = weight

        # Resize item names array if it's full
        if self.item_count == len(self.item_names):
            self.resize_item_names_array()

        # Log the action of adding an item
        self.write_to_log_file(f"Added {quantity} {item_name}(s) with a total weight of {quantity * weight} kg.")

    def remove_item(self, item_name, quantity):
        # Remove a specified quantity of an item from the inventory
        if item_name in self.quantities:
            current_quantity = self.quantities[item_name]
            if current_quantity >= quantity:
                self.quantities[item_name] -= quantity
                # Log the action of removing an item
                self.write_to_log_file(f"Removed {quantity} {item_name}(s).")
            else:
                print(f"Error: Not enough {item_name} in inventory.")
        else:
            print(f"Error: {item_name} not found in inventory.")

    def get_total_weight(self):
        # Calculate and return the total weight of all items in the inventory
        total_weight = 0
        for item_name in self.quantities:
            total_weight += self.quantities[item_name] * self.weights[item_name]
        return total_weight

    def display_inventory(self):
        # Display the inventory, including item names, quantities, and weights
        print("Inventory:")
        for item_name in self.quantities:
            print(f"Item Name: {item_name}")
            print(f"Quantity: {self.quantities[item_name]}")
            print(f"Weight: {self.weights[item_name]} kg")

    def display_all_inventory_names(self):
        # Display all item names in the inventory
        for i in range(self.item_count):
            print(self.item_names[i])

    def get_quantity(self, item_name):
        # Get the quantity of a specific item in the inventory
        return self.quantities.get(item_name, 0)

    def update_item(self, item_name, new_quantity, new_weight):
        # Update the quantity and weight of a specific item in the inventory
        self.quantities[item_name] = new_quantity
        self.weights[item_name] = new_weight
        # Log the action of updating an item
        self.write_to_log_file(f"Updated {item_name} to {new_quantity} quantity with a weight of {new_weight} kg.")

    def remove_all_items(self):
        # Remove all items from the inventory
        self.quantities.clear()
        self.weights.clear()
        # Log the action of removing all items
        self.write_to_log_file("All items removed from inventory.")

    def contains_item(self, item_name):
        # Check if a specific item is in the inventory
        return item_name in self.quantities

    def clear_log_file(self):
        # Clear the content of the log file
        with open("log.txt", "w"):
            pass

    def write_to_log_file(self, message):
        # Write a message to the log file
        with open("log.txt", "a") as file:
            file.write(message + "\n")
