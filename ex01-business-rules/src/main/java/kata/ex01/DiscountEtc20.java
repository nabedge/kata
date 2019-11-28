package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.model.RouteType;

public class DiscountEtc20 extends AbstractDiscount {

    public DiscountEtc20(HighwayDrive drive) {
        super(drive);
    }

    @Override
    long calc() {

        if (this.drive.getRouteType() != RouteType.KENOH) {
            return 0;
        }

        return 20;
    }
}
