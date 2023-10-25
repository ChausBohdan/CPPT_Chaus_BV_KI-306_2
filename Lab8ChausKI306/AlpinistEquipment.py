import os

class AlpinistEquipment:
    def __init__(self):
        self.quantities = {}
        self.weights = {}
        self.item_names = [None] * 10
        self.item_count = 0

    def resize_item_names_array(self):
        self.item_names.extend([None] * len(self.item_names))

    def add_item(self, item_name, quantity, weight):
        if item_name in self.quantities:
            self.quantities[item_name] += quantity
        else:
            self.quantities[item_name] = quantity

        self.weights[item_name] = weight

        if self.item_count == len(self.item_names):
            self.resize_item_names_array()

        self.write_to_log_file(f"Added {quantity} {item_name}(s) with a total weight of {quantity * weight} kg.")

    def remove_item(self, item_name, quantity):
        current_quantity = self.quantities.get(item_name, 0)
        if current_quantity >= quantity:
            self.quantities[item_name] -= quantity
            self.write_to_log_file(f"Removed {quantity} {item_name}(s).")
        else:
            print(f"Error: Not enough {item_name} in inventory.")

    def get_total_weight(self):
        total_weight = 0
        for item_name in self.quantities:
            total_weight += self.quantities[item_name] * self.weights[item_name]
        return total_weight

    def display_inventory(self):
        print("Inventory:")
        for item_name in self.quantities:
            print(f"Item Name: {item_name}")
            print(f"Quantity: {self.quantities[item_name]}")
            print(f"Weight: {self.weights[item_name]} kg")

    def display_all_inventory_names(self):
        for i in range(self.item_count):
            print(self.item_names[i])

    def get_quantity(self, item_name):
        return self.quantities.get(item_name, 0)

    def update_item(self, item_name, new_quantity, new_weight):
        self.quantities[item_name] = new_quantity
        self.weights[item_name] = new_weight
        self.write_to_log_file(f"Updated {item_name} to {new_quantity} quantity with a weight of {new_weight} kg.")

    def remove_all_items(self):
        self.quantities.clear()
        self.weights.clear()
        self.write_to_log_file("All items removed from inventory.")

    def contains_item(self, item_name):
        return item_name in self.quantities

    def clear_log_file(self):
        with open("log.txt", "w"):
            pass

    def write_to_log_file(self, message):
        log_file_path = "log.txt"
        if not os.path.exists(log_file_path):
            open(log_file_path, 'w').close()
        with open(log_file_path, "a") as file:
            file.write(message + "\n")
