package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Conference implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String capacity;
    private String date;
    private String time;

    public Conference(){}

    public Conference(String name, String location, String capacity, String date, String time) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
