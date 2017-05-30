package com.shiyanlou.duotai;

public class Test {
	/**
	 * 主程序类
	 */
	public static void main(String[] args) {
		Animal a = new Animal(); // 父类的引用指向本类的对象
		Animal d = new Dog(); // 父类的引用指向子类的对象
		Animal c = new Cat();  // 父类的引用指向子类的对象
		a.eat(); // 调用的是本类的方法
		d.eat(); // 调用的是子类重写后的方法（程序会优先调用子类重写过的方法）
		c.eat(); // 调用的是从父类继承过来的方法

		// d.attack(); //父类的引用指向子类的对象，不能调用子类独有的方法。只能调用它跟父类有关联的方法

		Animal obj = new Dog();
		
		if(obj instanceof Dog){
			Dog animal = (Dog) obj;
		}else{
			System.out.println("不可以转换");
		}
	}
}
