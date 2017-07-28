package com.shiyanlou.duotai;

/**
 * 狗类继承了动物类（即：继承是实现多态的基础）
 */
public class Dog extends Animal {
	@Override
	public void eat() { // 子类重写了从父类继承过来的方法
		System.out.println("狗具有吃骨头的能力");
	}

	public void attack() { // attack 是子类独有的方法，不是从父类继承过来的
		System.out.println("狗具有攻击的能力");
	}
}
