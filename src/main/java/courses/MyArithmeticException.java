package courses;

public class MyArithmeticException extends Exception{
    MyArithmeticException(){
        System.out.println("Something going wrong");
    }
    MyArithmeticException(String msg){
        System.out.println("Mismatch data range: " + msg);
    }
}
