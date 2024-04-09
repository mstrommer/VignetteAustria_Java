package oop.polymorph;

import java.util.Date;

public class SingleDayVignette extends VignetteBase {
    public SingleDayVignette(Date startDateToday, String kfzType) {
        super(startDateToday,kfzType);
    }

    @Override
    public Date validUntil() {
        return getEndOfDay(this.startDate);
    }

    @Override
    public boolean isValid() {
        return !isExpired() && (new Date()).compareTo(this.startDate) > 0;
    }

}
