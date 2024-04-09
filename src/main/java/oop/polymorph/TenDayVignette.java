package oop.polymorph;

import java.util.Calendar;
import java.util.Date;

public class TenDayVignette extends VignetteBase {
    public TenDayVignette(Date startDate, String kfzType) {
        super(startDate,kfzType);
    }

    @Override
    public Date validUntil() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.startDate);
        c.add(Calendar.DAY_OF_YEAR,10);
        return getEndOfDay(c.getTime());
    }

    @Override
    public boolean isValid() {
        return !isExpired() && (new Date()).compareTo(this.startDate) > 0;
    }
}
