package com.gurkan.dms;

import com.gurkan.dms.util.DMSUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DmsApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertEquals("TEST", DMSUtil.sessionUser(), "error");
	}

}
