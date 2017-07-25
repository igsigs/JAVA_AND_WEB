package com.shiyanlou.duotai;
/**
 * 狗类继承了动物类（即：继承是实现多态的基础）
 */
public class Dog extends Animal {
	@Override
	public void eat(){
		System.out.println("狗具有吃骨头的能力");
	}
	public void attack(){
		System.out.println("狗具有攻击的能力");
	}
}
