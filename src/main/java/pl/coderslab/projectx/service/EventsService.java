package pl.coderslab.projectx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.projectx.domain.Events;
import pl.coderslab.projectx.domain.User;
import pl.coderslab.projectx.repository.EventsRepository;

import java.util.List;
@Service
@Transactional
public class EventsService {

    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }
    public Events saveEvents(Events events){
        eventsRepository.save(events);
        return events;
    }
    public List<Events> findAll(){
        return eventsRepository.findAll();
    }

    public Events findById(Long id){
        return  eventsRepository.findById(id).orElseThrow();
    }

    public void delete(Long id){
        eventsRepository.deleteById(id);
    }
}
