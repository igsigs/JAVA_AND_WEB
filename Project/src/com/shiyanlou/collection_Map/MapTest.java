package com.shiyanlou.collection_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {
	// 用来承装课程类型对象
	Map<String, Course> courses;

	// 在构造器中初始化 courses 属性

	public MapTest() {
		this.courses = new HashMap<String, Course>();
	}

	/**
	 * 添加：输入课程 ID，判断是否被占用 若未被占用，输入课程名称，创建新课程对象 并且添加到 courses 中
	 */
	public void put() {
		Scanner console = new Scanner(System.in);

		while (true) {
			System.out.println("输入exit结束查询");
			System.out.println("请输入要查询的 id");
			String id = console.next();
			String E = "exit";
			if(id.equals(E)){
				break;
			}
			Course c2 =  courses.get(id);
			// 对 id 进行判断，如不存在就创建新的课程 并存入 courses 属性
			if (c2 == null) {
				System.out.println("该 id 所对应的课程不存在，请添加新的课程名称：");
				String name = console.next();
				Course c = new Course(id, name); // 创建新的课程对象
				// 通过调用 courses 中的 put 方法，添加 ID --- 课程映射
				courses.put(id, c);
				System.out.println("成功添加课程：" + courses.get(id).name);
			} else {
				System.out.println("该课程 id 已经被占用");
				continue;
			}
		}
	}
	
	/**
     * 删除 Map 中的映射
     * @param args
     */
	public void remove(){
		//获取从键盘输入的，待删除的  id 字符串
		Scanner s = new Scanner(System.in);
		
		while(true){
			System.out.println("输入exit结束删除");
			System.out.println("请输入要删除的课程 id");
			String id = s.next();
			String E = "exit";
			if(id.equals(E)){
				break;
			}
			//从 Course 中查找对应的  id
			Course course = courses.get(id);
			if(course == null){
				System.out.println("该课程不存在");
			}else{
				courses.remove(id);
				System.out.println("该课程"+"("+course.name+")"+"已经删除（所对应的 ID 号是"+course.id+")");
			}
		}
		
	}
	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.put();
		mt.remove();
	}
}
