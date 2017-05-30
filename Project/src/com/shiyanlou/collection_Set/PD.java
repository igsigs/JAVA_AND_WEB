package com.shiyanlou.collection_Set;

import java.util.HashSet;
import java.util.Set;

import com.shiyanlou.collection_Demo.Student;

/**
 * 项目组类
 * 
 * @author Administrator
 *
 */
public class PD {
	String id;
	String name;
	 //集合后面的<>代表泛型的意思
    //泛型是规定了集合元素的类型
	public Set<Student> students;

	public PD(String id, String name) {
		this.id = id;
		this.name = name;
		this.students = new HashSet<Student>();
	}
}
