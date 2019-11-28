package kata.ex01;

import kata.ex01.model.Driver;
import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DiscountMorningAndNight extends AbstractDiscount{

    public DiscountMorningAndNight(HighwayDrive drive) {
        super(drive);
    }

    @Override
    public long calc() {

        /*
        地方部　
        平日「朝:6時〜9時」、「夕:17時〜20時」
        当月の利用回数が5回〜9回 30%割引、10回以上 50%割引
        */
        if (this.drive.getRouteType() != RouteType.RURAL) {
            return 0;
        }

        // 入った時間
        boolean matchEnteredAt = isWeekDays(this.drive.getEnteredAt()) && matchHours(this.drive.getEnteredAt());

        // 出た時間
        boolean matchExitedAt = isWeekDays(this.drive.getExitedAt()) && matchHours(this.drive.getExitedAt());

        if (! matchEnteredAt && ! matchExitedAt) {
            return 0;
        }

        Driver driver = this.drive.getDriver();
        if (driver.getCountPerMonth() < 5) {
            return 0;
        } else if (driver.getCountPerMonth() < 10) {
            return 30;
        } else {
            return 50;
        }
    }

    private boolean matchHours(LocalDateTime localDateTime) {
        LocalTime localTime = localDateTime.toLocalTime();

        if (localTime.isAfter(LocalTime.of(6,0))
                && localTime.isBefore(LocalTime.of(9,0)))
        {
            return true;
        }

        if (localTime.isAfter(LocalTime.of(17,0))
                && localTime.isBefore(LocalTime.of(20,0)))
        {
            return true;
        }

        return false;
    }

}
