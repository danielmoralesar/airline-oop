package org.ies.airline;

import org.ies.airline.componets.AirlineApp1;
import org.ies.airline.componets.AirlineReader;
import org.ies.airline.componets.FlightReader;
import org.ies.airline.componets.PassengerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var passengerReader = new PassengerReader(scanner);
        var flightReader = new FlightReader(scanner, passengerReader);
        var airlineReader = new AirlineReader(scanner, flightReader);
        var airlineApp1 = new AirlineApp1(scanner, airlineReader);

        System.out.println("¡Bienvenido!");
        airlineApp1.run();
    }
}