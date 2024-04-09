package oop.polymorph;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class TwoMonthVignetteTests {

    @Test
    public void validUntil_createdForToday_returnsTwoMonthsAfterTodayAndIsValidTrue() {
        Date startDate = VignetteDateCalculationHelper.oneMinuteAgo();
        Date endOfDayInTwoMonths = VignetteDateCalculationHelper.getEndOfDayAfterMonthsFromNow(2);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new TwoMonthsVignette(
                startDate,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(endOfDayInTwoMonths);
        assertThat(isValid).isTrue();
    }

    @Test
    public void validUntil_createdThreeMonthsAgo_returnsTwoMonthsPlusStartDateAndIsValidFalse() {
        Date endOfDayInThreeMonthsAgo = VignetteDateCalculationHelper.getEndOfDayAfterMonthsFromNow(-3);
        Date expectedValidUntil = VignetteDateCalculationHelper.getEndOfDayAfterMonthsFrom(endOfDayInThreeMonthsAgo, 2);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new TwoMonthsVignette(
                endOfDayInThreeMonthsAgo,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(expectedValidUntil);
        assertThat(isValid).isFalse();
    }

    @Test
    public void validUntil_createdOneMonthAgo_returnsTwoMonthsPlusStartDateAndIsValidTrue() {
        Date endOfDayInThreeMonthsAgo = VignetteDateCalculationHelper.getEndOfDayAfterMonthsFromNow(-1);
        Date expectedValidUntil = VignetteDateCalculationHelper.getEndOfDayAfterMonthsFrom(endOfDayInThreeMonthsAgo, 2);
        String kfzType = "A";
        VignetteBase instanceUnderTest = new TwoMonthsVignette(
                endOfDayInThreeMonthsAgo,
                kfzType
        );

        Date validUntil = instanceUnderTest.validUntil();
        boolean isValid = instanceUnderTest.isValid();

        assertThat(validUntil).isEqualToIgnoringHours(expectedValidUntil);
        assertThat(isValid).isTrue();
    }

}
