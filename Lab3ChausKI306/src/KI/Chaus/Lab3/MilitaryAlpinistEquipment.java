package KI.Chaus.Lab3;

/**
 * This class represents military alpinist equipment and extends the AlpinistEquipment class.
 * It provides mechanisms for correct functioning specific to military equipment.
 * It also implements the MilitaryEquipment interface.
 * 
 * @author Chaus Bohdan
 * @version 1.0
 */
public class MilitaryAlpinistEquipment extends AlpinistEquipment implements MilitaryAlpinistEquipmentInterface {

    // Indicates whether night vision mode is enabled.
    private boolean nightVisionEnabled;

    // Constructor initializes nightVisionEnabled to false by default.
    public MilitaryAlpinistEquipment() {
        nightVisionEnabled = false;
    }

    /**
     * Enables night vision mode.
     */
    public void enableNightVision() {
        nightVisionEnabled = true;
    }

    /**
     * Disables night vision mode.
     */
    public void disableNightVision() {
        nightVisionEnabled = false;
    }

    /**
     * Checks if night vision mode is enabled.
     * 
     * @return true if night vision is enabled, false otherwise.
     */
    public boolean isNightVisionEnabled() {
        return nightVisionEnabled;
    }

    /**
     * Overrides the method in the interface.
     * Prints a message indicating a military alpinist action is being performed.
     */
    @Override
    public void performMilitaryAction() {
        System.out.println("Performing military alpinist action...");
    }

    /**
     * Overrides the method in the interface.
     * Indicates if the equipment is combat-ready based on night vision status.
     * 
     * @return true if night vision is enabled, false otherwise.
     */
    @Override
    public boolean isCombatReady() {
        return isNightVisionEnabled();
    }
}
