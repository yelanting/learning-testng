/**
 * @author : 孙留平
 * @since : 2020年4月24日 下午2:53:05
 * @see:
 */
package com.autotest.java.demo.testng;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : Administrator
 * @since : 2020年4月24日 下午2:53:05
 * @see :
 */
public class TestNGDemoTest {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDemoTest.class);

	private TestNGDemo testNGDemo;

	public TestNGDemoTest() {
		LOGGER.info("{}测试类被初始化", TestNGDemoTest.class.getName());
	}

	@BeforeClass
	public void setUpClass() {
		LOGGER.debug("测试类:{}", TestNGDemoTest.class.getName());
		testNGDemo = new TestNGDemo();
	}

	@Test(expectedExceptions = FileNotFoundException.class)
	public void withOneException() throws FileNotFoundException {
		testNGDemo.methodThrowsOneException(1);
	}

	@Test(expectedExceptions = { FileNotFoundException.class,
	        ArithmeticException.class })
	public void withMoreThanOneExceptionOfFNF()
	        throws FileNotFoundException, ArithmeticException {
		testNGDemo.methodThrowsMoreThanOneException(2);
	}

	@Test(expectedExceptions = { FileNotFoundException.class,
	        ArithmeticException.class }, dependsOnMethods = "testWithDependAlwaysSuccess")
	public void withMoreThanOneExceptionOfArith()
	        throws FileNotFoundException, ArithmeticException {
		return;
		// testNGDemo.methodThrowsMoreThanOneException(1);
	}

	@Test
	public void testWithDependAlwaysSuccess() {
		// 这是一个永远会成功的测试用例
	}
}
