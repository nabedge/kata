package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;
import kata.ex01.model.VehicleFamily;
import kata.ex01.util.HolidayUtils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DiscountHoliday extends AbstractDiscount {

    public DiscountHoliday(HighwayDrive drive) {
        super(drive);
    }

    @Override
    public long calc() {

        /*
        普通車、軽自動車等(二輪車)限定
        土曜・日曜・祝日
        地方部
        30%割引
        */
        if (this.drive.getVehicleFamily() == VehicleFamily.OTHER) {
            return 0;
        }

        if (isWeekDays(this.drive.getEnteredAt()) && isWeekDays(this.drive.getExitedAt())){
            return 0;
        }

        if (this.drive.getRouteType() != RouteType.RURAL) {
            return 0;
        }

        return 30;
    }

}
