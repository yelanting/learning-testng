/**
 * @author : 孙留平
 * @since : 2020年4月27日 上午11:50:27
 * @see:
 */
package com.autotest.java.demo.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author : Administrator
 * @since : 2020年4月27日 上午11:50:27
 * @see :
 */
public class StreamTest {
	public static void main(String[] args) throws IOException {
		String pngString = "G:\\移动硬盘\\hibernate.cfg.xml";

		BufferedReader fileReader = new BufferedReader(
		        new FileReader(new File(pngString)));

		String line = null;
		while (null != (line = fileReader.readLine())) {
			System.out.println(line);

		}

	}

}
