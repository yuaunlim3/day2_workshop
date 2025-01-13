package PAF.day2_workshop.Utils;

public class Sql {
    public static final String getAll = "select * from RSVP";

    public static final String getByName = "select * from RSVP where name = ?";

    public static final String addNew = "insert into RSVP(name,email,phone,confirmation_date,comments) values(?,?,?,?,?)";

    public static final String update = "update RSVP set email = ?,phone = ?, comments = ? where name = ?";

    public static final String updateEmail = "update RSVP set phone = ?, comments = ? where email = ?";

    public static final String checkName = "select count(*) from RSVP where name = ?";

    public static final String getCount = "select count(*) from RSVP";
}

