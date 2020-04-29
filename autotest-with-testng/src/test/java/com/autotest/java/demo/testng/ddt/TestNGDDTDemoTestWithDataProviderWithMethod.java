/**
 * @author : 孙留平
 * @since : 2020年4月29日 下午2:37:04
 * @see:
 */
package com.autotest.java.demo.testng.ddt;

import java.lang.reflect.Method;

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
public class TestNGDDTDemoTestWithDataProviderWithMethod {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDDTDemoTestWithDataProviderWithMethod.class);

	private TestNGDemo testNGDemo;

	@BeforeMethod
	private void initInstance() {
		testNGDemo = new TestNGDemo();
	}

	// @Test
	// @Ignore
	// public void validateUserTest(String name, String sex) {
	// LOGGER.debug("name：{},sex:{}", name, sex);
	// testNGDemo.validateUser(name, sex);
	// }
	//
	// @Test(dataProvider = "initTestUsersClearly")
	// @Ignore
	// public void validateUserTestWithProviderClearly(String name, String sex)
	// {
	// LOGGER.debug("name：{},sex:{}", name, sex);
	// testNGDemo.validateUser(name, sex);
	// }
	//
	// @Test(dataProvider = "initTestUsersUnClearly")
	// @Ignore
	// public void validateUserTestWithProviderUnClearly(String name, String
	// sex) {
	// LOGGER.debug("name：{},sex:{}", name, sex);
	// LOGGER.debug("testNGDemo:{}", testNGDemo);
	// testNGDemo.validateUser(name, sex);
	// }
	//
	// @DataProvider(name = "initTestUsersClearly")
	// public Object[][] initTestUsersClearly() {
	// LOGGER.debug("initTestUsersClearly方法被调用");
	// return new Object[][] { { "admin", "man" }, { "admin2", "women" },
	// { "admin", "women" } };
	//
	// }
	//
	// @DataProvider
	// public Object[][] initTestUsersUnClearly() {
	// LOGGER.debug("initTestUsersUnClearly方法被调用");
	// return new Object[][] { { "admin", "man" }, { "admin2", "women" },
	// { "admin", "women" } };
	// }
	//
	// @Test(dataProvider = "initTestUsersWithDataProviderParam")
	// @Ignore
	// public void validateUserTestWithProviderParam(String name, String sex) {
	// LOGGER.debug("name：{},sex:{}", name, sex);
	// testNGDemo.validateUser(name, sex);
	// }

	// @DataProvider(name = "initTestUsersWithDataProviderParam")
	// public Object[][] initTestUsersWithDataProviderParam(Method method,
	// ITestContext iTestContext) {
	// LOGGER.debug("initTestUsersWithDataProviderParam方法被调用,传入参数:{},传入上下文:{}",
	// method, iTestContext);
	// return new Object[][] { { "admin", "man" }, { "admin2", "women" },
	// { "admin", "women" } };
	// }

	@Test(dataProvider = "initTestUsersWithDataProviderParamOfDiffTestMethod")
	public void validateUserTestWithProviderParamOne(String name, String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@Test(dataProvider = "initTestUsersWithDataProviderParamOfDiffTestMethod")
	public void validateUserTestWithProviderParamTwo(String name, String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@Test(dataProvider = "initTestUsersWithDataProviderParamOfDiffTestMethod")
	public void validateUserTestWithProviderParamDefault(String name,
	        String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@DataProvider(name = "initTestUsersWithDataProviderParamOfDiffTestMethod")
	public Object[][] initTestUsersWithDataProviderParamOfDiffTestMethod(
	        Method method, ITestContext iTestContext) {
		LOGGER.debug(
		        "initTestUsersWithDataProviderParamOfDiffTestMethod方法被调用,传入参数:{},传入上下文:{}",
		        method, iTestContext);

		Object[][] resultObjects = new Object[][] { { "admin", "man" },
		        { "admin2", "women" } };

		if (method.getName().equals("validateUserTestWithProviderParamOne")) {
			resultObjects = new Object[][] { { "admin", "man" },
			        { "admin3", "women" }, { "admin4", "women" } };
		} else if (method.getName()
		        .equals("validateUserTestWithProviderParamTwo")) {
			resultObjects = new Object[][] { { "admin", "man" },
			        { "admin5", "women" }, { "admin6", "women" } };
		}
		return resultObjects;
	}

}
