package com.shiyanlou.jicheng;

public class Test {
	/**
	 * 主程序类
	 */
	public static void main(String[] args) {
		Lisi ls = new Lisi();
		ls.name = "李四";
		ls.age = 24;
		ls.gender = '男';
		ls.action();
		ZhangSan zs = new ZhangSan();
		zs.active();  //当子类重写了父类的方法时，程序有优先调用子类的方法
		zs.action();
	}

}
