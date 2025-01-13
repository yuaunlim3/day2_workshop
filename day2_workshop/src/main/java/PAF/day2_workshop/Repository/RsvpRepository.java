package PAF.day2_workshop.Repository;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import PAF.day2_workshop.Models.Rsvps;
import PAF.day2_workshop.Models.exception.ResourceNotFoundException;
import PAF.day2_workshop.Utils.Sql;

@Repository
public class RsvpRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Rsvps> getAll() {
        List<Rsvps> rsvps = template.query(Sql.getAll, (rs, num) -> {
            Rsvps rsvp = new Rsvps();
            rsvp.setId(rs.getInt("id"));
            rsvp.setName(rs.getString("name"));
            rsvp.setEmail(rs.getString("email"));
            rsvp.setPhone(rs.getString("phone"));
            rsvp.setConfirmation_date(rs.getDate("confirmation_date").toLocalDate());
            rsvp.setComments(rs.getString("comments"));
            return rsvp;
        });

        return rsvps;
    }

    public Rsvps getByName(String name) {
        Rsvps rsvp = null;
        try {
            rsvp = template.queryForObject(Sql.getByName, BeanPropertyRowMapper.newInstance(Rsvps.class), name);

            return rsvp;
        } catch (DataAccessException ex) {
            throw new ResourceNotFoundException(String.format("%s not in the database", name));

        }
    }

    private Boolean checkExistance(String name) {
        SqlRowSet result = template.queryForRowSet(Sql.checkName, name);
        while (result.next()) {
            int count = result.getInt("count(*)");
            if (count > 0) {
                return true;
            }
        }

        return false;
    }

    public Boolean addNew(Rsvps rsvps) {
        String name = rsvps.getName();
        String email = rsvps.getEmail();
        String phone = rsvps.getPhone();
        String comments = rsvps.getComments();

        int temp = 0;
        if (checkExistance(name)) {
            temp = template.update(Sql.update, email, phone, comments, name);
        } else {
            // System.out.println(rsvps.toString());
            temp = template.update(Sql.addNew, name, email, phone, rsvps.getConfirmation_date(), comments);
        }

        if (temp > 0) {
            return true;
        }

        return false;
    }

    public Boolean update(String email, Rsvps rsvps) {
        int temp = template.update(Sql.updateEmail, rsvps.getPhone(), rsvps.getComments(), email);
        if (temp > 0) {
            return true;

        }

        return false;
    }

    public Integer getCount() {
        return template.queryForObject(Sql.getCount, Integer.class);
    }



}
