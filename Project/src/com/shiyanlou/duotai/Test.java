package com.shiyanlou.duotai;

public class Test {
	/**
	 * ��������
	 */
	public static void main(String[] args) {
		Animal a = new Animal(); // ���������ָ����Ķ���
		Animal d = new Dog(); // ���������ָ������Ķ���
		Animal c = new Cat();  // ���������ָ������Ķ���
		a.eat(); // ���õ��Ǳ���ķ���
		d.eat(); // ���õ���������д��ķ�������������ȵ���������д���ķ�����
		c.eat(); // ���õ��ǴӸ���̳й����ķ���

		// d.attack(); //���������ָ������Ķ��󣬲��ܵ���������еķ�����ֻ�ܵ������������й����ķ���

		Animal obj = new Dog();
		
		if(obj instanceof Dog){
			Dog animal = (Dog) obj;
		}else{
			System.out.println("������ת��");
		}
	}
}
