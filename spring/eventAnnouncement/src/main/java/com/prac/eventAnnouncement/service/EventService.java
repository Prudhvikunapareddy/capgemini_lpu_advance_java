package com.prac.eventAnnouncement.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.prac.eventAnnouncement.entity.Event;
import com.prac.eventAnnouncement.repository.EventRepository;

@Service
public class EventService {

    private EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    public Event getEventById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Event> getByType(String type) {
        return repo.findByEventType(type);
    }

    public List<Event> searchByTitle(String title) {
        return repo.findByTitleContaining(title);
    }

    public Event createEvent(Event event) {
        return repo.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        Event existing = repo.findById(id).orElseThrow();

        existing.setTitle(event.getTitle());
        existing.setDescription(event.getDescription());
        existing.setLocation(event.getLocation());

        return repo.save(existing);
    }

    public void deleteEvent(Long id) {
        repo.deleteById(id);
    }
}