package kata.ex01;

import kata.ex01.model.HighwayDrive;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {

    @Override
    public long calc(HighwayDrive drive) {

        // 深夜割引
        long midnightRate = new DiscountMidnight(drive).calc();

        // 休日割引
        long holidayRate = new DiscountHoliday(drive).calc();

        //  平日朝夕割引
        long morningAndNightRate = new DiscountMorningAndNight(drive).calc();

        // etc2.0割引
        long etc20Rate = new DiscountEtc20(drive).calc();

        // 最大値を取る
        return Math.max(
                Math.max(midnightRate, holidayRate),
                Math.max(morningAndNightRate, etc20Rate)
        );
    }
}
