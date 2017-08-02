package com.shiyanlou.yichang;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		try {
			bar(12);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("End");
	}

	public static void bar(int age) throws IllegalArgumentException {
		if (age < 18) {
			throw new IllegalArgumentException("Î´ÂúÊ®°ËËê");
		} else {
			System.out.println("»¶Ó­¹âÁÙ");
		}
	}

}
