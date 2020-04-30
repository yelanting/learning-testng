/**
 * @author : 孙留平
 * @since : 2020年4月29日 下午2:37:04
 * @see:
 */
package com.autotest.java.demo.testng.ddt;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autotest.java.demo.testng.TestNGDemo;

/**
 * @author : Administrator
 * @since : 2020年4月29日 下午2:37:04
 * @see :
 */
public class TestNGDDTDemoTestWithDataProviderWithLazyInit {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDDTDemoTestWithDataProviderWithLazyInit.class);

	private TestNGDemo testNGDemo;

	@BeforeMethod
	private void initInstance() {
		testNGDemo = new TestNGDemo();
	}

	@Test(dataProvider = "initTestUsersWithoutDataProviderOfLazyInit")
	public void validateUserTestWithProviderParamTwo(String name, String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@Test(dataProvider = "initTestUsersWithDataProviderOfLazyInit")
	public void validateUserTestWithProviderParamDefault(String name,
	        String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@DataProvider(name = "initTestUsersWithDataProviderOfLazyInit")
	public Iterator initTestUsersWithDataProviderOfLazyInit(Method method,
	        ITestContext iTestContext) {
		LOGGER.debug("initTestUsersWithDataProviderOfLazyInit方法被调用,传入上下文信息:{}",
		        iTestContext);
		Iterator iterator = new DataInitIterator();

		LOGGER.debug("Iterator:{}", iterator);
		return iterator;
	}

	@DataProvider(name = "initTestUsersWithoutDataProviderOfLazyInit")
	public Object[][] initTestUsersWithoutDataProviderOfLazyInit(Method method,
	        ITestContext iTestContext) {
		LOGGER.debug(
		        "initTestUsersWithoutDataProviderOfLazyInit方法被调用,传入上下文信息:{}",
		        iTestContext);

		Object[][] resultObjects = new Object[][] { { "admin", "man" },
		        { "admin2", "women" } };

		return resultObjects;
	}

	class DataInitIterator implements Iterator {
		static private final int MAX = 4;
		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < MAX;
		}

		@Override
		public Object next() {
			int thisIndex = index++;
			// 此处需要返回一个数组，因为每个位置是数组，才能放在一起组成一个跟二维数组等效的iterator
			return new Object[] { "admin" + thisIndex, "sex" + thisIndex };
		}

		public void remote() {
			throw new UnsupportedOperationException();
		}

	}
}
