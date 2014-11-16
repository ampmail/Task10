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
    public void throwsMyIllegalArgument() throws Exception {
        thrown.expect(MyIllegalArgumentException.class);
        thrown.expectMessage("Mismatch format data: null!");
        String income = "-10.0";
        controller.calculateIncome(income);
    }
//    @Test(expected = MyIllegalArgumentException.class)
//    public void calculateIllegalArgumentIncomeCorrectness() {
//        String income = "-10.0";
//        try{
//            controller.calculateIncome(income);
//        } catch (MyIllegalArgumentException, MyArithmeticException e){
//            throw new MyIllegalArgumentException();
//        }
//    }
    @Test
    public void calculateZeroIncomeCorrectness() {
        String income = "0.0";
        try{
            Assert.assertTrue("Controller.calculateIncome(0.0)", controller.calculateIncome(income).contains("0.00"));
        } catch (Exception e){
        }
    }
    @Test
    public void calculateHundredIncomeCorrectness() {
        String income = "100.0";
        try{
            Assert.assertTrue("Controller.calculateIncome(100.0)", controller.calculateIncome(income).contains("101.00"));
        } catch (Exception e){
        }
    }
}