package PAF.day2_workshop.RestController;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import PAF.day2_workshop.Models.Rsvps;
import PAF.day2_workshop.Service.RsvpService;

@RestController
@RequestMapping("/api")
public class RsvpRestController {
    @Autowired
    private RsvpService rsvpService;

    @GetMapping("/rsvps")
    public ResponseEntity<List<Rsvps>> getAll() {
        return ResponseEntity.ok(rsvpService.getAll());
    }

    @GetMapping("/rsvp")
    public ResponseEntity<Rsvps> getByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(rsvpService.getByName(name));
    }

    @PostMapping("/rsvp")
    public ResponseEntity<List<Rsvps>> add(@RequestBody Rsvps rsvp) {
        Boolean success = rsvpService.add(rsvp);
        if (success) {
            return ResponseEntity.status(201).body(rsvpService.getAll());
        }

        return ResponseEntity.status(404).body(Collections.emptyList());
    }

    @PutMapping("/rsvp/{email}")
    public ResponseEntity<List<Rsvps>> update(@PathVariable("email") String email,@RequestBody Rsvps rsvp){
        Boolean success = rsvpService.update(email, rsvp);
        if(success){
            return ResponseEntity.status(201).body(rsvpService.getAll());
        }

        return ResponseEntity.status(404).body(Collections.emptyList());
    }


    @GetMapping("/rsvps/count")
    public ResponseEntity<Integer> getCount(){
        return ResponseEntity.status(201).body(rsvpService.getCount());
    }


}
