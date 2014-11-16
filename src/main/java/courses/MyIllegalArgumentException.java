package courses;

public class MyIllegalArgumentException extends Exception{
    MyIllegalArgumentException(){
        System.out.println("Something going wrong");
    }
    MyIllegalArgumentException(String msg){
        System.out.println("Mismatch format data: " + msg);
    }
}
