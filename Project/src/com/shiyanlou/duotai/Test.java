package com.shiyanlou.duotai;
/**
 * 多态的作用：多态消除了类型之间的耦合关系。
 *         多态的存在提高了程序的扩展性和后期的可维护性
 *         多态通过分离做什么和怎么做，从另一个角度将接口和实现进行分离
 *         
 * 多态存在的三个必要条件：需要存在继承和实现关系
 *                 同样的方法调用而执行不同的操作，运行不同的代码（重写操作
 *                 在运行时父类或接口的引用变量可以引用其子类的对象
 *                 
 * 多态性是指同一操作，作用于某一类对象，可以有不同的解释，产生不同的执行结果。
 * 
 *
 */
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

		Animal obj = new Dog();  //向上类型转换
//		Dog obj2 = new Animal(); //子类的引用不能指向父类的对象，否则会报错。
		if(obj instanceof Dog){  //instanceof 类型安全转换关键字
			Dog animal = (Dog) obj;
			System.out.println("转换成功");
		}else{
			System.out.println("不可以转换");
		}
		
		Cat obj3 = new Cat();
		if(){
			
		}else{
			
		}
	}
}
