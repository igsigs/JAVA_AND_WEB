package com.shiyanlou.collection_Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用于存放学生的 List
 */

// 集合后面的<>代表泛型的意思，泛型是规定了集合元素的类型。

public class ListTest {
	public List<Student> students;

	public ListTest() {
		this.students = new ArrayList<Student>();
	}

	/**
	 * 用于往 Student 中添加学生
	 */
	public void Add() {
		// 创建一个 Student 的对象，并通过 add() 方法添加到学生管理 List 中
		// Student s = new Student("1","王一");
		students.add(new Student("1", "王一"));

		// 去除 List 中的 Student 对象
		System.out.println("添加了学生：" + students.get(0).id + ":" + students.get(0).name);
		// 对象数组的形式添加
		Student[] student = { new Student("2", "王二"), new Student("3", "王三") };
		// Arrays类包含用来操作数组（比如排序和搜索）的各种方法，其中asList() 方法用来返回一个受指定数组支持的固定大小的列表
		students.addAll(Arrays.asList(student));
		System.out.println("添加了学生：" + students.get(1).id + ":" + students.get(1).name);
		System.out.println("添加了学生：" + students.get(2).id + ":" + students.get(2).name);
	}

	// 取得 List 元素的方法
	public void testGet() {
		int size = students.size();
		for (int i = 0; i < size; i++) {
			System.out.println("学生：" + students.get(i).id + ":" + students.get(i).name);
		}
	}

	// 删除 List 中的元素
	public void Remove() {
		System.out.println("我是学生：" + students.get(1).id + ":" + students.get(1).name + ",我即将被删除");
		students.remove(1);
		System.out.println("成功删除学生");
	}

}
