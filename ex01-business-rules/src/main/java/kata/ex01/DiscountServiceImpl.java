package kata.ex01;

import kata.ex01.model.HighwayDrive;
import kata.ex01.util.DiscountLocalTimeUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author kawasima
 */
public class DiscountServiceImpl implements DiscountService {
    @Override
    public long calc(HighwayDrive drive) {
        LocalDateTime enteredAt = drive.getEnteredAt();
        LocalDateTime exitedAt = drive.getExitedAt();
        LocalTime enteredTm = enteredAt.toLocalTime();
        LocalTime exitedTm = exitedAt.toLocalTime();

        int countPerMonth = drive.getDriver().getCountPerMonth();

        if (drive.enteredAtHoliday()) {
            if (!drive.exitedAtHoliday()) {
                boolean is六時以降 = DiscountLocalTimeUtils.isAfterOrEqualsToSix(exitedTm);
                if (is六時以降) {
                    return resolveWeekDayDiscount(countPerMonth);
                }
            }
            return 30;
        } else {
            if (drive.isSameDateDrive()) {
                boolean is六時九時 = DiscountLocalTimeUtils.isBeforeOrEqualsToNine(enteredTm) && DiscountLocalTimeUtils.isAfterOrEqualsToSix(exitedTm);
                boolean is十七時二十時 = DiscountLocalTimeUtils.isBeforeOrEqualsToSeventeen(enteredTm) && DiscountLocalTimeUtils.isAfterOrEqualsToTwenty(exitedTm);
                if (is六時九時 || is十七時二十時) {
                    return resolveWeekDayDiscount(countPerMonth);
                }
                return 0;
            } else {
                boolean is十七時前 = DiscountLocalTimeUtils.isBeforeOrEqualsToTwenty(enteredTm);
                boolean is六時以降 = DiscountLocalTimeUtils.isAfterOrEqualsToSix(exitedTm);

                if (drive.exitedAtHoliday()) {
                    if (is十七時前) {
                        return resolveWeekDayDiscount(countPerMonth);
                    } else {
                        return 30;
                    }
                }
                if (is十七時前 || is六時以降) {
                    return resolveWeekDayDiscount(countPerMonth);
                }
                return 0;
            }
        }
        // 深夜割引
    }

    private long resolveWeekDayDiscount(int countPerMonth) {
        if (countPerMonth >= 10) {
            return 50;
        }
        if (countPerMonth >= 5) {
            return 30;
        }
        return 0;
    }
}
