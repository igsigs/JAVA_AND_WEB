package com.shiyanlou.yichang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo1 {

	public static void main(String[] args) {
		System.out.println("������һ������");
		Scanner scan = new Scanner(System.in);
		int result = 0;
		try {
			//return; �������ִ�� finally Ȼ���ڷ�����ִ�� return ��������
			//System.exit(0); ֱ�ӽ������� finally��
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
			//�ͷ���Դ������رմ򿪵��ļ���ɾ��һЩ��ʱ�ļ��ȵ�
			System.out.println("������Ϊ��" + result);	
		}
	}

}
