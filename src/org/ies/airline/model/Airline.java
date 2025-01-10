package org.ies.airline.model;

import java.util.Arrays;
import java.util.Objects;

public class Airline {
    private String name;
    private Flight[] flights;

    public Airline(String name, Flight[] flights) {
        this.name = name;
        this.flights = flights;
    }

    public void showInfo() {
        System.out.println("Aerolínea: " + name + "; Vuelos: ");
        for (var flight : flights) {
            flight.showInfo();
        }
    }

    public void showOriginFlights(String origin) {
        for (var flight : flights) {
            if (flight.getOrigin().equals(origin)) {
                flight.showInfo();
            }
        }
    }

    public void showPassengerFlights(String nif) {
        for (var flight : flights) {
            if (flight.hasPassenger(nif)) {
                flight.showInfo();
            }
        }
    }

    public Integer findPassengerSeat(int flightNumber, String nif) {
        var flight = findFlight(flightNumber);
        if (flight != null) {
            var passenger = flight.findPassenger(nif);
            if (passenger != null) {
                return passenger.getSeatNumber();
            }
        }
        return null;
    }

    public Flight findFlight(int flightNumber) {
        for (var flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    public void changeSeat(String nif, Integer seatNumber, Flight flight) {
        var passenger = flight.findPassenger(nif);
        if (passenger != null) {
            passenger.setSeatNumber(seatNumber);
            System.out.println("Asiento cambiado con éxito");
            passenger.showInfo();
        } else {
            System.out.println("Error: pasajero no registrado en el vuelo o NIF erroneo");
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
