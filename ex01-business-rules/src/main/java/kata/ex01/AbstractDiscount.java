package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.util.HolidayUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public abstract class AbstractDiscount {

    protected HighwayDrive drive;

    abstract long calc();

    public AbstractDiscount(HighwayDrive drive) {
        this.drive = drive;
    }


    protected boolean isHoliday(final LocalDateTime localDateTime) {
        return
                localDateTime.getDayOfWeek() == DayOfWeek.SATURDAY
                        || localDateTime.getDayOfWeek() == DayOfWeek.SUNDAY
                        || HolidayUtils.isHoliday(localDateTime.toLocalDate());
    }

    protected boolean isWeekDays(final LocalDateTime localDateTime) {
        return ! isHoliday(localDateTime);
    }
}
