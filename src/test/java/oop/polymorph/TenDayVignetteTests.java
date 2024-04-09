package oop.polymorph;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TenDayVignetteTests {

    @Test
    public void validUntil_createdForToday_returnsTenDaysAfterTodayAndIsValidTrue() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, -1);
        Date startDate = cal.getTime();
        Date endOfTenDaysInTheFuture = VignetteDateCalculationHelper.getEndOfDaysAfterDaysFrom(startDate, 10);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new TenDayVignette(
                startDate,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfTenDaysInTheFuture);
        assertThat(isValid).isTrue();
    }

    @Test
    public void validUntil_createdTwelveDaysAgo_returnsTenDaysPlusStartDateAndIsValidFalse() {
        Date startDate = VignetteDateCalculationHelper.getDateBeforeDays(12);
        Date endOfTenDaysInTheFuture = VignetteDateCalculationHelper.getEndOfDaysAfterDaysFrom(startDate, 10);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new TenDayVignette(
                startDate,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfTenDaysInTheFuture);
        assertThat(isValid).isFalse();
    }

    @Test
    public void validUntil_createdFiveDaysAgo_returnsTenDaysPlusStartDateAndIsValidTrue() {
        Date startDate = VignetteDateCalculationHelper.getDateBeforeDays(5);
        Date endOfTenDaysInTheFuture = VignetteDateCalculationHelper.getEndOfDaysAfterDaysFrom(startDate, 10);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new TenDayVignette(
                startDate,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfTenDaysInTheFuture);
        assertThat(isValid).isTrue();
    }

}
