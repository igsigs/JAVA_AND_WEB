package com.shiyanlou.collection_Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���ڴ��ѧ���� List
 */

// ���Ϻ����<>�����͵���˼�������ǹ涨�˼���Ԫ�ص����͡�

public class ListTest {
	public List<Student> students;

	public ListTest() {
		this.students = new ArrayList<Student>();
	}

	/**
	 * ������ Student �����ѧ��
	 */
	public void Add() {
		// ����һ�� Student �Ķ��󣬲�ͨ�� add() ������ӵ�ѧ������ List ��
		// Student s = new Student("1","��һ");
		students.add(new Student("1", "��һ"));

		// ȥ�� List �е� Student ����
		System.out.println("�����ѧ����" + students.get(0).id + ":" + students.get(0).name);
		// �����������ʽ���
		Student[] student = { new Student("2", "����"), new Student("3", "����") };
		// Arrays����������������飨����������������ĸ��ַ���������asList() ������������һ����ָ������֧�ֵĹ̶���С���б�
		students.addAll(Arrays.asList(student));
		System.out.println("�����ѧ����" + students.get(1).id + ":" + students.get(1).name);
		System.out.println("�����ѧ����" + students.get(2).id + ":" + students.get(2).name);
	}

	// ȡ�� List Ԫ�صķ���
	public void testGet() {
		int size = students.size();
		for (int i = 0; i < size; i++) {
			System.out.println("ѧ����" + students.get(i).id + ":" + students.get(i).name);
		}
	}

	// ɾ�� List �е�Ԫ��
	public void Remove() {
		System.out.println("����ѧ����" + students.get(1).id + ":" + students.get(1).name + ",�Ҽ�����ɾ��");
		students.remove(1);
		System.out.println("�ɹ�ɾ��ѧ��");
	}

}
