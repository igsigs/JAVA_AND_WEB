package com.shiyanlou.Static_Demo;

/**
 * ����һ������ A
 */
public class A {
	static { // �ڸ����ﴴ��һ����̬�Ĵ����
		System.out.println("���Ǹ��ྲ̬�����");
	}
	
	{   //�ڸ��ഴ��һ���Ǿ�̬�Ĵ����
		System.out.println("���Ǹ���Ǿ�̬�����");
	}
	 
	public A(){   //�ڸ��ഴ��һ�����췽��
		System.out.println("���Ǹ���Ĺ��췽��");
	}
}
