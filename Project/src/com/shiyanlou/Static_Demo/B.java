package com.shiyanlou.Static_Demo;
/**
 * ����һ������ B
 */
public class B extends A {
	static { // �ڸ����ﴴ��һ����̬�Ĵ����
		System.out.println("�������ྲ̬�����");
	}
	
	{   //�ڸ��ഴ��һ���Ǿ�̬�Ĵ����
		System.out.println("��������Ǿ�̬�����");
	}
	 
	public B(){   //�ڸ��ഴ��һ�����췽��
		System.out.println("��������Ĺ��췽��");
	}
}
