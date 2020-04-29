/**
 * @author : 孙留平
 * @since : 2020年4月24日 下午6:30:10
 * @see:
 */
package com.autotest.java.demo.testng;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.autotest.java.demo.testng.model.RectangleModel;

/**
 * @author : Administrator
 * @since : 2020年4月24日 下午6:30:10
 * @see :该类实现Itest，则可以指定类名
 */
public class TestNGDemoWithFactoryTestImplementITest implements ITest {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDemoWithFactoryTestImplementITest.class);

	private RectangleModel rectangleModel;
	private int width;
	private int length;

	public TestNGDemoWithFactoryTestImplementITest(int width, int length) {
		this.rectangleModel = new RectangleModel(width, length);
	}

	@Test
	public void testWidth() {
		LOGGER.debug("宽度{}", this.rectangleModel.getWidth());
	}

	@Test
	public void testLength() {
		LOGGER.debug("长度{}", this.rectangleModel.getLength());
	}

	@Factory
	public static Object[] create() {
		List result = new ArrayList<>();

		result.add(new TestNGDemoWithFactoryTestImplementITest(1, 2));
		result.add(new TestNGDemoWithFactoryTestImplementITest(4, 5));

		return result.toArray();

	}

	@Factory
	public static Object[] create2() {
		List result = new ArrayList<>();

		result.add(new TestNGDemoWithFactoryTestImplementITest(6, 7));
		result.add(new TestNGDemoWithFactoryTestImplementITest(8, 9));

		return result.toArray();

	}

	@Override
	public String getTestName() {
		// return "[TestNGDemoWithFactoryTestImplementITest]=>["
		// + this.rectangleModel.getLength() + ","
		// + this.rectangleModel.getWidth() + "]";

		return "Rectangle:" + this.rectangleModel + "";
	}
}
