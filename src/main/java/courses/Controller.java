package courses;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {

    public static String calculateIncome(String checkedInputData) throws MyArithmeticException, MyIllegalArgumentException {
        BigDecimal result;
        BigDecimal inputAmount, profit = null;
        try {
            inputAmount = new BigDecimal(checkedInputData);
            Constants.RatioRangeDependence lastRange = null;
            for (Constants.RatioRangeDependence Range : Constants.RatioRangeDependence.values()) {
                lastRange = Range;
                if (inputAmount.compareTo(new BigDecimal(Range.LowBorder)) == 0 ||
                        (inputAmount.compareTo(new BigDecimal(Range.LowBorder)) == 1 &&
                                inputAmount.compareTo(new BigDecimal(Range.HiBorder)) == -1)  ) {
                    profit = new BigDecimal(Range.getProfit());
                    break;
                }
            }
            if(inputAmount.compareTo(new BigDecimal(lastRange.HiBorder)) == 0){
                profit = new BigDecimal(lastRange.getProfit());
            }
            if(inputAmount.compareTo(new BigDecimal(lastRange.HiBorder)) == 1){
                throw new MyArithmeticException(inputAmount + " greater than the maximum limit");
            }
            if (profit == null) {
                throw new MyIllegalArgumentException("null!");
            } else {
                result = inputAmount.multiply(profit);
                result = result.divide( new BigDecimal(100));
                result = inputAmount.add(result).setScale(Constants.DIGITS_AFTER_POINT, RoundingMode.DOWN);
            }
        } catch (NumberFormatException e) {
            throw new MyIllegalArgumentException();
        }
        return result.toString();
    }

    public static void checkIncomingData(String incomingData) throws MyIllegalArgumentException {

        if (incomingData != null && incomingData.length() > 0) {
            String pattern = Constants.INCOMING_DATA_PATTERN_STRING;
            Pattern pat = Pattern.compile(pattern);
            Matcher mat = pat.matcher(incomingData);
            if (!mat.matches()) {
                throw new MyIllegalArgumentException(incomingData);
            }
            return;
        }
        throw new MyIllegalArgumentException("incoming data was not defined or invalid");
    }
}
