/**
 * @author : 孙留平
 * @since : 2020年4月24日 下午2:43:03
 * @see:
 */
package com.autotest.java.demo.testng;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Administrator
 * @since : 2020年4月24日 下午2:43:03
 * @see :
 */
public class TestNGDemo {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDemo.class);

	public TestNGDemo() {
		LOGGER.info("{}构造方法被初始化", TestNGDemo.class.getName());
	}

	public void methodThrowsOneException(int exceptionType)
	        throws FileNotFoundException {
		LOGGER.info("这是一个抛出一个异常的方法");
		throw new FileNotFoundException("文件不存在");
	}

	public void methodThrowsMoreThanOneException(int exceptionType)
	        throws FileNotFoundException, ArithmeticException {
		LOGGER.info("这是一个抛出多于一个异常的方法");
		switch (exceptionType) {
			case 1:
				LOGGER.debug("文件不存在异常");
				throw new FileNotFoundException("文件不存在");
			case 2:
				LOGGER.debug("算术异常");
				throw new ArithmeticException("算术异常");
			default:
				break;
		}
	}

	/**
	 * 带参数的
	 */
	public boolean validateUser(String name, String sex) {
		if ("admin".equals(name) && "man".equals(sex)) {
			return true;
		}

		return false;
	}
}
