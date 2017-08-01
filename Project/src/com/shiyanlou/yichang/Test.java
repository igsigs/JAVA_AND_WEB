package com.shiyanlou.yichang;
/**
 * 课程目标：
 * 异常概念、异常分类、Java异常处理机制、
 * try...catch...finally、throw 和 throws、自定义异常
 * 1、什么是异常：所谓异常就是指在程序运行的过程中发生的一些不正常事件。
 * （如：除0溢出，数组下标越界，所要读取的文件不存在）
 * 2、异常导致的后果：Java程序的执行过程中如出现异常事件，可以生成一个异常类
 * 对象，该异常对象封装了异常事件的信息，并将其被提交java运行时系统，这个过程
 * 称为抛出异常，不处理的话会直接导致程序直接中断。
 * 3、如何防止程序中断：设计良好的程序应该在程序异常发生时提供处理这些异常的方法，
 * 使得程序不会因为异常的发生而阻断或产生不可预见的结果。
 *异常分类：
 *  受查异常：
 *       包括：Exception及其子类（不包括runtimeException）。
 *       来源：由代码掌控能力之外的因素导致的运行时错误。
 *       处理：必须处理，否则通不过编译。
 *  非受查异常：
 *       包括：Error 和 RuntimeException 及其子类
 *       来源：RuntimeException 一般代表编程错误
 *       处理：可以不用处理。
 *     
 * Java异常处理机制
 * Java的异常是通过两种机制来处理的
 * 捕获:try-catch-finally
 * 抛出：throw，throws
 *
 *        捕获异常                                                  抛出异常
 *   try  监控区域，执行可能           throw  手动抛出异常
 *        产出异常的代码
 *        
 *   catch 捕获。处理异常                throws  声明方法可能要抛出的异常
 *                               （告诉调用者，这个方法可能要抛出什么类型的异常，让调用者去捕获他所要调用的这个方法，所要抛出的异常）   
 *   finally 善后处理，无论是
 *           否发生异常，代码
 *           总能执行。
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
