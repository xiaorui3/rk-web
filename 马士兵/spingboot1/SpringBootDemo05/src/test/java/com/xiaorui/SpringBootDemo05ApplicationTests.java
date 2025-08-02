package com.xiaorui;

import com.xiaorui.service.XiaoruiService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDemo05ApplicationTests {
	@Autowired
	private XiaoruiService xiaoruiService;

	@Test
	void contextLoads() {
		System.out.println(xiaoruiService.selectOne(1));
	}

	@BeforeEach
	public void Before(){
		System.out.println("测试单元开始");
	}
	@AfterEach
	public void After(){
		System.out.println("测试单元结束");
	}

}
