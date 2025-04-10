package com.example.Foo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FooApplication {

	public static void main(String[] args) {
//		SpringApplication.run(FooApplication.class, args);

		Foo foo = new Foo();

		Thread t1 = new Thread(() -> foo.first(() -> {}));
		Thread t2 = new Thread(() -> foo.first(() -> {}));
		Thread t3 = new Thread(() -> foo.first(() -> {}));

		t3.start();
		t2.start();
		t1.start();

	}
}
