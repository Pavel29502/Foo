package com.example.Foo;
import java.util.concurrent.CountDownLatch;

public class Foo {

    CountDownLatch first = new CountDownLatch(1);
    CountDownLatch second = new CountDownLatch(1);

    public void first(Runnable r) {
        r.run();
        first.countDown();
        System.out.println("first");
    }

    public void second(Runnable r) {
        r.run();
        second.countDown();
        System.out.println("second");
    }

    public void third(Runnable r) {
        System.out.println("third");
    }
}
