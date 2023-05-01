package com.example.University.Event.Management.controller;

import com.example.University.Event.Management.model.Event;

import com.example.University.Event.Management.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EventController {
    @Autowired
    EventService eventService;

    @PostMapping(value="/saveEvent")
    public ResponseEntity<String> addEvent(@RequestBody Event eventData){
        Event event=eventService.addEvent(eventData);
        return new ResponseEntity<>("Event added", HttpStatus.OK);

    }
    @DeleteMapping(value="/deleteEvent/{eventId}")
    public ResponseEntity<String>deleteEvent(@PathVariable Integer eventId){
        boolean event=eventService.deleteEvent(eventId);
        if(event){

            return new ResponseEntity<>("Event deleted with Id-> "+eventId,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("please enter valid eventId",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/date/{date}")
    public List<Event> getEventByDate(@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);
        return eventService.getEventByDate(localDate);
    }
    @PutMapping
    public String updateEventByEventId(@RequestBody Event event){
        return eventService.updateEvent(event);
    }
}
