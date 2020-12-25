package Lesson2.Exeptions;

public class MyArrayDataException extends NumberFormatException {

    public MyArrayDataException() {
        super();
    }


    public void printmsg(int i, int j) {
        System.err.printf("Недопустимый формат в элементе arr[%d][%d]%n", i, j);

    }
}
