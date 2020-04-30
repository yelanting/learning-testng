/**
 * @author : 孙留平
 * @since : 2020年4月30日 上午9:05:49
 * @see:
 */
package com.autotest.java.demo.restassured;

import static io.restassured.RestAssured.given;

/**
 * @author : Administrator
 * @since : 2020年4月30日 上午9:05:49
 * @see :
 */
public class RestAssuredDemo {

	public void restAssuredTest() {
		given().when().get().then().statusCode(200);
	}

}
