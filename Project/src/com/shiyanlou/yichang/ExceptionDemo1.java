package com.shiyanlou.yichang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		System.out.println("请输入一个数字");
		Scanner scan = new Scanner(System.in);
		int result = 0;
		try {
			//return; 程序会先执行 finally 然后在返回来执行 return 跳出方法
			//System.exit(0); 直接结束包括 finally块
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
		}finally{
			//释放资源，比如关闭打开的文件，删除一些临时文件等等
			System.out.println("输出结果为：" + result);	
		}
	}

}
