package com.shiyanlou.Abstract;

public class Dog extends Animal {
	// 如果子类没有实现从抽象类继承过来的方法，子类就会报错。
	public void eat() {
		System.out.println("小狗吃具有吃骨头的能力");
	}

	//子类独有的方法
	public void run() {
		System.out.println("小狗具有跑的能力");
	}
}
