package courses;

public class Main {

    public static void main(String[] args) {

        String casualAmountOfMoney = "1000.0";
        String result = "There are no profit!";

        try {
            Controller.checkIncomingData(casualAmountOfMoney);
            result = Controller.calculateIncome(casualAmountOfMoney);
        } catch (MyIllegalArgumentException e) {
            System.out.println("Abnormal program stop");
        } catch (MyArithmeticException e) {
            System.out.println("Abnormal program stop");
        } finally {
            System.out.println(result);
        }
    }
}
