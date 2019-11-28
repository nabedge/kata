package kata.ex01;

import kata.ex01.model.HighwayDrive;

import java.util.stream.LongStream;

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
        return LongStream
                .of(
                    midnightRate,
                    holidayRate,
                    morningAndNightRate,
                    etc20Rate
                )
                .max()
                .orElse(0L);
    }
}
