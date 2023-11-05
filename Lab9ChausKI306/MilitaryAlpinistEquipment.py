from AlpinistEquipment import AlpinistEquipment

class MilitaryAlpinistEquipment(AlpinistEquipment):
    def __init__(self):
        # Call the constructor of the parent class AlpinistEquipment
        super().__init__()
        
        # Initialize an additional attribute specific to MilitaryAlpinistEquipment
        self.night_vision_enabled = False

    def enable_night_vision(self):
        # Enable night vision
        self.night_vision_enabled = True

    def disable_night_vision(self):
        # Disable night vision
        self.night_vision_enabled = False

    def is_night_vision_enabled(self):
        # Check if night vision is enabled
        return self.night_vision_enabled

    def perform_military_action(self):
        # Perform a military alpinist action
        print("Performing military alpinist action...")

    def is_combat_ready(self):
        # Check if the equipment is combat ready, based on night vision availability
        return self.is_night_vision_enabled()
