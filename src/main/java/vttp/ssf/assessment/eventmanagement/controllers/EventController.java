package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

	
}
