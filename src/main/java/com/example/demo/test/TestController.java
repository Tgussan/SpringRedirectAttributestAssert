package com.example.demo.test;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.TestDto;

@Controller
@RequestMapping("test")
public class TestController {
	
	@GetMapping("start")
	public String start() throws Exception { 
		
        
        return "start";
    }

	@PostMapping("post")
	public String run(Model model,Message message, RedirectAttributes redirectAttributes) throws Exception { 
		TestDto dto = new TestDto();
		dto.setIdString("test");
		dto.setNameString("testName");
        redirectAttributes.addFlashAttribute("test", dto);
        return "redirect:/redi";
    }
}
