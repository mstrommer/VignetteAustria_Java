package oop.polymorph;

import java.util.Calendar;
import java.util.Date;

public class VignetteDateCalculationHelper {
    static Date getLastJanuaryOfNextYear() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, new Date().getYear() + 1 + 1900);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date endOfDayJanuaryNextYear = cal.getTime();
        return endOfDayJanuaryNextYear;
    }

    public static Date oneMinuteAgo() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, -1);
        Date startDate = cal.getTime();
        return startDate;
    }

    public static Date getEndOfDayAfterMonthsFromNow(int months) {
        return getEndOfDayAfterMonthsFrom(new Date(), months);
    }

    public static Date getEndOfDayAfterMonthsFrom(Date from, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(from);
        cal.add(Calendar.MONTH, months);
        cal.set(Calendar.HOUR, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        Date endOfThirtyDaysInTheFuture = cal.getTime();
        return endOfThirtyDaysInTheFuture;
    }

    public static Date getDateBeforeDays(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -days);
        Date startDate =  cal.getTime();
        return startDate;
    }

    public static Date getEndOfDaysAfterDaysFrom(Date startDate, int days) {
        Date endOfDayInTenDays = (Date)startDate.clone();
        endOfDayInTenDays.setHours(23);
        endOfDayInTenDays.setMinutes(59);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date day) {
        Date endOfDay = (Date)day.clone();
        endOfDay.setHours(23);
        endOfDay.setMinutes(59);
        return endOfDay;
    }
}
