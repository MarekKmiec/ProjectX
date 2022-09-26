package pl.coderslab.projectx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.projectx.domain.Event;
import pl.coderslab.projectx.repository.EventRepository;

import java.util.List;
@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventsRepository) {
        this.eventRepository = eventsRepository;
    }
    public Event saveEvents(Event event){
        eventRepository.save(event);
        return event;
    }
    public List<Event> findAll(){
        return eventRepository.findAll();
    }

    public Event findById(Long id){
        return  eventRepository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        eventRepository.deleteById(id);
    }
}
