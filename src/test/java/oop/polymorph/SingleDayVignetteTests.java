package oop.polymorph;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SingleDayVignetteTests {

    @Test
    public void validUntil_createdForToday_returnsToday() {
        Date startDate = VignetteDateCalculationHelper.oneMinuteAgo();
        Date endOfDay = VignetteDateCalculationHelper.getEndOfDay(startDate);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new SingleDayVignette(
                startDate,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();

        assertThat(validUntil).isEqualToIgnoringHours(endOfDay);
    }

    @Test
    public void isExpiredIsValid_startDayIsAlreadyPassed_returnsExpiredAndNotValid() {
        Date expiredStartDay = new Date(2023 - 1900, 3, 2);
        Date endOfStartDay = VignetteDateCalculationHelper.getEndOfDay(expiredStartDay);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new SingleDayVignette(
                expiredStartDay,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isExpired = instanceUnderTest.isExpired();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfStartDay);
        assertThat(isExpired).isTrue();
        assertThat(isValid).isFalse();
    }

    @Test
    public void isExpiredIsValid_startDayIsInFuture_returnsNotExpiredAndNotValid() {
        Date startDateInFuture = new Date(2025 - 1900, 3, 2);
        Date endOfStartDay = VignetteDateCalculationHelper.getEndOfDay(startDateInFuture);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new SingleDayVignette(
                startDateInFuture,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isExpired = instanceUnderTest.isExpired();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfStartDay);
        assertThat(isExpired).isFalse();
        assertThat(isValid).isFalse();
    }

    @Test
    public void isExpiredIsValid_startDayIsToday_returnsNotExpiredAndValid() {
        Date startDateToday = VignetteDateCalculationHelper.oneMinuteAgo();
        Date endOfStartDay = VignetteDateCalculationHelper.getEndOfDay(startDateToday);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new SingleDayVignette(
                startDateToday,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isExpired = instanceUnderTest.isExpired();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfStartDay);
        assertThat(isExpired).isFalse();
        assertThat(isValid).isTrue();
    }

    @Test
    public void display_emitsProperStringRepresentation() {
        Date startDateToday = new Date();
        String kfzType = "A";
        VignetteBase instanceUnderTest = new SingleDayVignette(
                startDateToday,
                kfzType
        );

        String representation = instanceUnderTest.display();

        assertThat(representation).contains(String.format("KFZ Type %s", kfzType)).
                contains(String.format("Valid from %s until %s", startDateToday, instanceUnderTest.validUntil()));

    }

}
