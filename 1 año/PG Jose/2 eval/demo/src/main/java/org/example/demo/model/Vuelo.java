package org.example.demo.model;

import java.time.LocalDate;

public class Vuelo {
    private int idFlight;
    private String numFlight;
    private String destination;
    private LocalDate departure;
    private int duration;

    public Vuelo(int idFlight, String numFlight, String destination, LocalDate departure, int duration) {
        this.idFlight = idFlight;
        this.numFlight = numFlight;
        this.destination = destination;
        this.departure = departure;
        this.duration = duration;
    }

    public Vuelo(String numFlight, String destination, LocalDate departure, int duration) {
        this.numFlight = numFlight;
        this.destination = destination;
        this.departure = departure;
        this.duration = duration;
    }

    public int getIdFlight() { return idFlight; }
    public String getNumFlight() { return numFlight; }
    public String getDestination() { return destination; }
    public LocalDate getDeparture() { return departure; }
    public int getDuration() { return duration; }
}