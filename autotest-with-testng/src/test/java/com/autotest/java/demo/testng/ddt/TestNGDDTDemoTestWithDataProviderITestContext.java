/**
 * @author : 孙留平
 * @since : 2020年4月29日 下午2:37:04
 * @see:
 */
package com.autotest.java.demo.testng.ddt;

import java.lang.reflect.Method;
import java.util.Arrays;

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
public class TestNGDDTDemoTestWithDataProviderITestContext {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDDTDemoTestWithDataProviderITestContext.class);

	private TestNGDemo testNGDemo;

	@BeforeMethod
	private void initInstance() {
		testNGDemo = new TestNGDemo();
	}

	@Test(dataProvider = "initTestUsersWithDataProviderParamOfDiffTestMethod", groups = {
	        "testGroup1" })
	public void validateUserTestWithProviderParamOne(String name, String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@Test(dataProvider = "initTestUsersWithDataProviderParamOfDiffTestMethod", groups = {
	        "testGroup2" })
	public void validateUserTestWithProviderParamTwo(String name, String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@Test(dataProvider = "initTestUsersWithDataProviderParamOfDiffTestMethod", groups = {
	        "testGroup1", "testGroup2" })
	public void validateUserTestWithProviderParamDefault(String name,
	        String sex) {
		LOGGER.debug("name：{},sex:{}", name, sex);
		testNGDemo.validateUser(name, sex);
	}

	@DataProvider(name = "initTestUsersWithDataProviderParamOfDiffTestMethod")
	public Object[][] initTestUsersWithDataProviderParamOfDiffTestMethod(
	        Method method, ITestContext iTestContext) {
		LOGGER.debug(
		        "initTestUsersWithDataProviderParamOfDiffTestMethod方法被调用,传入上下文信息:{}",
		        iTestContext);

		String[] groups = iTestContext.getIncludedGroups();
		String suite = iTestContext.getName();

		LOGGER.debug("测试组:{},suite:{}", Arrays.asList(groups), suite);

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
