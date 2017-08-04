package com.tencent.duotai;

/**
 * 创建一个子类 Dog（狗）并继承父类 Animal（动物）
 */
public class Dog extends Animal {
	@Override
	public void eat() { // 子类重写了从父类继承过来的方法
		System.out.println("狗具有吃的能力");
	}

	public void attack() { // attack 是子类独有的方法，不是从父类继承过来的
		System.out.println("狗具有攻击的能力");
	}
}
