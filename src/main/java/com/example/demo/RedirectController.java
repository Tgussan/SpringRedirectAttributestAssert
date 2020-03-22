package com.example.demo;

import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("redi")
public class RedirectController {

	@GetMapping
	public String redirect(Message message,Model model, @ModelAttribute("test") TestDto receive) {
		System.out.println(receive.getIdString());
		
		return "";
	}
}
