package com.shiyanlou.Static_Demo;
/**
 * 创建一个子类 B
 */
public class B extends A {
	static { // 在父类里创建一个静态的代码块
		System.out.println("我是子类静态代码块");
	}
	
	{   //在父类创建一个非静态的代码块
		System.out.println("我是子类非静态代码块");
	}
	 
	public B(){   //在父类创建一个构造方法
		System.out.println("我是子类的构造方法");
	}
}
