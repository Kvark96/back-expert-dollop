package dtos;

import entities.Conference;

public class ConferenceDTO {
    private String name;
    private String location;
    private String capacity;
    private String date;
    private String time;

    public ConferenceDTO(String name, String location, String capacity, String date, String time) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
        this.date = date;
        this.time = time;
    }

    public ConferenceDTO(Conference conf){
        this.name = conf.getName();
        this.location = conf.getLocation();
        this.capacity = conf.getCapacity();
        this.date = conf.getDate();
        this.time = conf.getTime();
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
