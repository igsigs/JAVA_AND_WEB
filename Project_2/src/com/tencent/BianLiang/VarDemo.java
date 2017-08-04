package com.tencent.BianLiang;

public class VarDemo {
    public static void main(String[] args) {
	   //先声明后赋值
	    int number;
	    number = 1;
	    System.out.println(number);
	    
	  //j声明的同时进行初始化
	    int data1 = 10;
	    System.out.println(data1);
	    
	    //方法中所声明的变量必须初始化才能用,否侧会报错
//	    int data2;
//	    System.out.println(data2);
	    
	    //同时声明多个变量
	    int data3,data4,data5=100;
//	    System.out.println(data3);
//	    System.out.println(data4);
	    
	    
    }
}
