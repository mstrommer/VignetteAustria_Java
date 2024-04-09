package oop.polymorph;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AnnualVignetteTests {

    @Test
    public void validUntil_createdForToday_returnsEndOfJanuaryTheNextYear() {
        Date startDate = VignetteDateCalculationHelper.oneMinuteAgo();
        Date endOfDayJanuaryNextYear = VignetteDateCalculationHelper.getLastJanuaryOfNextYear();
        String kfzType = "A";
        VignetteBase instanceUnderTest = new AnnualVignette(
                startDate,
                kfzType,
                "NK-123-TP");

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfDayJanuaryNextYear);
        assertThat(isValid).isTrue();
    }


    @Test
    public void validUntil_created2YearsAgo_returnsEndOfJanuaryOneYearAgoAndIsValidFalse() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -2);
        Date startedTwoYearsAgo = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date expectedValidUntil = cal.getTime();
        String kfzType = "A";
        VignetteBase instanceUnderTest = new AnnualVignette(
                startedTwoYearsAgo,
                kfzType,
                "NK-123-TP");

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(expectedValidUntil);
        assertThat(isValid).isFalse();
    }

    @Test
    public void validUntil_createdSomewhereInTheSameYear_returnsEndOfJanuaryNextYearAndIsValidTrue() {
        int month = VignetteDateCalculationHelper.oneMinuteAgo().getMonth();
        if (month > 0) {
            month--;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, month);
        Date startedSomeWhereEarlierThisYear = cal.getTime();
        cal.add(Calendar.YEAR, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date expectedValidUntil = cal.getTime();
        String kfzType = "A";
        VignetteBase instanceUnderTest = new AnnualVignette(
                startedSomeWhereEarlierThisYear,
                kfzType,
                "NK-123-TP");

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(expectedValidUntil);
        assertThat(isValid).isTrue();
    }

    @Test
    public void changePlate_plateIsUpdated() {
        Date startDate = VignetteDateCalculationHelper.oneMinuteAgo();
        String kfzType = "A";
        String plateAtStartTime = "NK-444-TP";
        AnnualVignette instanceUnderTest = new AnnualVignette(
                startDate,
                kfzType,
                plateAtStartTime
        );
        String newPlate = "NK-333_TP";

        String oldPlate = instanceUnderTest.getPlate();
        boolean succeeded = instanceUnderTest.changePlate(newPlate);

        assertThat(oldPlate).isEqualTo(plateAtStartTime);
        assertThat(instanceUnderTest.getPlate()).isEqualTo(newPlate);
        assertThat(succeeded).isTrue();
    }

}
