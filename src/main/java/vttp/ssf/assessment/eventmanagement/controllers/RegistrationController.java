package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.User;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping
public class RegistrationController {

    @Autowired
    RedisRepository repo;

    @GetMapping("events/register/{index}")
    public String register(@PathVariable("index") int index, Model model) {

        Event event = repo.getEvent(index);
        String eventName = event.getEventName();
        long eventDate = event.getEventDate();
        User user = new User();
        model.addAttribute("eventName", eventName);
        model.addAttribute("eventDate", eventDate);
        model.addAttribute("user", user);

        return "eventregistration";

    }
}

// TODO: Task 7