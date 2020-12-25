package Lesson2;

import Lesson2.Exeptions.MyArrayDataException;
import Lesson2.Exeptions.MyArraySizeException;

public class Main {

    static final int SIZE = 4;

    public static void main(String[] args) {

        String[][] arr = createArray();

        try {
            if (arr.length == SIZE) {
                for (int i = 0; i < SIZE; i++)
                    if (arr[i].length != SIZE)
                        throw new MyArraySizeException();
            } else {
                throw new MyArraySizeException();
            }

            System.out.println("Сумма числовых элементов массива: " + parseAndSumArray(arr));
        } catch (MyArraySizeException e) {
            e.printmsg();
        }

    }

    private static String[][] createArray() {
        return new String[][]  {{"1", "1", "a", "1"},
                                {"1", "1", "0", "1"},
                                {"1", "1", "0", "1"},
                                {"1", "1", "0", "f"}};
    }

    private static int parseAndSumArray(String[][] arr) throws MyArraySizeException{
        int sum = 0;
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    MyArrayDataException mye = new MyArrayDataException();
                    mye.printmsg(i, j);
                }
        return sum;
    }
}
