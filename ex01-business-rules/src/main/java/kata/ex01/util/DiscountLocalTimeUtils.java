package kata.ex01.util;

import java.time.LocalTime;

/**
 * created 2019-09-25
 *
 * @author tomohiro.sano
 */
public class DiscountLocalTimeUtils {

    private static final LocalTime SIX_O_CLOCK = LocalTime.of(6, 0);
    private static final LocalTime NINE_O_CLOCK = LocalTime.of(9, 0);
    private static final LocalTime SEVENTEEN_O_CLOCK = LocalTime.of(17, 0);
    private static final LocalTime TWENTY_O_CLOCK = LocalTime.of(20, 0);

    public static boolean isBeforeOrEqualsToSix(LocalTime a) {
        return isBeforeOrEqualsTo(a, SIX_O_CLOCK);
    }

    public static boolean isBeforeOrEqualsToNine(LocalTime a) {
        return isBeforeOrEqualsTo(a, NINE_O_CLOCK);
    }

    public static boolean isBeforeOrEqualsToSeventeen(LocalTime a) {
        return isBeforeOrEqualsTo(a, SEVENTEEN_O_CLOCK);
    }

    public static boolean isBeforeOrEqualsToTwenty(LocalTime a) {
        return isBeforeOrEqualsTo(a, TWENTY_O_CLOCK);
    }

    public static boolean isAfterOrEqualsToSix(LocalTime a) {
        return isAfterOrEqualsTo(a, SIX_O_CLOCK);
    }

    public static boolean isAfterOrEqualsToNine(LocalTime a) {
        return isAfterOrEqualsTo(a, NINE_O_CLOCK);
    }

    public static boolean isAfterOrEqualsToSeventeen(LocalTime a) {
        return isAfterOrEqualsTo(a, SEVENTEEN_O_CLOCK);
    }

    public static boolean isAfterOrEqualsToTwenty(LocalTime a) {
        return isAfterOrEqualsTo(a, TWENTY_O_CLOCK);
    }

    public static boolean isBeforeOrEqualsTo(LocalTime a, LocalTime b) {
        return a.isBefore(b) || a.equals(b);
    }

    public static boolean isAfterOrEqualsTo(LocalTime a, LocalTime b) {
        return a.isAfter(b) || a.equals(b);
    }
}
