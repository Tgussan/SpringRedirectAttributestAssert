package com.example.demo.test;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.TestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@WithMockUser
	public void test() throws Exception {
		TestDto dto = new TestDto();
		dto.setIdString("test");
		dto.setNameString("testName");
		MvcResult result = this.mockMvc.perform(post("/test/post")
				.with(SecurityMockMvcRequestPostProcessors.csrf()))
		.andExpect(status().is3xxRedirection())
		.andExpect(flash().attribute("test", isA(TestDto.class))).andReturn();
		
		TestDto dto2 = (TestDto) result.getFlashMap().get("test");
		assertEquals(dto2.getIdString(), "test");
		assertEquals(dto2.getNameString(), "testName");
	}
}
