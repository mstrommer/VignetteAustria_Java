package oop.polymorph;

import java.util.Calendar;
import java.util.Date;

/**
 * The AnnualVignette class represents an annual vignette, extending
 * VignetteBase and implementing ICanChangePlate.
 * It provides functionality specific to annual vignettes.
 */
public class AnnualVignette extends VignetteBase implements ICanChangePlate {

    /**
     * Constructs an AnnualVignette object with the specified start date, vehicle
     * type, and license plate number.
     * 
     * @param startDate The start date of the annual vignette.
     * @param kfzType   The type of the vehicle.
     * @param plate     The license plate number associated with the annual
     *                  vignette.
     */
    public AnnualVignette(Date startDate, String kfzType, String plate) {
         
    }

    /**
     * Calculates and returns the date until which the annual vignette remains
     * valid.
     * The valid until date is set to one year from the start date, with the end
     * time set to 23:59:59.
     * 
     * @return The date until which the annual vignette remains valid.
     */
    @Override
    public Date validUntil() {
         
    }

    /**
     * Checks whether the annual vignette is currently valid.
     * The annual vignette is considered valid if it is not expired and the start
     * date is before the current date.
     * 
     * @return true if the annual vignette is currently valid, false otherwise.
     */
    @Override
    public boolean isValid() {
         
    }

    /**
     * Changes the license plate number associated with the annual vignette.
     * 
     * @param newPlate The new license plate number to set.
     * @return true if the license plate number was successfully changed, false
     *         otherwise.
     */
    @Override
    public boolean changePlate(String newPlate) {
         
    }
}
