package com.tarena.guessingLetters;

import java.util.Scanner;

public class LetterGame_2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 0; // ��ʾ��Ҳ²�Ĵ���

		char[] input = null; // ��ʾ�û��²������

		int[] result = new int[2]; // ���ڱ����жϵĽ��

		Scanner scanner = new Scanner(System.in);
		System.out.println("��ӭ���Բ���ĸ��Ϸ");

		char[] chs = generate(); // ��ʾ�²���ַ���

		System.out.println("��Ϸ��ʼ�������������µ� 5 ����ĸ���У���exit ���� �˳���");

		while (true) {
			String inputStr = scanner.next().trim().toUpperCase();
			if ("EXIT".equals(inputStr)) { // equals() �Ƚ�������ĸ������
				System.out.println("лл��ĳ��ԣ��ټ���");
				break;
			}

			input = inputStr.toCharArray(); // toCharArray �ѱ������ת�����ַ�����
			result = check(chs, input);
			if (result[0] == chs.length) {
				int score = 100 * chs.length - count * 10;
				System.out.println("��ϲ��¶��ˣ���ĵ÷��ǣ�" + score);
				break;
			} else {
				count++;
				System.out.println("��¶�" + result[1] + "���ַ�������" + result[0]
						+ "���ַ���λ����ȷ�����ܴ���=" + count + ",exit--�˳���");
			}

		}
		scanner.close();
	}

	/**
	 * ���������Ҫ�²����ĸ����
	 * 
	 * @return �洢����ַ���������
	 */
	public static char[] generate() {
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		boolean[] flags = new boolean[letters.length]; //boolean �����Ĭ��ֵ�� false
		char[] chs = new char[5];
		for (int i = 0; i < chs.length; i++) {
			int index;
			do {
				index = (int) (Math.random() * (letters.length));
			} while (flags[index]); // �ж������ַ��Ƿ��ظ�������ظ�����ѭ��ֱ�� false Ϊֹ��  //������������ѭ����������ȥִ����������
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}

	public static int[] check(char[] chs, char[] input) {
		int[] result = new int[2];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < chs.length; j++) {
				if (input[i] == chs[j]) { // �ж��ַ��Ƿ���ȷ
					result[1]++;
					if (i == j) { // �ж�λ���Ƿ���ȷ
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
