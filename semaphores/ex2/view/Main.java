package view;

import java.util.concurrent.Semaphore;
import controller.FoodControll;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 5; i++) {
            Thread t = new FoodControll(i, semaphore);
            t.start();
        }
    }
}