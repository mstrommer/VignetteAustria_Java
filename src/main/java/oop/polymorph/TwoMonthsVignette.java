package oop.polymorph;

import java.util.Calendar;
import java.util.Date;

public class TwoMonthsVignette extends VignetteBase {
    public TwoMonthsVignette(Date startDate, String kfzType) {
        super(startDate,kfzType);
    }

    @Override
    public Date validUntil() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.startDate);
        c.add(Calendar.MONTH,2);
        return getEndOfDay(c.getTime());
    }

    @Override
    public boolean isValid() {
        return !isExpired() && (new Date()).compareTo(this.startDate) > 0;
    }
}
