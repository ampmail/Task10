package courses;

public class Constants {

    public static final String INCOMING_DATA_PATTERN_STRING = "[0-9]{0,10}[.]{0,1}[0-9]{0,2}";

    public static final int DIGITS_AFTER_POINT = 2;

    public enum RatioRangeDependence {
        FIRST_RANGE (0L, 1000L, 1.0),
        SECOND_RANGE(1000L,  10000L, 1.5),
        THIRD_RANGE (10000L, 100000L, 2.5),
        FOURTH_RANGE(100000L, 656000000L, 5.0); //Biggest Lottery Win

        Long LowBorder;
        Long HiBorder;
        Double Profit;

        RatioRangeDependence(Long LowBorder, Long HiBorder, Double Profit) {
            this.LowBorder = LowBorder;
            this.HiBorder = HiBorder;
            this.Profit = Profit;
        }
        Double getProfit() {
            return Profit;
        }
    }
}
