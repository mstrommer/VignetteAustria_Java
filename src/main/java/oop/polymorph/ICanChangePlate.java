package oop.polymorph;

/**
 * The ICanChangePlate interface defines a contract for objects that can change
 * their plate number.
 */
public interface ICanChangePlate {
    /**
     * Changes the plate number of the object to the new plate number provided.
     * 
     * @param newPlate The new plate number to set.
     * @return true if the plate number was successfully changed, false otherwise.
     */
    boolean changePlate(String newPlate);
}
