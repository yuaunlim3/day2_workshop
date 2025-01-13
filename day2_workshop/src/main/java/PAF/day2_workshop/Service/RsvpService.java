package PAF.day2_workshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF.day2_workshop.Models.Rsvps;
import PAF.day2_workshop.Repository.RsvpRepository;

@Service
public class RsvpService {
    @Autowired
    private RsvpRepository rsvpRepository;

    public List<Rsvps> getAll() {
        return rsvpRepository.getAll();
    }

    public Rsvps getByName(String name){
        return rsvpRepository.getByName(name);

    }

    public Boolean add(Rsvps rsvp){
        return rsvpRepository.addNew(rsvp);
    }

    public Boolean update(String email,Rsvps rsvp){
        return rsvpRepository.update(email,rsvp);
    }

    public Integer getCount(){
        return rsvpRepository.getCount();
    }
}
