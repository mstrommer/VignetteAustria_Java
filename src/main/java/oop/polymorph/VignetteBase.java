package oop.polymorph;

import java.util.Calendar;
import java.util.Date;

/**
 * The VignetteBase class serves as a base class for vignettes.
 * It provides common functionality and properties for all types of vignettes.
 */
public abstract class VignetteBase {

    /**
     * The start date of the vignette.
     */
    protected final Date startDate;

    /**
     * The type of the vehicle for which the vignette is issued.
     */
    protected final String kfzType;

    /**
     * The license plate number associated with the vignette.
     */
    protected String plate;

    /**
     * Gets the license plate number associated with the vignette.
     * 
     * @return The license plate number associated with the vignette.
     */
    public String getPlate() {
           return this.plate;
    }


    /**
     * Constructs a VignetteBase object with the specified start date and vehicle
     * type.
     * 
     * @param startDate The start date of the vignette.
     * @param kfzType   The type of the vehicle.
     */
    public VignetteBase(Date startDate, String kfzType) {
           this.startDate = startDate;
           this.kfzType = kfzType;
    }

    /**
     * Constructs a VignetteBase object with the specified start date, vehicle type,
     * and license plate number.
     * 
     * @param startDate The start date of the vignette.
     * @param kfzType   The type of the vehicle .
     * @param plate     The license plate number associated with the vignette.
     */
    public VignetteBase(Date startDate, String kfzType, String plate) {
        this(startDate, kfzType);
        this.plate = plate;
    }

    /**
     * Calculates and returns the date until which the vignette remains valid.
     * 
     * @return The date until which the vignette remains valid.
     */
    public abstract Date validUntil();

    public boolean isExpired() {
           return (new Date()).compareTo(validUntil()) > 0;
    }

    /**
     * Checks whether the vignette is expired.
     * 
     * @return true if the vignette is expired, false otherwise.
     */
    public abstract boolean isValid();

    /**
     * Generates and returns a string representation of the vignette.
     * 
     * @return A string representation of the vignette.
     */
    public String display() {
        return "KFZ Type " + this.kfzType + " ." +
                "Valid from " + this.startDate + " until " +
                this.validUntil();
    }

    /**
     * Calculates and returns the end of the day for the given date.
     * 
     * @param day The date for which to calculate the end of the day.
     * @return The end of the day for the given date.
     */
    protected Date getEndOfDay(Date day) {
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }

}
