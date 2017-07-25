package com.lemon;



/**
 *   引用类型转换
 *   
 *   1. 向上类型转换（隐式/自动类型转化），是小类型到大类型转换，不存在风险
 *   2. 向下类型转换(强制类型转换)，是大类型到小类型，存在风险
 *      如何规避风险？
 *      使用instanceof运算符，来解决引用对象的类型，避免类型转换的安全性问题
 *   
 * */


public class Inital {

	public static void main(String[] args) {
	
     //创建子类对象
	Dog dog = new Dog();
	
	// 向上类型转换(类型自动提升),不存在风险
	Animal animal = dog;
	
	
	// 向下类型转换(存在一定风险) 我们可以强制转换
	if(animal instanceof Dog){
		
		Dog  dog2 = (Dog)animal; 
		
		System.out.println("转化类型成功");
		
	}else{
		
		System.out.println("向下类型转化失败"+animal.getClass());
	}

	
	//风险演示  animal指向Dog类型对象，没有办法转化成Cat对象，编辑阶段不会报错，但是运行会报错
	//Cat cat = (Cat)animal;// 1.编译时 按Cat类型  2. 运行Dog类型  类型不匹配。直接报错

	
	//规避风险 (instanceof运算符)
	if(animal instanceof Cat){
	
		Cat cat  = (Cat)animal;
		System.out.println("转化类型成功");
		
	}else{
		
		System.out.println("转化类型失败"+animal.getClass());
	
	}

	}

}
