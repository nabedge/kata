package kata.ex01;

import kata.ex01.model.HighwayDrive;

import java.time.LocalTime;

public class DiscountMidnight extends AbstractDiscount {

    public DiscountMidnight(HighwayDrive drive) {
        super(drive);
    }

    @Override
    public long calc() {
        // すべての車種 毎日0〜４時 30%割引
        if (
                this.drive.getEnteredAt().toLocalTime().isAfter(LocalTime.of(0,0))
                && this.drive.getEnteredAt().toLocalTime().isBefore(LocalTime.of(4,0))
        ){
            return 30;
        }

        return 0;
    }
}
