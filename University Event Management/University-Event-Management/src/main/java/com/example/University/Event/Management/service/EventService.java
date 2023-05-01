package com.example.University.Event.Management.service;

import com.example.University.Event.Management.dao.ModelRepository;
import com.example.University.Event.Management.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {
    @Autowired
    ModelRepository eventRepository;


    public Event addEvent(Event eventData) {
        return eventRepository.save(eventData);
    }



    public boolean deleteEvent(Integer eventId) {
        if(eventRepository.findById(eventId).isPresent()){
            eventRepository.deleteById(eventId);
            return true;

        }
        else{
            return false;
        }
    }
    public List<Event> getEventByDate(LocalDate localDate) {
        return eventRepository.findAllByDate(localDate);
    }
    public String updateEvent(Event event) {
        if(eventRepository.existsById(event.getEventId())){
            eventRepository.save(event);
            return "Updated successfully";
        }
        return "No Event to update like this,you can add new event with this Id ";
    }
    }

