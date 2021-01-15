package Lesson5;

import java.util.Arrays;

public class Main {

    public static final int SIZE = 10000000;
    public static final int HALF = SIZE / 2;


    public static void main(String[] args) {
        calculateArray();
        calculateArrayWithThreads();
    }

    private static void calculateArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
        System.out.print("Время выполнения первого метода: ");
        System.out.println(System.currentTimeMillis() - a);

    }

    private static void calculateArrayWithThreads() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();

        //разделяем массивы на два
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        //Создаем два потока
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + HALF) / 5.0) * Math.cos(0.2f + (i + HALF) / 5.0) * Math.cos(0.4f + (i + HALF) / 2.0));
            }
        });
        thread1.start();
        thread2.start();

        //Дожидаемся исполнения потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Копируем данные из половинных массивов в первоначальный
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.print("Время выполнения второго метода: ");
        System.out.println(System.currentTimeMillis() - a);

    }
}
