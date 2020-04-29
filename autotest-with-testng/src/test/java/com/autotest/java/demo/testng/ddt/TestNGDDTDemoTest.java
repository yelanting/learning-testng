/**
 * @author : 孙留平
 * @since : 2020年4月29日 下午2:37:04
 * @see:
 */
package com.autotest.java.demo.testng.ddt;

import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.autotest.java.demo.testng.TestNGDemo;

/**
 * @author : Administrator
 * @since : 2020年4月29日 下午2:37:04
 * @see :
 */
public class TestNGDDTDemoTest {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDDTDemoTest.class);

	private TestNGDemo testNGDemo;

	@BeforeClass
	private void initInstance() {
		testNGDemo = new TestNGDemo();
	}

	@Test
	@Parameters({ "name", "sex" })
	public void validateUserTest(String name, String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		boolean result = testNGDemo.validateUser(name, sex);
		LOGGER.debug("验证结果:{}", result);
	}
}
