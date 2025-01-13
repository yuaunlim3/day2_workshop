package PAF.day2_workshop.Models;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Rsvps {
    private int id;
    private String name;
    private String email;
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate confirmation_date;
    private String comments;

    

    public Rsvps() {
    }

    
    public Rsvps(int id, String name, String email, String phone, LocalDate confirmation_date, String comments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.confirmation_date = confirmation_date;
        this.comments = comments;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDate getConfirmation_date() {
        return confirmation_date;
    }
    public void setConfirmation_date(LocalDate confirmation_date) {
        this.confirmation_date = confirmation_date;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public String toString() {
        return "Rsvps [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", confirmation_date="
                + confirmation_date + ", comments=" + comments + "]";
    }

    

    
}
