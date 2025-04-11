package com.example.Foo;
import java.util.concurrent.CountDownLatch;

public class Foo {

    CountDownLatch firstCount = new CountDownLatch(1);
    CountDownLatch secondCount = new CountDownLatch(1);

    public void first(Runnable r) {
        r.run();
        firstCount.countDown();
        System.out.println("first");
    }

    public void second(Runnable r) {
        try {
            firstCount.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        r.run();
        secondCount.countDown();
        System.out.println("second");
    }

    public void third(Runnable r) {
        try {
            secondCount.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        r.run();
        firstCount.countDown();
        System.out.println("third");
    }
}
