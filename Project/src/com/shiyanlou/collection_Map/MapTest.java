package com.shiyanlou.collection_Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {
	// ������װ�γ����Ͷ���
	Map<String, Course> courses;

	// �ڹ������г�ʼ�� courses ����

	public MapTest() {
		this.courses = new HashMap<String, Course>();
	}

	/**
	 * ��ӣ�����γ� ID���ж��Ƿ�ռ�� ��δ��ռ�ã�����γ����ƣ������¿γ̶��� ������ӵ� courses ��
	 */
	public void put() {
		Scanner console = new Scanner(System.in);

		while (true) {
			System.out.println("����exit������ѯ");
			System.out.println("������Ҫ��ѯ�� id");
			String id = console.next();
			String E = "exit";
			if(id.equals(E)){
				break;
			}
			Course c2 =  courses.get(id);
			// �� id �����жϣ��粻���ھʹ����µĿγ� ������ courses ����
			if (c2 == null) {
				System.out.println("�� id ����Ӧ�Ŀγ̲����ڣ�������µĿγ����ƣ�");
				String name = console.next();
				Course c = new Course(id, name); // �����µĿγ̶���
				// ͨ������ courses �е� put ��������� ID --- �γ�ӳ��
				courses.put(id, c);
				System.out.println("�ɹ���ӿγ̣�" + courses.get(id).name);
			} else {
				System.out.println("�ÿγ� id �Ѿ���ռ��");
				continue;
			}
		}
	}
	
	/**
     * ɾ�� Map �е�ӳ��
     * @param args
     */
	public void remove(){
		//��ȡ�Ӽ�������ģ���ɾ����  id �ַ���
		Scanner s = new Scanner(System.in);
		
		while(true){
			System.out.println("����exit����ɾ��");
			System.out.println("������Ҫɾ���Ŀγ� id");
			String id = s.next();
			String E = "exit";
			if(id.equals(E)){
				break;
			}
			//�� Course �в��Ҷ�Ӧ��  id
			Course course = courses.get(id);
			if(course == null){
				System.out.println("�ÿγ̲�����");
			}else{
				courses.remove(id);
				System.out.println("�ÿγ�"+"("+course.name+")"+"�Ѿ�ɾ��������Ӧ�� ID ����"+course.id+")");
			}
		}
		
	}
	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.put();
		mt.remove();
	}
}
