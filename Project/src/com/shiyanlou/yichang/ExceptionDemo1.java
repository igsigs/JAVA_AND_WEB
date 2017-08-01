package com.shiyanlou.yichang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		System.out.println("请输入一个数字");
		Scanner scan = new Scanner(System.in);
		int result = 0;
		try {
			int number = scan.nextInt();
			result = 10 / number;
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("输出结果为：" + result);
	}

}
