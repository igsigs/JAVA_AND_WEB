package com.shiyanlou.duotai;

/**
 * ����̳��˶����ࣨ�����̳���ʵ�ֶ�̬�Ļ�����
 */
public class Dog extends Animal {
	@Override
	public void eat() { // ������д�˴Ӹ���̳й����ķ���
		System.out.println("�����гԹ�ͷ������");
	}

	public void attack() { // attack ��������еķ��������ǴӸ���̳й�����
		System.out.println("�����й���������");
	}
}
