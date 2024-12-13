package org.ies.airline.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Airline {
    private String name;
    private Flight[] flights;

    public Airline(String name, Flight[] flights) {
        this.name = name;
        this.flights = flights;
    }

    public Flight findFlight(int flightNumber) {
        for (var flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public Passenger findPassenger(String nif) {
        for (var flight : flights) {
            for (var passenger : flight.getPassengers()) {
                if (passenger.getNif().equals(nif)) {
                    return passenger;
                }
            }
        }
        return null;
    }

    public void changeSeat(String nif, Integer seatNumber) {
        var passenger = findPassenger(nif);
        if (passenger != null) {
            passenger.setSeatNumber(seatNumber);
            System.out.println("Asiento cambiado con éxito");
        } else {
            System.out.println("Error: pasajero no encontrado en el vuelo o NIF erroneo");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(name, airline.name) && Objects.deepEquals(flights, airline.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(flights));
    }

    @Override
    public String toString() {
        return "Airline{" +
                "name='" + name + '\'' +
                ", flights=" + Arrays.toString(flights) +
                '}';
    }
}
