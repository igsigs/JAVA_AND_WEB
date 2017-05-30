package com.shiyanlou.Interface;

public class Test {

	/**
	 * 主程序
	 */
	public static void main(String[] args) {
		Animal obj = new Dog(); // 接口的引用指向子类的对象
		obj.eat();
		Animal obj2 = new Cat();
		obj2.eat();
		//多态的作用：同一个方法，不同的对象有不同的实现方法。实际上它起到了一个统一规范的作用。

	}

}
