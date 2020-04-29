/**
 * @author : 孙留平
 * @since : 2020年4月24日 下午6:31:11
 * @see:
 */
package com.autotest.java.demo.testng.model;

/**
 * @author : Administrator
 * @since : 2020年4月24日 下午6:31:11
 * @see :此处用一个矩形来测试
 */
public class RectangleModel {
	private int width;
	private int length;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "RectangleModel [width=" + width + ", length=" + length + "]";
	}

	public RectangleModel(int width, int length) {
		super();
		this.width = width;
		this.length = length;
	}

	public RectangleModel() {
		super();
	}

}
