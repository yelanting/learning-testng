/**
 * @author : 孙留平
 * @since : 2020年4月24日 下午1:01:08
 * @see:
 */
package com.autotest.java.demo.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author : Administrator
 * @since : 2020年4月24日 下午1:01:08
 * @see :不要怀疑，这个两个测试用例都会通过（关注点：测试类在执行每个方法的时候，都会重新初始化）
 */
public class JunitTestDemo {
	private int count = 0;

	/**
	 * 构造方法可以选择性开启，你会发现会调用两次
	 * 
	 * @see :
	 */
	public JunitTestDemo() {
		System.out.println("构造方法初始化了");
	}

	@Test
	public void test1() {
		count++;
		assertEquals(1, count);
	}

	@Test
	public void test2() {
		count++;
		assertEquals(1, count);
	}
}
