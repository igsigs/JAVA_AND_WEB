package com.shiyanlou.Abstract;

public class Test {
	public static void main(String[] args) {
		Animal obj = new Dog();
		obj.eat();
		obj.run(); // 如果子类重写了抽象类中的方法，程序会优先调用重写后的方法，如没有重写程序调用的还是父类的方法。
	}
}
