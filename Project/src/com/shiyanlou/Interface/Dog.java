package com.shiyanlou.Interface;

public class Dog implements Animal {
	
	@Override
	public void eat() {
		System.out.println("狗具有吃骨头的能力");
	}
}
