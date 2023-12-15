package vttp.ssf.assessment.eventmanagement.controllers;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping
public class EventController {

	@Autowired
	RedisRepository repo;

	@GetMapping("/events/listing")
	public ModelAndView displayEvents() {
		ModelAndView mav = new ModelAndView("view0");
		long size = repo.getNumberOfEvents();
		for (int index = 0; index < size; index++) {
			Event event = repo.getEvent(index);
			mav.addObject("event", event);
		}
		return mav;
	}

	@GetMapping("/events/register/2")
	public String showPage(Model model){
		model.addAttribute("event", new Event());
		return "view1";
	}
}

//copy