package vttp.ssf.assessment.eventmanagement.controllers;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.User;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping("events/register/{index}")
public class RegistrationController {

    @Autowired
    RedisRepository repo;

    @GetMapping
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

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute User user, Event event, BindingResult binding,
            Model model) {
        String errorMessage;

        if (binding.hasErrors()) {
            return "errorregistration";
        }

        if (!user.isValidAge()) {
            FieldError err = new FieldError("user", "dob", "You must be at least 21 years old");
            binding.addError(err);
            errorMessage = "You must be at least 21 years old to register for the event";
            model.addAttribute("exception", errorMessage);
            return "errorregistration";
        }

        int supply = event.getEventSize();
        int people = event.getParticipants();
        int tickets = user.getTicketno();
        int demand = people + tickets;
        if (supply < demand) {
            FieldError err = new FieldError("user", "ticketno", "Insufficient tickets available");
            binding.addError(err);
            errorMessage = "Insufficient tickets available to meet your ticket request";
            model.addAttribute("exception", errorMessage);
            return "errorregistration";
        }

        int updatedSupply = people + tickets;
        people = updatedSupply;
        repo.saveRecord(event);
        return "successregistration";

    }

}
