package com.example.Foo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FooApplication {
	public static void main(String[] args) {

		Foo foo = new Foo();

		Thread A = new Thread(() -> foo.first(() -> {}));
		Thread B = new Thread(() -> foo.second(() -> {}));
		Thread C = new Thread(() -> foo.third(() -> {}));

		C.start();
		B.start();
		A.start();
	}
}
