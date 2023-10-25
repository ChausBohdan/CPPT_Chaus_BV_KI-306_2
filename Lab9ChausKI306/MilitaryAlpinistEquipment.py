from AlpinistEquipment import AlpinistEquipment

class MilitaryAlpinistEquipment(AlpinistEquipment):
    def __init__(self):
        super().__init__()
        self.night_vision_enabled = False

    def enable_night_vision(self):
        self.night_vision_enabled = True

    def disable_night_vision(self):
        self.night_vision_enabled = False

    def is_night_vision_enabled(self):
        return self.night_vision_enabled

    def perform_military_action(self):
        print("Performing military alpinist action...")

    def is_combat_ready(self):
        return self.is_night_vision_enabled()
