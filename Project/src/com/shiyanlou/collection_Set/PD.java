package com.shiyanlou.collection_Set;

import java.util.HashSet;
import java.util.Set;

import com.shiyanlou.collection_Demo.Student;

/**
 * ��Ŀ����
 * 
 * @author Administrator
 *
 */
public class PD {
	String id;
	String name;
	 //���Ϻ����<>�����͵���˼
    //�����ǹ涨�˼���Ԫ�ص�����
	public Set<Student> students;

	public PD(String id, String name) {
		this.id = id;
		this.name = name;
		this.students = new HashSet<Student>();
	}
}
