package com.shiyanlou.jicheng;

public class Test {
	/**
	 * ��������
	 */
	public static void main(String[] args) {
		Lisi ls = new Lisi();
		ls.name = "����";
		ls.age = 24;
//		ls.gender = '��';
		ls.action();
		ZhangSan zs = new ZhangSan();
		zs.active();  //��������д�˸���ķ���ʱ�����������ȵ�������ķ���
		zs.action();
	}

}
