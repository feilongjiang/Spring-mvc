package app06a;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customtag.MyFunctions;
import junit.framework.Assert;

class Mytest {

	@Test
	void test() {
		String result ="f2d1s";
		assertEquals("fd2s", MyFunctions.reverseString("sdf"));
		//fail("Not yet implemented");
	}

}
