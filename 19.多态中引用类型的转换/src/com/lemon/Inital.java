package com.lemon;



/**
 *   ��������ת��
 *   
 *   1. ��������ת������ʽ/�Զ�����ת��������С���͵�������ת���������ڷ���
 *   2. ��������ת��(ǿ������ת��)���Ǵ����͵�С���ͣ����ڷ���
 *      ��ι�ܷ��գ�
 *      ʹ��instanceof���������������ö�������ͣ���������ת���İ�ȫ������
 *   
 * */


public class Inital {

	public static void main(String[] args) {
	
     //�����������
	Dog dog = new Dog();
	
	// ��������ת��(�����Զ�����),�����ڷ���
	Animal animal = dog;
	
	
	// ��������ת��(����һ������) ���ǿ���ǿ��ת��
	if(animal instanceof Dog){
		
		Dog  dog2 = (Dog)animal; 
		
		System.out.println("ת�����ͳɹ�");
		
	}else{
		
		System.out.println("��������ת��ʧ��"+animal.getClass());
	}

	
	//������ʾ  animalָ��Dog���Ͷ���û�а취ת����Cat���󣬱༭�׶β��ᱨ���������лᱨ��
	//Cat cat = (Cat)animal;// 1.����ʱ ��Cat����  2. ����Dog����  ���Ͳ�ƥ�䡣ֱ�ӱ���

	
	//��ܷ��� (instanceof�����)
	if(animal instanceof Cat){
	
		Cat cat  = (Cat)animal;
		System.out.println("ת�����ͳɹ�");
		
	}else{
		
		System.out.println("ת������ʧ��"+animal.getClass());
	
	}

	}

}
