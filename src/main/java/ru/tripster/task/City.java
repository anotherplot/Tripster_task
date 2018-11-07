package ru.tripster.task;

public class City {

    private String shortname;

    public City(String shortname, String fullname) {
        this.shortname = shortname;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    private String fullname;

    public String getShortname() {
        return shortname;
    }


}
