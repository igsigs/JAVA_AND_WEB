package com.tarena.guessingLetters;

import java.util.Scanner;

public class LetterGame_2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int count = 0; // 表示玩家猜测的次数

		char[] input = null; // 表示用户猜测的数据

		int[] result = new int[2]; // 用于保存判断的结果

		Scanner scanner = new Scanner(System.in);
		System.out.println("欢迎尝试猜字母游戏");

		char[] chs = generate(); // 表示猜测的字符串

		System.out.println("游戏开始，请输入你所猜的 5 个字母序列：（exit —— 退出）");

		while (true) {
			String inputStr = scanner.next().trim().toUpperCase();
			if ("EXIT".equals(inputStr)) { // equals() 比较两个字母相等与否
				System.out.println("谢谢你的尝试，再见！");
				break;
			}

			input = inputStr.toCharArray(); // toCharArray 把别的数据转换成字符数组
			result = check(chs, input);
			if (result[0] == chs.length) {
				int score = 100 * chs.length - count * 10;
				System.out.println("恭喜你猜对了！你的得分是：" + score);
				break;
			} else {
				count++;
				System.out.println("你猜对" + result[1] + "个字符，其中" + result[0]
						+ "个字符的位置正确！（总次数=" + count + ",exit--退出）");
			}

		}
		scanner.close();
	}

	/**
	 * 随机生成需要猜测的字母序列
	 * 
	 * @return 存储随机字符串的数组
	 */
	public static char[] generate() {
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		boolean[] flags = new boolean[letters.length]; //boolean 数组的默认值是 false
		char[] chs = new char[5];
		for (int i = 0; i < chs.length; i++) {
			int index;
			do {
				index = (int) (Math.random() * (letters.length));
			} while (flags[index]); // 判断生成字符是否重复，如果重复继续循环直到 false 为止。  //满足条件继续循环否则跳出去执行下面的语句
			chs[i] = letters[index];
			flags[index] = true;
		}
		return chs;
	}

	public static int[] check(char[] chs, char[] input) {
		int[] result = new int[2];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < chs.length; j++) {
				if (input[i] == chs[j]) { // 判断字符是否正确
					result[1]++;
					if (i == j) { // 判断位置是否正确
						result[0]++;
					}
					break;
				}
			}
		}
		return result;
	}
}
