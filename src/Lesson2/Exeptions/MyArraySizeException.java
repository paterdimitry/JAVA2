package Lesson2.Exeptions;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
       super();
    }


    public void printmsg() {
        System.err.println("Недопустимая длина массива");
    }
}
