package courses;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ControllerTest {

    public static Controller controller;

    @BeforeClass
    public static void init() {
        controller = new Controller();
    }

    @Rule
    public ExpectedException thrown= ExpectedException.none();
    @Test
    public void throwsMyIllegalArgumentCheck () throws Exception {
        thrown.expect(MyIllegalArgumentException.class);
        String incomingData = "1qsc23.e2";
        controller.checkIncomingData(incomingData);
    }
    @Test
    public void throwsMyIllegalArgument() throws Exception {
        thrown.expect(MyIllegalArgumentException.class);
//        thrown.expectMessage("Mismatch format data: null!");
        String income = "asdf";
        controller.calculateIncome(income);
    }
    @Test
    public void throwsMyArithmeticExceptionOverLimit() throws Exception {
        thrown.expect(MyArithmeticException.class);
        String income = "656000000.01";
        controller.calculateIncome(income);
    }
    @Test
    public void calculateZeroIncomeCorrectness() {
        String income = "0.0";
        try{
            Assert.assertEquals("Controller.calculateIncome(0.0)", controller.calculateIncome(income), new String("0.00"));
        } catch (Exception e){
        }
    }
    @Test
    public void calculateHundredIncomeCorrectness() {
        String income = "100.0";
        try{
            Assert.assertEquals("Controller.calculateIncome(100.0)", controller.calculateIncome(income), new String("101.00"));
        } catch (Exception e){
        }
    }
    @Test
    public void calculateThousandIncomeCorrectness() {
        String income = "1000.0";
        try{
            Assert.assertTrue("Controller.calculateIncome(1000.0)", controller.calculateIncome(income).contains("1015.00"));
        } catch (Exception e){
        }
    }
    @Test
    public void calculateTenThousandsIncomeCorrectness() {
        String income = "10000.0";
        try{
            Assert.assertTrue("Controller.calculateIncome(10000.0)", controller.calculateIncome(income).contains("10250.00"));
        } catch (Exception e){
        }
    }
    @Test
    public void calculateHundredThousandsIncomeCorrectness() {
        String income = "100000.0";
        try{
            Assert.assertTrue("Controller.calculateIncome(100000.0)", controller.calculateIncome(income).contains("105000.00"));
        } catch (Exception e){
        }
    }


}