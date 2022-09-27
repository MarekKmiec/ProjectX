package pl.coderslab.projectx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.projectx.domain.Event;
import pl.coderslab.projectx.repository.EventRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Long> allEventAndId(List<Event> events){
        Map<String,Long> allEventByIdMap=new HashMap<>();
        for (Event event : events) {
            String nameKey=event.getName();
            allEventByIdMap.put(nameKey,event.getId());
        }
        return  allEventByIdMap;
    }
}
