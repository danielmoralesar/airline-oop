package org.ies.airline.model;

import java.util.Objects;

public class Passenger {
    private String nif;
    private String name;
    private String surName;
    private Integer seatNumber;

    public Passenger(String nif, String name, String surName, Integer seatNumber) {
        this.nif = nif;
        this.name = name;
        this.surName = surName;
        this.seatNumber = seatNumber;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(nif, passenger.nif) && Objects.equals(name, passenger.name) && Objects.equals(surName, passenger.surName) && Objects.equals(seatNumber, passenger.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surName, seatNumber);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", seatNumber=" + seatNumber +
                '}';
    }
}
