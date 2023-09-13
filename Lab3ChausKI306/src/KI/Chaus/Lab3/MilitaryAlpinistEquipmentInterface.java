package KI.Chaus.Lab3;

/**
 * This interface defines methods for military equipment.
 * Implementing classes must provide functionality for performing military actions.
 * 
 * @author Chaus Bohdan
 * @version 1.0
 */
public interface MilitaryAlpinistEquipmentInterface {

	/**
     * Performs a specific military action.
     */
    void performMilitaryAction();

    /**
     * Checks if the equipment is ready for combat.
     * 
     * @return true if the equipment is combat-ready, false otherwise.
     */
    boolean isCombatReady();
}
