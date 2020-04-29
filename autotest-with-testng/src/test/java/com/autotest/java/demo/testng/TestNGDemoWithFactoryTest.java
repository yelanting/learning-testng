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
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.autotest.java.demo.testng.model.RectangleModel;

/**
 * @author : Administrator
 * @since : 2020年4月24日 下午6:30:10
 * @see :
 */
public class TestNGDemoWithFactoryTest {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(TestNGDemoWithFactoryTest.class);

	private RectangleModel rectangleModel;
	private int width;
	private int length;

	public TestNGDemoWithFactoryTest(int width, int length) {
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

		result.add(new TestNGDemoWithFactoryTest(1, 2));
		result.add(new TestNGDemoWithFactoryTest(4, 5));

		return result.toArray();

	}

	@Factory
	public Object[] create2() {
		List result = new ArrayList<>();

		result.add(new TestNGDemoWithFactoryTest(6, 7));
		result.add(new TestNGDemoWithFactoryTest(8, 9));

		return result.toArray();

	}
}
